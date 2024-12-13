import java.util.*;

class Solution {
    static class Info{
        int row;
        int col;
        int useShoesCnt;
        int time;
        
        Info(int row, int col, int useShoesCnt, int time){
            this.row = row;
            this.col = col;
            this.useShoesCnt = useShoesCnt;
            this.time = time;
        }
    }
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] shoesDx = {-2,2,0,0};
    static int[] shoesDy = {0,0,-2,2};
    
    static int N,M;
    static boolean[][] map;
    static boolean[][][] visited;
    static int res;
    
    public int solution(int n, int m, int[][] hole) {
        int answer = 0;
        
        N = m;
        M = n;
        map = new boolean[N][M];
        visited = new boolean[N][M][2];
        
        for(int[] holeLoc : hole){
            int row = N-holeLoc[1];
            int col = holeLoc[0]-1;
            
            map[row][col] = true;
        }
        
        res = -1;
        bfs(N-1, 0);
        answer = res;
        
        return answer;
    }
    
    private static void bfs(int row, int col){
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(row, col, 0, 0));
        visited[row][col][0] = true;
        
        while(!queue.isEmpty()){
            Info info = queue.poll();
            int curRow = info.row;
            int curCol = info.col;
            int useShoesCnt = info.useShoesCnt;
            int time = info.time;
            
            if(curRow==0 && curCol==M-1){
                res = info.time;
                return;
            }
            
            for(int dir = 0; dir < 4; dir++){
                int nextRow = curRow + dx[dir];
                int nextCol = curCol + dy[dir];
                
                if(isInArea(nextRow, nextCol) && !visited[nextRow][nextCol][useShoesCnt]){
                    if(!map[nextRow][nextCol]){
                        visited[nextRow][nextCol][useShoesCnt] = true;
                        queue.offer(new Info(nextRow, nextCol, useShoesCnt, time+1));
                    }
                }
            }
            
            if(useShoesCnt == 0){
                for(int dir = 0; dir < 4; dir++){
                    int nextRow = curRow + shoesDx[dir];
                    int nextCol = curCol + shoesDy[dir];
                    
                    if(isInArea(nextRow, nextCol) && !visited[nextRow][nextCol][useShoesCnt+1]){
                        if(!map[nextRow][nextCol]){
                            visited[nextRow][nextCol][useShoesCnt+1] = true;
                            queue.offer(new Info(nextRow, nextCol, useShoesCnt+1, time+1));
                        }
                    }
                }
            }
        }
    }
    
    private static boolean isInArea(int row, int col){
        return 0<=row && row<N && 0<=col && col<M;
    }
}