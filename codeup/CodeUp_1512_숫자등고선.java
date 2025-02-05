package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CodeUp_1512_숫자등고선 {
	static int[][] map;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		String[] sArr = br.readLine().split(" ");
		int X = Integer.parseInt(sArr[0]);
		int Y = Integer.parseInt(sArr[1]);
		
		bfs(X,Y,1);
		
		for(int row = 1; row <= N; row++) {
			for(int col = 1; col <= N; col++) {
				sb.append(map[row][col]+" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void bfs(int X, int Y, int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {X,Y,num});
		map[X][Y] = num;
		
		while(!queue.isEmpty()) {
			int[] curLoc = queue.poll();
			
			int cX = curLoc[0];
			int cY = curLoc[1];
			int cNum = curLoc[2];
			
			for(int dir = 0; dir < 4; dir++) {
				int nX = cX + dx[dir];
				int nY = cY + dy[dir];
				
				if((nX>=1 && nX<=N && nY>=1 && nY<=N) && 
						map[nX][nY]==0) {
					map[nX][nY] = cNum+1;
					queue.offer(new int[] {nX,nY,cNum+1});
				}
			}
		}
	}
}
