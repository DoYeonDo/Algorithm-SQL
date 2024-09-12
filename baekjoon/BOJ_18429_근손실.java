package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//순열, 백트래킹
public class BOJ_18429_근손실 {
	static int N,K;
	static int[] select;
	static int[] perm;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		select = new int[N];
		perm = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; idx++)
			select[idx] = Integer.parseInt(st.nextToken());
		
		perm(0);
		System.out.print(ans);
	}
	
	private static void perm(int cnt) {
		int weight = 500;
		for(int idx = 0; idx < cnt; idx++) {
			weight += perm[idx] - K;
			
			if(weight < 500)
				return;
		}
		
		if(cnt == N) {
			ans++;
			return;
		}
		
		for(int idx = 0; idx < N; idx++) {
			if(!visited[idx]) {
				visited[idx] = true;
				perm[cnt] = select[idx];
				perm(cnt+1);
				visited[idx] = false;
			}
		}
	}
}
