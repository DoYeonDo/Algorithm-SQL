package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//이진탐색
public class BOJ_17266_어두운굴다리 {
	static int N,M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < M; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1;
		int right = N;
		int res = 0;
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			if(isAllLight(mid)) {
				res = mid;
				right = mid - 1; 
			}
			else
				left = mid + 1;
		}
		
		System.out.print(res);
	}
	
	//가로등이 모든 거리를 비추고 있는지 확인
	static boolean isAllLight(int target) {
		// 이전 가로등이 비춘 마지막 위치
		int prev = 0;
		
		for(int idx = 0; idx < arr.length; idx++) {
			if(arr[idx] - target <= prev) {
				prev = arr[idx] + target;
			}
			else {
				return false;
			}
		}
		
		return N - prev <= 0;
	}
}
