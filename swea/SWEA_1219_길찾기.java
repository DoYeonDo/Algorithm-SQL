package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1219_길찾기 {
	static List<Integer>[] route;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			route = new ArrayList[100];
			for(int idx = 0; idx < 100; idx++)
				route[idx] = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			int testcase = Integer.parseInt(st.nextToken());
			int pair = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int cnt = 0; cnt < pair; cnt++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				route[start].add(end);
			}
			
			sb.append("#"+tc+" "+(bfs()?1:0)+"\n");
		}
		
		System.out.print(sb);
	}
	static boolean bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur==99) {
				return true;
			}
			
			for(int idx = 0; idx < route[cur].size(); idx++) {
				int next = route[cur].get(idx);
				
				queue.offer(next);
			}
		}
		
		return false;
	}
}
