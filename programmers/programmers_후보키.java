import java.util.*;

class Solution {
    static int[] comb;
    static String[][] tmpRelation;
    static int columnLength;
    static int rowLength;
    static Set<String> res = new HashSet<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        columnLength = relation[0].length;
        rowLength = relation.length;
        
        tmpRelation = relation;
        comb = new int[columnLength];
        
        for(int cnt = 1; cnt <= relation.length; cnt++){
            comb(0,0,cnt);
        }
        
        answer = res.size();
        return answer;
    }
    
    private static void comb(int start, int cnt, int resCnt){
        if(cnt == resCnt){
            boolean flag = true;
            Set<String> set = new HashSet<>();
            
            outer:
            for(int row = 0; row < rowLength; row++){
                StringBuilder sb = new StringBuilder();
                for(int col = 0; col < resCnt; col++){
                    int selectIdx = comb[col];
                    sb.append(tmpRelation[row][selectIdx]);
                }
                
                if(!set.contains(sb.toString())){
                    set.add(sb.toString());
                }
                else{
                    flag = false;
                    break outer;
                }
            }
            
            if(flag){
                // 후보키 추가 시 최소성 검증
                boolean isMinimal = true;
                int newKeyMask = 0;
                for (int idx = 0; idx < resCnt; idx++) {
                    newKeyMask |= (1 << comb[idx]);
                }

                for (String key : res) {
                    int existingKeyMask = Integer.parseInt(key, 2);
                    if ((existingKeyMask & newKeyMask) == existingKeyMask) {
                        isMinimal = false;
                        break;
                    }
                }

                if (isMinimal) {
                    res.add(Integer.toBinaryString(newKeyMask));
                }
            }
        }
        
        for(int idx = start; idx < columnLength; idx++){
            comb[cnt] = idx;
            comb(idx+1, cnt+1, resCnt);
        }
    }
}