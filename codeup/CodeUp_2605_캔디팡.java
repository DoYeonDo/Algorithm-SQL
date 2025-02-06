package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeUp_2605_캔디팡 {
	static int[][] map = new int[7][7];
	static boolean[][] visited = new boolean[7][7];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int row = 0; row < 7; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < 7; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int row = 0; row < 7; row++) {
			for(int col = 0; col < 7; col++) {
				if(!visited[row][col])
					bfs(row, col);
			}
		}
		
		System.out.print(res);
	}
	
	static void bfs(int row, int col) {
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row,col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			cnt++;
			int curRow = cur[0];
			int curCol = cur[1];
			
			for(int dir = 0; dir < 4; dir++) {
				int nextRow = curRow + dx[dir];
				int nextCol = curCol + dy[dir];
				
				if(0>nextRow || nextRow>=7 || 0>nextCol || nextCol>=7 
						|| visited[nextRow][nextCol]) continue;
				
				if(map[curRow][curCol]==map[nextRow][nextCol]) {
					visited[nextRow][nextCol] = true;
					queue.offer(new int[] {nextRow, nextCol});
				}
			}
		}
		
		if(cnt>=3)
			res++;
	}
}
