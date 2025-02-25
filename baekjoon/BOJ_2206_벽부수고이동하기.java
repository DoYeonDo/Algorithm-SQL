package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2206_벽부수고이동하기 {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static class Status {
        int row, col, dis;
        boolean isBrokenWall;
        
        Status(int row, int col, int dis, boolean isBrokenWall) {
            this.row = row;
            this.col = col;
            this.dis = dis;
            this.isBrokenWall = isBrokenWall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int row = 0; row < N; row++) {
            String str = br.readLine();
            for (int col = 0; col < M; col++) {
                map[row][col] = str.charAt(col) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Status> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        
        queue.offer(new Status(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            int curDis = cur.dis;
            boolean curBrokenWall = cur.isBrokenWall;

            if (curRow==N-1 && curCol==M-1) {
                return curDis;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = curRow + dx[dir];
                int nextCol = curCol + dy[dir];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;

                if (map[nextRow][nextCol] == 0) {
                    if (!curBrokenWall && !visited[nextRow][nextCol][0]) { 
                        visited[nextRow][nextCol][0] = true;
                        queue.offer(new Status(nextRow, nextCol, curDis + 1, false));
                    } 
                    else if (curBrokenWall && !visited[nextRow][nextCol][1]) { 
                        visited[nextRow][nextCol][1] = true;
                        queue.offer(new Status(nextRow, nextCol, curDis + 1, true));
                    }
                }
                
                else if (map[nextRow][nextCol] == 1 && !curBrokenWall) {
                    visited[nextRow][nextCol][1] = true;
                    queue.offer(new Status(nextRow, nextCol, curDis + 1, true));
                }
            }
        }

        return -1;
    }
}
