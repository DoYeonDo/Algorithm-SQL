package baekjoon;

import java.util.Scanner;

public class BOJ_2862_수학게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long N = sc.nextLong();
		long[] fibo = new long[80];
		fibo[1] = fibo[2] = 1;
		
		for(int idx = 3; idx < 80; idx++) {
			fibo[idx] = fibo[idx-1] + fibo[idx-2];
		}
		
		while(true) {
			long tmp = N;
			for(int i = 1; i < 80; i++) {
				if(tmp < fibo[i]) {
					tmp = fibo[i-1];
					break;
				}
			}
			
			if(tmp == N)
				break;
			
			N -= tmp;
		}
		
		System.out.print(N);
		sc.close();
	}
}
