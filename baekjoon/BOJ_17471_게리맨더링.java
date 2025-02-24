package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17471_게리맨더링 {
    static int N;
    static int[] people;
    static int totalPeople;
    static List<ArrayList<Integer>> list;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            people[idx] = Integer.parseInt(st.nextToken());
            totalPeople += people[idx];
        }

        list = new ArrayList<>();
        for (int idx = 0; idx <= N; idx++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int areaCnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < areaCnt; j++) {
                int areaNum = Integer.parseInt(st.nextToken());
                list.get(i).add(areaNum);
                list.get(areaNum).add(i);
            }
        }

        for (int divide = 1; divide <= N / 2; divide++) {
            int[] select = new int[divide];
            comb(1, 0, divide, select);
        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    static void comb(int start, int cnt, int selectCnt, int[] select) {
        if (cnt == selectCnt) {
            if (isConnected(select)) {
                int divideSum = 0;
                for (int num : select) {
                    divideSum += people[num];
                }
                res = Math.min(res, Math.abs(totalPeople - 2 * divideSum));
            }
            return;
        }

        for (int num = start; num <= N; num++) {
            select[cnt] = num;
            comb(num + 1, cnt + 1, selectCnt, select);
        }
    }

    static boolean isConnected(int[] select) {
        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();
        boolean[] isGroupA = new boolean[N + 1];

        for (int num : select) {
            groupA.add(num);
            isGroupA[num] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (!isGroupA[i]) {
                groupB.add(i);
            }
        }


        return bfs(groupA, isGroupA) && bfs(groupB, isGroupA);
    }

    static boolean bfs(List<Integer> group, boolean[] isGroupA) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(group.get(0));
        visited[group.get(0)] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : list.get(current)) {
                if (!visited[neighbor] && isGroupA[neighbor] == isGroupA[group.get(0)]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }

        return count == group.size();
    }
}
