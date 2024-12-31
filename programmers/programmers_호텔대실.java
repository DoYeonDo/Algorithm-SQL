import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, new Comparator<String[]>(){
           public int compare(String[] strArr1, String[] strArr2){
               return strArr1[0].compareTo(strArr2[0]);
           } 
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
           public int compare(int[] intArr1, int[] intArr2){
               return intArr1[1]-intArr2[1];
           } 
        });
        
        for(String[] times: book_time){
            String[] start = times[0].split(":");
            String[] end = times[1].split(":");
            int startTime = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1])+10;
            
            if(pq.isEmpty()){
                answer++;
                pq.offer(new int[]{startTime, endTime});
                continue;
            }
            
            int[] prevTime = pq.poll();
            int prevStart = prevTime[0];
            int prevEnd = prevTime[1];
            
            if(startTime < prevEnd){
                answer++;
                pq.offer(prevTime);
            }
            
            pq.offer(new int[]{startTime, endTime});
        }
        
        
        return answer;
    }
}