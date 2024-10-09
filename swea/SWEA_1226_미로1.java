import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int startX, startY;
	static int endX, endY;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			
			map = new int[16][16];
			visited = new boolean[16][16];
			for(int row = 0; row < 16; row++) {
				String str = br.readLine();
				for(int col = 0; col < 16; col++) {
					map[row][col] = str.charAt(col) - '0';
					
					if(map[row][col] == 2) {
						startX = row;
						startY = col;
					}
					else if(map[row][col] == 3) {
						endX = row;
						endY = col;
					}
				}
			}
			
			sb.append("#"+tc+" "+(bfs()?1:0)+"\n");
		}
		
		System.out.print(sb);
	}
	
	private static boolean bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startX, startY});
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			
			int curX = loc[0];
			int curY = loc[1];
			
			if(curX==endX && curY==endY)
				return true;
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				if(!isInArea(nextX, nextY) || visited[nextX][nextY] || map[nextX][nextY]==1) continue;
				
				visited[nextX][nextY] = true;
				queue.offer(new int[] {nextX, nextY});
			}
		}
		
		return false;
	}
	
	private static boolean isInArea(int x, int y) {
		return 0<=x && x<16 && 0<=y && y<16;
	}
}
