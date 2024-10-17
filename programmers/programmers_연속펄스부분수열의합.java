class Solution {
    public long solution(int[] sequence) {
        long answer = -1;
        
        long purse1 = 0;
        long purse2 = 0;

        boolean isPlus = true;
        for(int num : sequence){
            purse1 += isPlus ? num : -num;
            purse2 += isPlus ? -num : num;
            
            if(purse1 < 0)
                purse1 = 0;
            if(purse2 < 0)
                purse2 = 0;
            
            answer = Math.max(answer, Math.max(purse1, purse2));
            
            isPlus = !isPlus;
        }
        
        return answer;
    }
}