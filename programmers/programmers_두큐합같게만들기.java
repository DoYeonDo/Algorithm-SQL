import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long totalSum = 0;
        long q1Sum = 0;
        for(int num : queue1){
            q1Sum += num;
            totalSum += num;
            q1.offer(num);
        }
        for(int num : queue2){
            totalSum += num;
            q2.offer(num);
        }
        
        if(totalSum %2 != 0)
            return -1;
        
        long target = totalSum / 2;
        
        while(true){
            if(answer > (queue1.length + queue2.length)*2)
                return -1;
            
            if(q1Sum == target)
                break;
            else if(q1Sum > target){
                q1Sum -= q1.peek();
                q2.offer(q1.poll());
            }
            else{
                q1Sum += q2.peek();
                q1.offer(q2.poll());
            }
            
            answer++;
        }
        
        return answer;
    }
}