package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_26269_세번이내에사과를먹자 {
	static int[][] map;
	static boolean res;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[5][5];
		for(int row = 0; row < 5; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < 5; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int eatApple = (map[r][c]==1)?1:0;
		dfs(r,c,eatApple,0);
		
		System.out.print(res?1:0);
	}
	
	static void dfs(int r, int c, int eatApple, int cnt) {
		if(res) return;
		
		if(eatApple==2) {
			res = true;
			return;
		}
		
		if(cnt==3)
			return;
		
		int tmp = map[r][c];
		map[r][c] = -1;
		
		for(int dir = 0; dir < 4; dir++) {
			int nextR = r + dx[dir];
			int nextC = c + dy[dir];
			
			if(0>nextR || nextR>=5 || 0>nextC || nextC>=5
					|| map[nextR][nextC]==-1) continue;
			
			if(map[nextR][nextC]==1)
				dfs(nextR, nextC, eatApple+1, cnt+1);
			else
				dfs(nextR, nextC, eatApple, cnt+1);
		}
		
		map[r][c] = tmp;
	}
}
