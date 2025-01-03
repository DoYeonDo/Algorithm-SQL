package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {
	static int[] comb;
	static boolean[] visited;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		comb = new int[N];
		visited = new boolean[N];
		
		perm(0);
		System.out.print(sb);
	}
	
	static void perm(int cnt) {
		if(cnt==N) {
			for(int num : comb)
				sb.append(num+" ");
			sb.append("\n");
			return;
		}
		
		for(int idx = 0; idx < N; idx++) {
			if(!visited[idx]) {
				visited[idx] = true;
				comb[cnt] = idx+1;
				perm(cnt+1);
				visited[idx] = false;
			}
		}
	}
}
