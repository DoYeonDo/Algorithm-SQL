package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206_View {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 0; tc < 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] views = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int idx = 0; idx < N; idx++) {
				views[idx] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#"+(tc+1)+" "+canSee(views)+"\n");
		}
		System.out.print(sb);
	}
	
	static int canSee(int[] views) {
		int res = 0;
		
		for(int idx = 2; idx < views.length-2; idx++) {
			int maxHeight = Integer.MIN_VALUE;
			
			maxHeight = Math.max(maxHeight, Math.max(views[idx-2], Math.max(views[idx-1], Math.max(views[idx+1], views[idx+2]))));
			
			if(maxHeight!=Integer.MIN_VALUE&&views[idx]>maxHeight)
				res += views[idx]-maxHeight;
		}
		
		return res;
	}
}
