import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int height, width;
    
    public int solution(String[] board) {
        int answer = -1;
        height = board.length;
        width = board[0].length();
        
        int startX = -1;
        int startY = -1;
        visited = new int[board.length][board[0].length()];
        
        for(int row = 0; row < board.length; row++){
            String str = board[row];
            for(int col = 0; col < str.length(); col++){
                if(str.charAt(col)=='R'){
                    startX = row;
                    startY = col;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = 1;
        
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            int row = loc[0];
            int col = loc[1];
            
            if(board[row].charAt(col)=='G'){
                answer = visited[row][col]-1;
                break;
            }
            
            for(int dir = 0; dir < 4; dir++){
                int nextRow = row + dx[dir];
                int nextCol = col + dy[dir];
                
                while(true){
                    if(isInArea(nextRow,nextCol) && board[nextRow].charAt(nextCol) != 'D'){
                        nextRow += dx[dir];
                        nextCol += dy[dir];
                    }
                    else{
                        nextRow -= dx[dir];
                        nextCol -= dy[dir];
                        break;
                    }
                }
                
                if(visited[nextRow][nextCol] == 0){
                    queue.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = visited[row][col] + 1;
                }
            }
        }
        
        return answer;
    }
    
    private static boolean isInArea(int row, int col){
        return 0<=row && row<height && 0<=col && col<width;
    }
}