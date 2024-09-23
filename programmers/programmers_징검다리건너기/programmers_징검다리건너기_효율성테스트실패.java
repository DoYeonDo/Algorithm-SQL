import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        while(true){
            int minVal = 1;
            for(int stone : stones) {
            	if(stone==0)
            		continue;
                minVal = Math.min(minVal, stone);
            }
            
            for(int idx = 0; idx < stones.length; idx++) {
            	if(stones[idx]==0)
            		continue;
                stones[idx] -= minVal;
            }
            
            //한 번에 건너뛸 수 있는 디딤돌의 최대 칸수를 넘지 않는지 확인
            if(!skipStone(stones, k))
                break;
            
            answer += minVal;
        }
        
        return answer+1;
    }
    
    private static boolean skipStone(int[] stones, int k){
    	List<Integer> list = new ArrayList<>();
    	list.add(0);
    	
        //0이 아닌 곳의 위치를 찾는다.
    	for(int idx = 0; idx < stones.length; idx++)
    		if(stones[idx]!=0)
    			list.add(idx+1);
    	
    	list.add(stones.length+1);
    	
    	for(int idx = 0; idx < list.size()-1; idx++) {
    		if(list.get(idx+1) - list.get(idx) > k) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}