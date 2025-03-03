package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기2 {
	static class Route{
		int row, col, dis, brokenWallCnt;
		
		Route(int row, int col, int dis, int brokenWallCnt){
			this.row = row;
			this.col = col;
			this.dis = dis;
			this.brokenWallCnt = brokenWallCnt;
		}
	}
	
	static int N,M,K;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		
		for(int row = 0; row < N; row++) {
			String input = br.readLine();
			for(int col = 0; col < M; col++) {
				map[row][col] = input.charAt(col) - '0';
			}
		}
		
		int dis = bfs();
		System.out.print(dis);
	}
	
	static int bfs() {
		Queue<Route> queue = new LinkedList<>();
		queue.offer(new Route(0,0,1,0));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Route route = queue.poll();
			int curRow = route.row;
			int curCol = route.col;
			int curDis = route.dis;
			int curBrokenWallCnt = route.brokenWallCnt;
			
			if(curRow==N-1 && curCol==M-1)
				return curDis;
			
			for(int dir = 0; dir < 4; dir++) {
				int nextRow = curRow + dx[dir];
				int nextCol = curCol + dy[dir];
				
				if(0>nextRow || nextRow>=N || 0>nextCol || nextCol>=M) continue;
				
				if(map[nextRow][nextCol]==0 && !visited[nextRow][nextCol][curBrokenWallCnt]) {
					visited[nextRow][nextCol][curBrokenWallCnt] = true;
					queue.offer(new Route(nextRow, nextCol, curDis+1, curBrokenWallCnt));
				}
				else if(map[nextRow][nextCol]==1) {
					if(curBrokenWallCnt < K && !visited[nextRow][nextCol][curBrokenWallCnt+1]) {
						visited[nextRow][nextCol][curBrokenWallCnt+1] = true;
						queue.offer(new Route(nextRow, nextCol, curDis+1, curBrokenWallCnt+1));
					}
				}
			}
		}
		
		return -1;
	}
}
