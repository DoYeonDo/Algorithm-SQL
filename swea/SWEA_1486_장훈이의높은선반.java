import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,B;
	static int[] subset;
	static boolean[] visited;
	static int minDiff;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
				
		for(int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			subset = new int[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int cnt = 0; cnt < N; cnt++) {
				subset[cnt] = Integer.parseInt(st.nextToken());
			}
			
			minDiff = Integer.MAX_VALUE;
			subset(0);
			sb.append("#"+(tc+1)+" "+minDiff+"\n");
		}
		
		System.out.print(sb);
	}
	
	private static void subset(int cnt) {
		if(N == cnt) {
			int sum = 0; 
			for(int idx = 0; idx < N; idx++) {
				if(visited[idx]) sum += subset[idx];
			}
			
			if(sum>=B)
				minDiff = Math.min(minDiff, sum-B);
			
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
	}
}
