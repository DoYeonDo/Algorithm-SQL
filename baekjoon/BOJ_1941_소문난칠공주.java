package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1941_소문난칠공주 {
	static char[][] arr = new char[5][5];
	static int[] select = new int[7];
	static boolean[] visited = new boolean[7];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int res;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int row = 0; row < 5; row++) {
			String str = sc.nextLine();
			for(int col = 0; col < 5; col++) {
				arr[row][col] = str.charAt(col);
			}
		}
		
		comb(0,0,0);
		
		System.out.print(res);
	}

	private static void comb(int cnt, int start, int S) {
		//임도연파가 더 많다면 더 이상 보지 않는다.
		if(cnt - S > 3)
			return;
		
		if(cnt == 7) {
			visited = new boolean[7];
			bfs(select[0]/5, select[0]%5);
			return;
		}
		
		for(int idx = start; idx < 25; idx++) {
			int row = idx/5;
			int col = idx%5;
			select[cnt] = idx;
			comb(cnt+1, idx+1, arr[row][col]=='S'?S+1:S);
		}
	}
	
	private static void bfs(int row, int col) {
		int cnt = 1;
		visited[0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});
		
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			int curRow = loc[0];
			int curCol = loc[1];
			
			for(int dir = 0; dir < 4; dir++) {
				int nextRow = curRow + dx[dir];
				int nextCol = curCol + dy[dir];
				
				if(0>nextRow || nextRow>=5 || 0>nextCol || nextCol>=5) continue;
				
				int nextLoc = nextRow*5 + nextCol;
				for(int idx = 0; idx < 7; idx++) {
					if(!visited[idx] && select[idx] == nextLoc) {
						visited[idx] = true;
						cnt++;
						queue.offer(new int[] {nextRow, nextCol});
					}
				}
			}
		}
		
		if(cnt == 7) res++;
	}
}
