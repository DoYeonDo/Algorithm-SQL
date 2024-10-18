import java.util.*;

class Solution {
    static class Info {
        int row;
        int col;
        int dis;

        Info(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public int solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        
        int leverDistance = bfs(maps, 'S', 'L');
        if (leverDistance == -1) return -1;
        
        visited = new boolean[maps.length][maps[0].length()];
        int exitDistance = bfs(maps, 'L', 'E');
        if (exitDistance == -1) return -1;
        
        return leverDistance + exitDistance;
    }

    private static int bfs(String[] maps, char startChar, char endChar) {
        int startRow = -1;
        int startCol = -1;

        // 시작 지점 찾기
        for (int row = 0; row < maps.length; row++) {
            for (int col = 0; col < maps[row].length(); col++) {
                if (maps[row].charAt(col) == startChar) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        Queue<Info> queue = new LinkedList<>();
        visited[startRow][startCol] = true;
        queue.offer(new Info(startRow, startCol, 0));

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            int curRow = info.row;
            int curCol = info.col;
            int curDis = info.dis;

            if (maps[curRow].charAt(curCol) == endChar) {
                return curDis;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = curRow + dx[dir];
                int nextCol = curCol + dy[dir];

                if (nextRow < 0 || nextRow >= maps.length || nextCol < 0 || nextCol >= maps[0].length()
                        || visited[nextRow][nextCol] || maps[nextRow].charAt(nextCol) == 'X') continue;

                visited[nextRow][nextCol] = true;
                queue.offer(new Info(nextRow, nextCol, curDis + 1));
            }
        }

        return -1;
    }
}
