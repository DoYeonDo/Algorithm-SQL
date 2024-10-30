package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

//그리디
public class BOJ_1049_기타줄 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = Integer.MAX_VALUE;
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] pack = new int[M];
		int[] notPack = new int[M];
		
		for(int idx = 0; idx < M; idx++) {
			int packPrice = sc.nextInt();
			int notPackPrice = sc.nextInt();
			
			pack[idx] = packPrice;
			notPack[idx] = notPackPrice;
		}
		
		Arrays.sort(pack);
		Arrays.sort(notPack);
		
		//패키지로만 사는 경우, 낱개로만 사는 경우, 패키지+낱개로 사는 경우
		min = Math.min(min, (N/6+1)*pack[0]);
		min = Math.min(min, notPack[0]*N);
		min = Math.min(min, (N/6)*pack[0] + (N%6)*notPack[0]);
		
		System.out.print(min);
		sc.close();
	}

}
