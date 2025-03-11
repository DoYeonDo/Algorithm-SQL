package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28018_시간이겹칠까 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[1000002];
		
		for(int cnt = 0; cnt < N; cnt++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			time[S]++;
			time[E+1]--;
		}
		
		for(int idx = 1; idx <= 1000001; idx++) {
			time[idx] += time[idx-1]; 
		}
		
		int Q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int cnt = 0; cnt < Q; cnt++) {
			int sQ = Integer.parseInt(st.nextToken());
			
			sb.append(time[sQ]+"\n");
		}
		
		System.out.print(sb);
	}

}
