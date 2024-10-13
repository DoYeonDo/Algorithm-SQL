import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int dir = 0;
    static int[][] map;
    static int[][][] dp;
    static boolean[][] visited;
    static int ans = Integer.MAX_VALUE;
    
    public int solution(int[][] board) {
        int answer = 0;
        
        map = board;
        visited = new boolean[board.length][board.length];
        dp = new int[board.length][board.length][4];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                for(int z = 0; z < 4; z++){
                    dp[i][j][z] = Integer.MAX_VALUE;
                }
            }
        }
        
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][0][3] = 0;
        
        dfs(0,0,-1,0);
        
        answer = ans;
        return answer;
    }
    
    private static void dfs(int row, int col, int prevDir, int totalPrice){
        if(row==map.length-1 && col==map.length-1){
            ans = Math.min(ans, totalPrice);
            return;
        }
        
        visited[row][col] = true;
        
        for(int dir = 0; dir < 4; dir++){
            int nextRow = row + dx[dir];
            int nextCol = col + dy[dir];
            
            if(!(0<=nextRow && nextRow<map.length && 0<=nextCol && nextCol<map.length)
              || visited[nextRow][nextCol] || map[nextRow][nextCol]==1) continue;
            
            int newPrice = totalPrice + ((prevDir==dir || prevDir==-1) ? 100:600);
            
            if(dp[nextRow][nextCol][dir] > newPrice){
                dp[nextRow][nextCol][dir] = newPrice;
                dfs(nextRow, nextCol, dir, newPrice);
            }
        }
        
        visited[row][col] = false;
    }
}