package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int N,S;
	static int[] arr;
	static boolean[] visited;
	static int res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; idx++)
			arr[idx] = Integer.parseInt(st.nextToken());
		
		subset(0);
		
		System.out.print(res);
	}
	
	private static void subset(int cnt) {
		if(cnt == N) {
			int sum = 0;
			int size = 0;
			
			for(int idx = 0; idx < N; idx++) {
				if(visited[idx]) {
					size++;
					sum += arr[idx];
				}
			}
			
			//공집합 제외
			if(size>0 && sum==S)
				res++;
			
			return;
		}
		
		visited[cnt]=true;
		subset(cnt+1);
		visited[cnt]=false;
		subset(cnt+1);
	}
}
