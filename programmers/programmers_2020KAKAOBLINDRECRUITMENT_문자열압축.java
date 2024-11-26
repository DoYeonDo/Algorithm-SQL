class Solution {
    public int solution(String s) {
        int answer = 0;
        int minLength = Integer.MAX_VALUE;
        
        if(s.length()==1)
            return 1;
        
        for(int cnt = 1; cnt <= s.length()/2; cnt++){
            StringBuilder sb = new StringBuilder();
            int num = 1;
            String prevStr = "";
            for(int size = 0; size < s.length()-cnt+1; size+=cnt){
                if(size==0){
                    prevStr = s.substring(0, cnt);
                    continue;
                }
                
                String curStr = s.substring(size, size+cnt);
                if(prevStr.equals(curStr)){
                    num++;
                }
                else{
                    if(num==1)
                        sb.append(prevStr);
                    else
                        sb.append(num+prevStr);
                    prevStr = curStr;
                    num = 1;
                }
            }
            
            if(num==1)
                    sb.append(prevStr);
            else
                sb.append(num+prevStr);
            
            if(s.length()%cnt != 0){
                int remainCnt = s.length() % cnt;
                sb.append(s.substring(s.length()-remainCnt));
            }
            
            minLength = Math.min(minLength, sb.toString().length());
        }
        
        answer = minLength;
        return answer;
    }
}