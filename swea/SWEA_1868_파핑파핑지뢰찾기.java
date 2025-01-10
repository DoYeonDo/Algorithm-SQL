package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for(int row = 0; row < N; row++) {
				String str = br.readLine();
				for(int col = 0; col < N; col++) {
					map[row][col] = str.charAt(col);
				}
			}
			
			int minClick = 0;
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					if(findBomb(row,col)==0 && map[row][col]!='*'&&!visited[row][col]) {
						minClick++;
						bfs(row,col);
					}
				}
			}
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					if(map[row][col]=='.') {
						map[row][col] = (char)(findBomb(row,col)+'0');
						visited[row][col] = true;
						minClick++;
					}
				}
			}
			
			sb.append("#"+tc+" "+minClick+"\n");
		}
		
		System.out.print(sb);
	}
	
	static int findBomb(int row, int col) {
		int bombCnt = 0;
		
		for(int dir = 0; dir < 8; dir++) {
			int nextRow = row + dx[dir];
			int nextCol = col + dy[dir];
			
			if(nextRow>=0&&nextRow<N&&nextCol>=0&&nextCol<N) {
				if(map[nextRow][nextCol]=='*')
					bombCnt++;
			}
		}
		
		return bombCnt;
	}
	
	static void bfs(int row, int col) {
		Deque<int[]> deq = new ArrayDeque<>();
		visited[row][col] = true;
		deq.offer(new int[] {row,col});
		
		while(!deq.isEmpty()) {
			int[] cur = deq.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			int bombCnt = findBomb(curRow, curCol);
			map[curRow][curCol] = (char)(bombCnt+'0');
			
			if(bombCnt>0) {
				continue;
			}
			
			for(int dir = 0; dir < 8; dir++) {
				int nextRow = curRow + dx[dir];
				int nextCol = curCol + dy[dir];
				
				if(nextRow>=0&&nextRow<N&&nextCol>=0&nextCol<N
						&& !visited[nextRow][nextCol] && map[nextRow][nextCol]!='*') {
					visited[nextRow][nextCol] = true;
					deq.offer(new int[] {nextRow, nextCol});
				}
			}
		}
	}
}
