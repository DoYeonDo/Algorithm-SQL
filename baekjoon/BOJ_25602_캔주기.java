package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25602_캔주기 {
	static int N,K;
	static int[] A;
	static int[][] R;
	static int[][] M;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		R = new int[K][N];
		M = new int[K][N];
				
		st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; idx++) {
			A[idx] = Integer.parseInt(st.nextToken());
		}
		
		for(int row = 0; row < K; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; col++) {
				R[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int row = 0; row < K; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; col++) {
				M[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0,0,0);
		System.out.print(max);
	}
	
	private static void perm(int cnt, int rang, int mary) {
		if(cnt == K) {
			max = Math.max(max, rang+mary);
			return;
		}
		
		for(int r = 0; r < N; r++) {
			int newRang = rang;
			int newMary = mary;
			
			if(A[r] > 0) {
				A[r]--;
				newRang += R[cnt][r];
				for(int m = 0; m < N; m++) {
					if(A[m] > 0) {
						A[m]--;
						newMary += M[cnt][m];
						perm(cnt+1, newRang, newMary);
						newMary -= M[cnt][m];
						A[m]++;
					}
				}
				newRang -= R[cnt][r];
				A[r]++;
			}
		}
	}
}
