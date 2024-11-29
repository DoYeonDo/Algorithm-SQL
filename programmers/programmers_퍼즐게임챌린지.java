class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int low = 1;
        int high = 100000;
        int answer = 0;
        
        while (low <= high) {
            int level = (low+high)/2;
            long totalTime = 0;

            for (int idx = 0; idx < diffs.length; idx++) {
                if(idx==0){
                    totalTime += times[idx];
                    continue;
                }
                
                if(diffs[idx] > level)
                    totalTime += (times[idx]+times[idx-1])*(diffs[idx]-level)+times[idx];
                else
                    totalTime += times[idx];
            }

            if (totalTime <= limit) {
                answer = level;
                high = level-1;
            } else {
                low = level+1;
            }
        }
        
        return answer;
    }
}
