import java.util.*;

class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxLength = -1;

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
           int sqrt = (int)(Math.sqrt(num));

           if(sqrt*sqrt == num && map.containsKey(sqrt)){
                map.put(num, map.get(sqrt)+1);
                maxLength = Math.max(maxLength, map.get(num));
           }
           else{
                map.put(num, 1);
           }
        }

        return maxLength;
    }
}