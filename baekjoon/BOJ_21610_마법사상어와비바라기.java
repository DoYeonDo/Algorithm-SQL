package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {
	//map의 크기 N by N
	static int N;
	//명령어 수
	static int M;
	static int[][] map;
	static boolean[][] isInCloud;
	static List<int[]> clouds = new ArrayList<>();
	
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		isInCloud = new boolean[N][N];
		
		//초기 구름의 위치
		clouds.add(new int[] {N-2,0});
		clouds.add(new int[] {N-2,1});
		clouds.add(new int[] {N-1,0});
		clouds.add(new int[] {N-1,1});
		
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int cnt = 0; cnt < M; cnt++) {
			st = new StringTokenizer(br.readLine());
			//방향
			int di = Integer.parseInt(st.nextToken());
			//거리
			int si = Integer.parseInt(st.nextToken());
			
			//구름 이동
			moveClouds(di, si);
			
			//구름이 있는 칸에 비가 1씩 내림
			rainy();
			
			//대각선 위치의 물의 양 상태에 따라 해당 칸의 물의 양 증가
			increaseWater();
			
			//구름이 다시 생성
			generateClouds();
		}
		
		System.out.print(totalWaterAmount());
	}
	
	private static void moveClouds(int dir, int dis) {
		for(int idx = 0; idx < clouds.size(); idx++) {
			int[] cloud = clouds.get(idx);
			
			int row = cloud[0];
			int col = cloud[1];
			
			row += dx[dir] * dis;
			col += dy[dir] * dis;
			
			if(row<0) {
				while(row<0)
					row += N;
			}
			if(row>=N) {
				while(row>=N)
					row -= N;
			}
			if(col<0) {
				while(col<0)
					col += N;
			}
			if(col>=N) {
				while(col>=N)
					col -= N;
			}
			
			cloud[0] = row;
			cloud[1] = col;
		}
	}
	
	private static void rainy() {
		for(int idx = 0; idx < clouds.size(); idx++) {
			map[clouds.get(idx)[0]][clouds.get(idx)[1]]++;
		}
	}
	
	private static void increaseWater() {
		int[] dx = {-1,-1,1,1};
		int[] dy = {-1,1,-1,1};
		for(int idx = 0; idx < clouds.size(); idx++) {
			int water = 0;
			
			int row = clouds.get(idx)[0];
			int col = clouds.get(idx)[1];
			
			for(int dir = 0; dir < 4; dir++) {
				int nextRow = row + dx[dir];
				int nextCol = col + dy[dir];
				
				if(0<=nextRow && nextRow<N && 0<=nextCol && nextCol<N) {
					if(map[nextRow][nextCol]>0)
						water++;
				}
			}
			
			map[row][col] += water;
		}
	}
	
	private static void generateClouds() {
		for(int row = 0; row < N; row++)
			Arrays.fill(isInCloud[row], false);
		
		for(int idx = 0; idx < clouds.size(); idx++) {
			int row = clouds.get(idx)[0];
			int col = clouds.get(idx)[1];
			
			isInCloud[row][col] = true;
		}
		
		clouds.clear();
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(map[row][col] >= 2) {
					if(!isInCloud[row][col]) {
						clouds.add(new int[] {row, col});
						map[row][col] -= 2;
					}
				}
			}
		}
	}
	
	private static int totalWaterAmount() {
		int totalWater = 0;
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				totalWater += map[row][col];
			}
		}
		
		return totalWater;
	}
}
