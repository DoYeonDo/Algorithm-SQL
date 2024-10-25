class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        int x = 0;
        int y = 0;
        
        while(true){
            double dis = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            
            if(dis > d && y == 0)
                break;
            
            if(dis > d){
                x+=k;
                y = 0;
                
                continue;
            }
            
            y+=k;
            answer++;
        }
        
        return answer;
    }
}