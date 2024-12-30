package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_30406_산타춘배의선물나눠주기 {
    static int[] presentCnt = new int[4];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int cnt = 0; cnt < N; cnt++) {
            presentCnt[Integer.parseInt(st.nextToken())]++;
        }

        int ans = 0;
        //(0,3),(1,2)일 때 만족도 3을 구할 수 있음
        //(0,2),(1,3)일 때 만족도 2를 구할 수 있음
        //(0,1),(2,3)일 때 만족도 1을 구할 수 있음
        ans += calc(0,3); // 3
        ans += calc(1,2); // 3
        ans += calc(0,2); // 2
        ans += calc(1,3); // 2
        ans += calc(2,3); // 1
        ans += calc(0,1); // 1

        System.out.println(ans);
    }

    private static int calc(int a, int b) {
        int pairedCnt = Math.min(presentCnt[a], presentCnt[b]);
        if(pairedCnt==0) return 0;

        presentCnt[a] -= pairedCnt;
        presentCnt[b] -= pairedCnt;

        return pairedCnt * (a^b);
    }
}
