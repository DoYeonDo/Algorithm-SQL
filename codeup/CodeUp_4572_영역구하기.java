package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeUp_4572_영역구하기 {
	static int M,N,K;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		visited = new boolean[M][N];
		
		for(int cnt = 0; cnt < K; cnt++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			fillRectangle(y1, x1, y2, x2);
		}
		
		int res = 0;
		List<Integer> areas = new ArrayList<>();
		for(int row = 0; row < M; row++) {
			for(int col = 0; col < N; col++) {
				if(!map[row][col] && !visited[row][col]) {
					int area = bfs(row, col);
					areas.add(area);
					res++;
				}
			}
		}
		
		Collections.sort(areas);
		
		System.out.println(res);
		for(int area : areas)
			System.out.print(area+" ");
	}
	
	static void fillRectangle(int y1, int x1, int y2, int x2) {
		for(int y = y1; y < y2; y++) {
			for(int x = x1; x < x2; x++) {
				map[y][x] = true;
			}
		}
	}
	
	static int bfs(int row, int col) {
		int area = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row,col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			area++;
			
			for(int dir = 0; dir < 4; dir++) {
				int nextRow = curRow + dx[dir];
				int nextCol = curCol + dy[dir];
				
				if(0>nextRow || nextRow>=M || 0>nextCol || nextCol>=N) continue;
				
				if(!map[nextRow][nextCol] && !visited[nextRow][nextCol]) {
					visited[nextRow][nextCol] = true;
					queue.offer(new int[] {nextRow, nextCol});
				}
			}
		}
		
		return area;
	}
}
