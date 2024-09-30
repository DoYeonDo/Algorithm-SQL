class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        
        int[][] dp = new int[n][m];

        for(int[] puddle : puddles){
            int puddleRow = puddle[1] - 1;
            int puddleCol = puddle[0] - 1;
            
            dp[puddleRow][puddleCol] = -1;
        }
        
        dp[0][0] = 1;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(dp[row][col]==-1) continue;
                if(row != 0 && dp[row-1][col] > 0) dp[row][col] += dp[row-1][col] % mod;
                if(col != 0 && dp[row][col-1] > 0) dp[row][col] += dp[row][col-1] % mod;
            }
        }
        
        return dp[n-1][m-1] % mod;
    }
}