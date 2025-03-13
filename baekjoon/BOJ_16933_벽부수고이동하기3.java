package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16933_벽부수고이동하기3 {
	static class Info{
		int row, col, dis, brokenWallCnt;
		boolean dayORnight;
		
		Info(int row, int col, int dis, int brokenWallCnt, boolean dayORnight){
			this.row = row;
			this.col = col;
			this.dis = dis;
			this.brokenWallCnt = brokenWallCnt;
			this.dayORnight = dayORnight;
		}
	}
	
	static int[][] map;
	static boolean[][][] visited;
	static int N,M,K;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int res = Integer.MAX_VALUE;
	
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
		
		System.out.print(bfs());
	}
	static int bfs() {
		Queue<Info> queue = new LinkedList<>();
		visited[0][0][0] = true;
		queue.offer(new Info(0,0,1,0,true));
		
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			int row = cur.row;
			int col = cur.col;
			int dis = cur.dis;
			int brokenWallCnt = cur.brokenWallCnt;
			boolean dayORnight = cur.dayORnight; 
			
			if(row==N-1 && col==M-1) return dis;
			
			//밤이라면 같은 칸에 머물기
			//다음날에 벽을 부술 가능성이 있기 때문
			if(!dayORnight) {
				visited[row][col][brokenWallCnt] = true;
				queue.offer(new Info(row,col,dis+1,brokenWallCnt,!dayORnight));
			}
			
			for(int dir = 0; dir < 4; dir++) {
				int nextRow = row + dx[dir];
				int nextCol = col + dy[dir];
				
				if(0>nextRow || nextRow>=N || 0>nextCol || nextCol>=M) continue;
				
				if(map[nextRow][nextCol]==0 && !visited[nextRow][nextCol][brokenWallCnt]) {
					visited[nextRow][nextCol][brokenWallCnt] = true;
					queue.offer(new Info(nextRow, nextCol, dis+1, brokenWallCnt, !dayORnight));
				}
				else if(map[nextRow][nextCol]==1 && brokenWallCnt < K && 
						!visited[nextRow][nextCol][brokenWallCnt+1] && dayORnight) {
					visited[nextRow][nextCol][brokenWallCnt+1] = true;
					queue.offer(new Info(nextRow, nextCol, dis+1, brokenWallCnt+1, !dayORnight));
				}
			}
		}
		return -1;
	}
}
