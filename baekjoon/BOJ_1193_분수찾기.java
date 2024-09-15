package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193_분수찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int cnt=1;
		int up = 1; // 분자(row)
		int down = 1; // 분모(column)
		while(cnt < X) {
			//오른쪽 한 번
			down++;
			cnt++;
			
			if(cnt==X)
				break;
			
			//왼쪽 아래 대각선은 column(분자)이 1이 될때까지 이동
			//row는 증가
			while(down > 1) {
				if(cnt==X)
					break;
				down--;
				up++;
				cnt++;
			}
			
			if(cnt==X)
				break;
			
			//아래쪽 한 번
			up++;
			cnt++;
			
			if(cnt==X)
				break;
			
			//오른쪽 위 대각선은 row(분모)가 1이 될때까지 이동
			//column은 증가
			while(up > 1) {
				if(cnt==X)
					break;
				up--;
				down++;
				cnt++;
			}
		}
		
		System.out.print(up+"/"+down);
	}
}
