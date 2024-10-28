package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈 {
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int R,C,K;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int row = 0; row < R; row++) {
			String str = br.readLine();
			for(int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col);
			}
		}
		
		dfs(R-1, 0, 1);
		
		System.out.print(ans);
	}
	
	private static void dfs(int row, int col, int dis) {
		if(dis == K && row==0 && col==C-1) {
			ans++;
			return;
		}
		
		visited[row][col] = true;
		
		for(int dir = 0; dir < 4; dir++) {
			int nr = row + dx[dir];
			int nc = col + dy[dir];
			
			if(0>nr || nr>=R || 0>nc || nc>=C || visited[nr][nc]
					|| map[nr][nc] == 'T') continue;
			
			dfs(nr, nc, dis+1);
		}
		
		visited[row][col] = false;
	}
}
