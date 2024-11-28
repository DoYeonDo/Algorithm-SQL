package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15666_N과M12 {
    static int[] comb;
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] sArr = sc.nextLine().split(" ");
        N = Integer.parseInt(sArr[0]);
        M = Integer.parseInt(sArr[1]);

        arr = new int[N];
        sArr = sc.nextLine().split(" ");
        for (int idx = 0; idx < N; idx++)
            arr[idx] = Integer.parseInt(sArr[idx]);

        Arrays.sort(arr);
        comb = new int[M];
        combination(0, 0);
        sc.close();
    }

    private static void combination(int start, int depth) {
        if (depth == M) {
            for (int num : comb) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for (int idx = start; idx < N; idx++) {
            if (arr[idx] != prev) {
                comb[depth] = arr[idx];
                combination(idx, depth + 1);
                prev = arr[idx];
            }
        }
    }
}
