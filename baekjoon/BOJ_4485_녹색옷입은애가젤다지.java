package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
    static int N;
    static int[][] dist;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            dist = new int[N][N];
            map = new int[N][N];

            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < N; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            for (int row = 0; row < N; row++)
                Arrays.fill(dist[row], Integer.MAX_VALUE);

            dijkstra();

            sb.append("Problem "+(cnt++)+": "+dist[N - 1][N - 1]+"\n");
        }

        System.out.print(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.dist > dist[current.row][current.col]) continue;

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = current.row + dx[dir];
                int nextCol = current.col + dy[dir];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;

                int newDist = dist[current.row][current.col] + map[nextRow][nextCol];
                if (newDist < dist[nextRow][nextCol]) {
                    dist[nextRow][nextCol] = newDist;
                    pq.add(new Node(nextRow, nextCol, newDist));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int row, col, dist;

        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
