package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15971_두로봇 {
	static class Node{
		int num;
		int weight;
		
		Node(int num, int weight){
			this.num = num;
			this.weight = weight;
		}
	}
	
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	static int res = Integer.MAX_VALUE;
	
	static int N,room1,room2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		room1 = Integer.parseInt(st.nextToken());
		room2 = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		visited = new boolean[N+1];
		for(int idx = 0; idx <= N; idx++)
			list.add(new ArrayList<>());
		
		for(int cnt = 0; cnt < N-1; cnt++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end,weight));
			list.get(end).add(new Node(start,weight));
		}
		
		dfs(room1, 0, 0);
		
		System.out.print(res);
	}
	
	static void dfs(int room, int dis, int maxDis) {
		visited[room] = true;
		
		if(room==room2) {
			res = Math.min(dis-maxDis, res);
			return;
		}
		
		for(Node node : list.get(room)) {
			if(!visited[node.num])
				dfs(node.num, dis+node.weight, Math.max(maxDis, node.weight));
		}
	}
}
