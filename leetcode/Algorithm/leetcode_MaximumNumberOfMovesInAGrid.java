class Solution {
    static int[] move = {-1,0,1};
    static int[][] map;
    static int[][] dp;

    public int maxMoves(int[][] grid) {
        map = grid;
        dp = new int[grid.length][grid[0].length];

        for(int row = 0; row < grid.length; row++){
            dfs(row,0,0);
        }

        return ans;
    }
    
    int ans = 0;
    void dfs(int row, int col, int dis){
        ans = Math.max(ans, dis);

        for(int dir = 0; dir < 3; dir++){
            int nr = row + move[dir];
            int nc = col + 1;

            if(0>nr || nr>=map.length || 0>nc || nc>=map[0].length) continue;

            if(map[row][col] < map[nr][nc]){
                if(dis+1 > dp[nr][nc]){
                    dp[nr][nc] = dis+1;
                    dfs(nr, nc, dis+1);
                }
            }
        }
    }
}