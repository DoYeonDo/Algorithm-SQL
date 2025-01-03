package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; idx++)
			arr[idx] = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = i; j < N; j++) {
				sum += arr[j];
				
				if(sum==M) {
					ans++;
					break;
				}
				if(sum > M)
					break;
			}
		}
		
		System.out.print(ans);
	}

}
