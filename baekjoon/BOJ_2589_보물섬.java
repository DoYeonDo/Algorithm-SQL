package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int row = 0; row < N; row++) {
            map[row] = br.readLine().toCharArray();
        }

        int maxDistance = 0;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (map[row][col] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(row, col));
                }
            }
        }

        System.out.println(maxDistance);
    }

    static int bfs(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curDist = cur[2];

            maxDist = Math.max(maxDist, curDist);

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = curRow + dx[dir];
                int nextCol = curCol + dy[dir];

                if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M &&
                        !visited[nextRow][nextCol] && map[nextRow][nextCol] == 'L') {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol, curDist + 1});
                }
            }
        }

        return maxDist;
    }
}
