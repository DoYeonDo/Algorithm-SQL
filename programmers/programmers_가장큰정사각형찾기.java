class Solution
{
    public int solution(int[][] board)
    {
        int answer = 0;
        int[][] dp = new int[board.length+1][board[0].length+1];
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                dp[row+1][col+1] = board[row][col];
            }
        }

        int max = 0;
        
        for(int row = 1; row < dp.length; row++){
            for(int col = 1; col < dp[row].length; col++){
                if(dp[row][col]==1){
                    int left = dp[row][col-1];
                    int up = dp[row-1][col];
                    int leftUp = dp[row-1][col-1];

                    int min = Math.min(left, Math.min(up, leftUp));
                    dp[row][col] += min;
                    
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        
        answer = max*max;
        return answer;
    }
}