import java.util.*;

class Solution {
    public String solution(String input_string) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> resultList = new ArrayList<>();
        
        char prevCh = input_string.charAt(0);
        map.put(prevCh, 1);
        
        int firstIdx = startIdx(input_string);
        for(int idx = firstIdx; idx < input_string.length(); idx++){
            char curCh = input_string.charAt(idx);
            if(prevCh != curCh){
                if(map.containsKey(curCh) && !resultList.contains(curCh)){
                    resultList.add(curCh);
                }
                else
                    map.put(curCh, 1);
                
                prevCh = curCh;
            }
        }
        
        if(resultList.size()==0)
            return "N";
        
        Collections.sort(resultList);
        StringBuilder sb = new StringBuilder();
        for(char ch : resultList)
            sb.append(ch);
        
        return sb.toString();
    }
    
    static int startIdx(String input_string){
        char prevCh = input_string.charAt(0);
        
        for(int idx = 1; idx < input_string.length(); idx++){
            char curCh = input_string.charAt(idx);
            
            if(prevCh != curCh)
                return idx;
        }
        
        return input_string.length();
    }
}