import java.util.*;

class Solution {
    static class StopPlan{
        String name;
        int remainMinute;
        
        StopPlan(String name, int remainMinute){
            this.name = name;
            this.remainMinute = remainMinute;
        }
    }
    //잠시 멈춘 과제를 저장하고 있는 스택
    static Stack<StopPlan> stack = new Stack<>();
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Arrays.sort(plans, new Comparator<String[]>(){
            @Override
            public int compare(String[] sArr1, String[] sArr2){
                return sArr1[1].compareTo(sArr2[1]);
            }
        });
        
        int cnt = 0;
        for(int idx = 0; idx < plans.length-1; idx++){
            int diffMin = diffMinute(plans[idx][1], plans[idx+1][1]);
            int runTime = Integer.parseInt(plans[idx][2]);
            
            if(diffMin < runTime){
                stack.push(new StopPlan(plans[idx][0], runTime-diffMin));
            }
            else if(diffMin > runTime){
                answer[cnt++] = plans[idx][0];
                int chaMin = diffMin - runTime;
                
                while(!stack.isEmpty() && chaMin > 0){
                    StopPlan recentPlan = stack.pop();
                    
                    if(recentPlan.remainMinute <= chaMin){
                        chaMin -= recentPlan.remainMinute;
                        answer[cnt++] = recentPlan.name;
                    }
                    else{
                        recentPlan.remainMinute -= chaMin;
                        chaMin = 0;
                        stack.push(recentPlan);
                    }
                }
            }
            else{
                answer[cnt++] = plans[idx][0];
            }
        }
        
        answer[cnt++] = plans[plans.length-1][0];
        while(!stack.isEmpty()){
            answer[cnt++] = stack.pop().name;
        }
        
        return answer;
    }
    
    private static int diffMinute(String time1, String time2){
        int totalMinute = 0;
        
        String[] sArr1 = time1.split(":");
        String[] sArr2 = time2.split(":");
        
        int hour1 = Integer.parseInt(sArr1[0]);
        int minute1 = Integer.parseInt(sArr1[1]);
        
        int hour2 = Integer.parseInt(sArr2[0]);
        int minute2 = Integer.parseInt(sArr2[1]);
        
        if(minute2 < minute1){
            totalMinute += (60+minute2) - minute1;
            totalMinute += (hour2-hour1-1) * 60;
        }
        else{
            totalMinute += minute2 - minute1;
            totalMinute += (hour2-hour1) * 60;
        }
        
        return totalMinute;
    }
}