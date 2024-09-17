package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//출발점, 도착점을 둘러싸는 원이 몇개인가
public class BOJ_1004_어린왕자 {
	static int startX, startY;
	static int destX, destY;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			destX = Integer.parseInt(st.nextToken());
			destY = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			for(int planetCnt = 0; planetCnt < n; planetCnt++) {
				st = new StringTokenizer(br.readLine());
				
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				cnt += isInPlanet(cx, cy, r);
			}
			
			sb.append(cnt+"\n");
		}
		
		System.out.print(sb);
	}
	
	//행성 내부에 있는가
	private static int isInPlanet(int cx, int cy, int r) {
		boolean startInside = Math.pow(startX-cx, 2) + Math.pow(startY-cy, 2) < Math.pow(r, 2);
	        boolean destInside = Math.pow(destX-cx, 2) + Math.pow(destY-cy, 2) < Math.pow(r, 2);
	        
	        // 출발점과 도착점이 모두 원 안에 있는 경우, 통과하지 않음
	        if (startInside && destInside) {
	            return 0;
	        }
	        // 하나만 원 안에 있는 경우 카운트 증가
	        else if (startInside || destInside) {
	            return 1;
	        }
	        
	        return 0;
	}
}
