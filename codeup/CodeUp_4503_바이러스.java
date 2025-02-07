package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeUp_4503_바이러스 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int idx = 1; idx <= N; idx++)
			parent[idx] = idx;
		
		for(int cnt = 0; cnt < pair; cnt++) {
			String[] sArr = br.readLine().split(" ");
			
			int node1 = Integer.parseInt(sArr[0]);
			int node2 = Integer.parseInt(sArr[1]);
			
			union(node1, node2);
		}
		
		int res = 0;
		for(int idx = 2; idx <= N; idx++) {
			if(checkSame(1, idx))
				res++;
		}
		
		System.out.print(res);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b)
			parent[b] = a;
	}
	
	static int find(int a) {
		if(a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}
	
	static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)
			return true;
		else
			return false;
	}
}
