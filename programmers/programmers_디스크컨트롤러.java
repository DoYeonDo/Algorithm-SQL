import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0;
        int len = jobs.length;
                
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
           @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[1] - arr2[1];
            }
        });
        
        Arrays.sort(jobs, (o1, o2)-> o1[0]-o2[0]);
        
        int curTime = 0;
        while(!pq.isEmpty() || idx < len){
            while(idx < len && jobs[idx][0] <= curTime)
                pq.offer(jobs[idx++]);
            
            if(pq.isEmpty())
                curTime = jobs[idx][0];
            else{
                int[] job = pq.poll();
                curTime += job[1];
                answer += curTime - job[0];
            }
        }
        
        return answer / len;
    }
}