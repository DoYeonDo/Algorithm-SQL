package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] S = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			
			if(idx==0) 
				S[idx] = num;
			
			else
				S[idx] = num + S[idx-1];
			
			idx++;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		int maxVisitor = Integer.MIN_VALUE;
		for(int i = 0; i <= N-X; i++) {
			int visitor = 0;
			if(i==0) {
				visitor = S[i+X-1];
			}
			else {
				visitor = S[i+X-1] - S[i-1];
			}
			maxVisitor = Math.max(maxVisitor, visitor);
			map.put(visitor, map.getOrDefault(visitor, 0)+1);
		}
		
		if(maxVisitor==0)
			System.out.print("SAD");
		else {
			System.out.println(maxVisitor);
			System.out.println(map.get(maxVisitor));
		}
	}
}
