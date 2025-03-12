package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2525_오븐시계 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int C = Integer.parseInt(br.readLine());
		int afterH = C/60;
		int afterM = C%60;
		
		int resultH = A;
		int resultM = 0;
		if(B+afterM>=60) {
			resultH++;
			resultM = (B+afterM)%60;
		}
		else {
			resultM = B+afterM;
		}
		
		resultH = resultH+afterH < 24 ? resultH+afterH : (resultH+afterH)%24;
		
		System.out.print(resultH+" "+resultM);
	}

}
