import java.util.*;

//보조 컨테이너는 스택
//컨테이너 벨트는 큐

class Solution {
    public int solution(int[] order) {   
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int idx = 1; idx <= order.length; idx++)
            queue.offer(idx);
        
        int curIdx = 0;
        
        //보조 컨테이너와 컨테이너 모두를 확인하여 꺼낼 상자가 있는지 확인
        while(!queue.isEmpty() || !stack.isEmpty()){
            if(!queue.isEmpty() && queue.peek() == order[curIdx]){
                queue.poll();
                curIdx++;
                answer++;
            }
            else if(!stack.isEmpty() && stack.peek() == order[curIdx]){
                stack.pop();
                curIdx++;
                answer++;
            }
            else if(!queue.isEmpty()){
                stack.push(queue.poll());
            }
            else
                break;
        }
        
        return answer;
    }
}