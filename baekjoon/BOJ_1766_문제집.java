package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int idx = 0; idx <= N; idx++)
			list.add(new ArrayList<>());
		
		int[] indegree = new int[N+1];
		for(int cnt = 0; cnt < M; cnt++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			list.get(p1).add(p2);
			indegree[p2]++;
		}
		
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		for(int idx = 1; idx <= N; idx++) {
			if(indegree[idx]==0)
				pq.offer(idx);
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now+" ");
			
			for(int next : list.get(now)) {
				indegree[next]--;
				if(indegree[next]==0)
					pq.offer(next);
			}
		}
		
		System.out.print(sb);
	}
}
