import java.util.*;

public class Solution {
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		int length = Integer.MAX_VALUE;
		int startIndex = 0;
		int exceptCnt = 0;
		
		Set<String> set = new HashSet<>(Arrays.asList(gems));
		Map<String, Integer> map = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		
		for (int i = 0; i < gems.length; i++) {
			map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
			queue.add(gems[i]);
			
			while (map.get(queue.peek()) > 1) {
				String gemName = queue.poll();
				map.put(gemName, map.get(gemName) - 1);
				exceptCnt++;
			}
			
			if (map.size() == set.size() && length > (i-exceptCnt)) {
				length = i - exceptCnt;
				startIndex = exceptCnt + 1;
			}
		}
		
		answer[0] = startIndex;
		answer[1] = startIndex + length;
				
		return answer;
	}
}