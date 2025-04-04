package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
    static int[] comb;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if(k==0)
                break;

            int[] arr = new int[k];
            for(int idx = 0; idx < k; idx++) {
                arr[idx] = Integer.parseInt(st.nextToken());
            }

            comb = new int[6];
            comb(0,0,arr);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void comb(int start, int cnt, int[] arr) {
        if(cnt==6) {
            for(int idx = 0; idx < comb.length; idx++) {
                sb.append(comb[idx]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int idx = start; idx < arr.length; idx++) {
            comb[cnt] = arr[idx];
            comb(idx+1, cnt+1, arr);
        }
    }
}
