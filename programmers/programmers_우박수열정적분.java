import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        list.add(k);
        
        while(k!=1){
            if(k > 1){
                if(k%2==1){
                    k = k*3+1;
                    list.add(k);
                }
                else{
                    k /= 2;
                    list.add(k);
                }
            }
        }

        
        List<Double> area = new ArrayList<>();
        int prevH = list.get(0);
        for(int idx = 1; idx < list.size(); idx++){
            double ans = 0;
            int curH = list.get(idx);
            
            int minH = Math.min(prevH, curH);
            ans += minH * 1.0 + Math.abs(prevH-curH)/2.0;
            
            prevH = curH;
            area.add(ans);
        }
        
        for(int idx = 0; idx < area.size(); idx++){
            System.out.println(area.get(idx));
        }
        
        int cnt = 0;
        for(int[] range : ranges){
            double res = 0;
            
            int a = range[0];
            int b = list.size()-1+range[1];

            if(a > b){
                answer[cnt++] = -1.0;
                continue;
            }
            
            for(int idx = a; idx < b; idx++)
                res += area.get(idx);
            
            answer[cnt++] = res;
        }
        
        
        return answer;
    }
}