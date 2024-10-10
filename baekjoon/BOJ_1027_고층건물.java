package baekjoon;

import java.util.Scanner;

public class BOJ_1027_고층건물 {
	static int[] buildings;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		buildings = new int[T];
		
		for(int tc = 0; tc < T; tc++) {
			buildings[tc] = sc.nextInt();
		}
		
		int max = 0;
		for(int idx = 0; idx < buildings.length; idx++)
			max = Math.max(max, count(idx));
		
		System.out.print(max);
		sc.close();
	}
	
	private static int count(int idx) {
		int cnt = 0;
		double prevSlope = 0;
		
		//왼쪽 건물 확인
		for(int left = idx-1; left >= 0; left--) {
			double curSlope = (double)(buildings[idx]-buildings[left]) / (idx-left);
			
			//바로 왼쪽 건물은 무조건 보임
			//기울기가 전 건물보다 더 작다면 보임
			if(left == idx-1 || curSlope < prevSlope) {
				cnt++;
				prevSlope = curSlope;
			}
		}
		//오른쪽 건물 확인
		for(int right = idx+1; right < buildings.length; right++) {
			double curSlope = (double)(buildings[idx]-buildings[right]) / (idx-right);

			//바로 오른쪽 건물은 무조건 보임
			//기울기가 전 건물보다 더 크다면 보임
			if(right == idx+1 || curSlope > prevSlope) {
				cnt++;
				prevSlope = curSlope;
			}
		}
		
		return cnt;
	}
}
