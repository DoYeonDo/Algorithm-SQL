import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        return recursive(p);
    }
    
    //올바른 문자열인지 확인
    private static boolean isRightStr(String str){
        Stack<Character> stack = new Stack();
        
        for(int idx = 0; idx < str.length(); idx++){
            char ch = str.charAt(idx);
            
            if(ch=='(')
                stack.push('(');
            else{
                if(stack.isEmpty())
                    return false;
                else{
                    if(stack.pop()!='(')
                        return false;
                }
            }
        }
        
        return true;
    }
    
    private static String recursive(String s){
        if(s.equals(""))
            return "";
        
        //두 문자열 u,v로 분리
        int length = -1;
        int leftCnt = 0;
        int rightCnt = 0;
        for(int idx = 0; idx < s.length()-1; idx+=2){
            if(s.charAt(idx)=='(')
                leftCnt++;
            else
                rightCnt++;
            if(s.charAt(idx+1)=='(')
                leftCnt++;
            else
                rightCnt++;
            
            if(leftCnt==rightCnt){
                length = idx+1;
                break;
            }
        }
        
        String u = s.substring(0,length+1);
        String v = "";
        if(length!=s.length()-1)
            v=s.substring(length+1, s.length());
        
        if(isRightStr(u)){
            String res = recursive(v);
            return u+res;
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(recursive(v));
            sb.append(")");
            
            List<Character> list = new ArrayList<>();
            for(int idx = 1; idx < u.length()-1; idx++)
                list.add(u.charAt(idx));
            
            for(int idx = 0; idx < list.size(); idx++){
                if(list.get(idx)=='(')
                    sb.append(")");
                else
                    sb.append("(");
            }
            
            return sb.toString();
        }
    }
}