import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> set1 = new HashSet<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int t : topping) {
            map2.put(t, map2.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            set1.add(t);
            
            map2.put(t, map2.get(t) - 1);
            if (map2.get(t) == 0) {
                map2.remove(t);
            }

            if (set1.size() == map2.size()) {
                answer++;
            }
        }

        return answer;
    }
}
