import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			
			for(int idx = 0; idx < N; idx++) {
				nums[idx] = sc.nextInt();
			}
			
			set = new HashSet<>();
			set.add(0);
			
			for(int idx = 0; idx < N; idx++) {
				addScore(nums[idx]);
			}
			
			System.out.println("#"+(tc+1)+" "+set.size());
		}
	}
	
	private static void addScore(int score) {
		Set<Integer> tmp = new HashSet<>();
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			tmp.add(it.next()+score);
		}
		
		set.addAll(tmp);
	}
}
