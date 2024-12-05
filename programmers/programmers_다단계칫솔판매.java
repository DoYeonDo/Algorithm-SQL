import java.util.*;

class Solution {
    static Map<String, String> hierarchy = new HashMap<>();
    static Map<String, Integer> priceMap = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        hierarchy.put("-", "x");
        priceMap.put("-", 0);
        
        for(int idx = 0; idx < enroll.length; idx++){
            hierarchy.put(enroll[idx], referral[idx]);
            priceMap.put(enroll[idx], 0);
        }
        
        
        for(int idx = 0; idx < seller.length; idx++){
            String sellerName = seller[idx];
            int value = amount[idx];
            
            dfs(sellerName, value*100);
        }
        
        for(int idx = 0; idx < enroll.length; idx++){
            answer[idx] = priceMap.get(enroll[idx]);
        }
        
        return answer;
    }
    
    private static void dfs(String sellerName, int value){
        if(sellerName.equals("x"))
            return;
        
        int price = (int)(value*0.1);
        int curPrice = priceMap.get(sellerName);
        
        //1원 미만일 경우 자신이 모두 가진다.
        if(price < 1){
            priceMap.put(sellerName, curPrice+value);
            
            return;
        }
        else{
            int remainPrice = value - price;
            
            dfs(hierarchy.get(sellerName), price);
            priceMap.put(sellerName, curPrice+remainPrice);
        }
    }
}