import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class Info {
        int x;
        int y;

        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int row = 0; row < N; row++) {
                String str = br.readLine();
                for (int col = 0; col < str.length(); col++) {
                    map[row][col] = str.charAt(col) - '0';
                }
            }

            ans = new int[N][N];
            for (int row = 0; row < N; row++) {
                Arrays.fill(ans[row], Integer.MAX_VALUE);
            }
            ans[0][0] = 0;

            bfs();
            sb.append("#"+(tc+1)+" "+ans[N-1][N-1]+"\n");
        }
        
        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(0, 0));

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            int curX = info.x;
            int curY = info.y;

            for (int dir = 0; dir < 4; dir++) {
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];

                if (!isInArea(nextX, nextY)) continue;

                if (ans[nextX][nextY] > ans[curX][curY] + map[nextX][nextY]) {
                    ans[nextX][nextY] = ans[curX][curY] + map[nextX][nextY];
                    queue.offer(new Info(nextX, nextY));
                }
            }
        }
    }

    private static boolean isInArea(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
