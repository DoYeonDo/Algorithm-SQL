package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	//1시간 뒤에 녹을 치즈 위치 저장
	static List<int[]> cheese = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(noCheese())
			System.out.print(0);
		else {
			int hour = 0;
			while(!noCheese()) {
				removeCheese();
				
				hour++;
			}
			
			System.out.print(hour);
		}
	}
	
	//치즈 제거
	private static void removeCheese() {
		int[][] tmp = isCheeseOutside();
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				int cnt = 0;
				if(tmp[row][col]==1) {
					//상
					if(row-1>=0 && tmp[row-1][col]==-1)
						cnt++;
					//하
					if(row+1<N && tmp[row+1][col]==-1)
						cnt++;
					//좌
					if(col-1>=0 && tmp[row][col-1]==-1)
						cnt++;
					//우
					if(col+1<M && tmp[row][col+1]==-1)
						cnt++;
				}
				
				
				if(cnt>=2) {
					cheese.add(new int[] {row, col});
				}
			}
		}
		
		for(int idx = cheese.size()-1; idx>=0; idx--) {
			int[] loc = cheese.remove(idx);
			
			map[loc[0]][loc[1]] = 0;
		}
	}
	
	//치즈 외부의 공간인가
	private static int[][] isCheeseOutside() {
		int[][] tmp = new int[N][M];
		for(int row = 0; row < N; row++)
			tmp[row] = map[row].clone();
		
		boolean[][] visited = new boolean[N][M];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.offer(new int[]{0, 0});
	        visited[0][0] = true;
	        tmp[0][0] = -1; 
	
	        while (!queue.isEmpty()) {
	            int[] cur = queue.poll();
	            int x = cur[0];
	            int y = cur[1];
	
	            for (int d = 0; d < 4; d++) {
	                int nx = x + dx[d];
	                int ny = y + dy[d];
	
	                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
	                    if (tmp[nx][ny] <= 0) {
	                        visited[nx][ny] = true;
	                        tmp[nx][ny] = -1;
	                        queue.offer(new int[]{nx, ny});
	                    }
	                }
	            }
	        }
		
		return tmp;
	}
	
	//치즈가 모두 녹아 없어졌는가
	private static boolean noCheese() {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(map[row][col]!=0)
					return false;
			}
		}
		
		return true;
	}
}
