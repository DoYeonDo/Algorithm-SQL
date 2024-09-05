import java.util.*;

class Solution {
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
        
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {        
        map = new int[101][101];
        
        for(int[] rec : rectangle)
            makeRectangle(rec[0] * 2, rec[1] * 2, rec[2] * 2, rec[3] * 2);
        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    private static void makeRectangle(int x1, int y1, int x2, int y2){
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                if(map[i][j]==2)
                    continue;
                //내부는 2로 채움
                map[i][j] = 2;
                //가장자리는 1
                if(i==x1 || i==x2 || j==y1 || j==y2)
                    map[i][j] = 1;
            }
        }
    }
    
    //최단 경로로 이동
    private static int bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX, characterY});
        int[][] cost = new int[101][101];
        cost[characterX][characterY] = 1;
        
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];            
            
            for(int dir = 0; dir < 4; dir++){
                int nextX = x + dx[dir];
                int nextY = y + dy[dir];
                
                if((1<=nextX && nextX<101 && 1<=nextY && nextY<101) &&
                    map[nextX][nextY]==1 &&
                    cost[nextX][nextY]==0){
                    cost[nextX][nextY] = cost[x][y] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }        
        
        return cost[itemX][itemY] / 2;
    }
}