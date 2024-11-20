package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1034_램프 {
	static int N,M;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N];
		
		for(int row = 0; row < N; row++) {
			String str = br.readLine();
			for(int col = 0; col < M; col++) {
				arr[row][col] = str.charAt(col) - '0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		int res = 0;
		for(int row = 0; row < N; row++) {
			if(visited[row])
				continue;
			
			visited[row] = true;
			
			int ramp0 = 0;
			for(int num : arr[row]) {
				if(num == 0)
					ramp0++;
			}
			
			int sameCnt = sameRowCnt(row);
			if(K % 2 == ramp0%2 && K >= ramp0) {
				res = Math.max(res, sameCnt);
			}			
		}
		
		System.out.println(res);

	}
	
	private static int sameRowCnt(int row) {
		int cnt = 0;
		
		for(int idx = 0; idx < N; idx++) {
			if(Arrays.equals(arr[row], arr[idx])) {
				visited[idx] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
}
