import java.util.*;

class Solution {
    static int N,M;
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        N = storage.length;
        M = storage[0].length();
        map = new char[N][M];
        
        for(int row = 0; row < N; row++){
            String str = storage[row];
            for(int col = 0; col < M; col++){
                char ch = str.charAt(col);
                map[row][col] = ch;
            }
        }
        
        for(String request : requests){
            char target = request.charAt(0);
            if(request.length()==1){
                remove1(target);
            }
            else{
                remove2(target);
            }
        }
        
        int cnt = 0;
        for(int row = 0; row < N; row++){
            for(int col = 0; col < M; col++){
                if(map[row][col]==' ')
                    cnt++;
            }
        }
        
        return N*M-cnt;
    }
    
    static void remove1(char target){
        Stack<int[]> stack = new Stack<>();
        
        for(int row = 0; row < N; row++){
            for(int col = 0; col < M; col++){
                char ch = map[row][col];
                
                if(target==ch) {
                    if(dig(row,col)) stack.push(new int[]{row,col});
                }
            }
        }
        
        while(!stack.isEmpty()){
            int[] loc = stack.pop();
            
            int r = loc[0];
            int c = loc[1];
            
            map[r][c] = ' ';
        }
    }
    
    static void remove2(char target){
        Stack<int[]> stack = new Stack<>();
        
        for(int row = 0; row < N; row++){
            for(int col = 0; col < M; col++){
                char ch = map[row][col];
                
                if(target==ch){ 
                    stack.push(new int[]{row,col});
                }
            }
        }
        
        while(!stack.isEmpty()){
            int[] loc = stack.pop();
            
            int r = loc[0];
            int c = loc[1];
            
            map[r][c] = ' ';
        }
    }
    
    static boolean dig(int row, int col){
        //가장자리에 위치해있으면 외부와 연결돼있음
        if(row==0 || row==N-1 || col==0 || col==M-1)
            return true;
        
        return bfs(row, col);
    }
    
    static boolean bfs(int row, int col){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.offer(new int[]{row,col});
        
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            int curRow = loc[0];
            int curCol = loc[1];
            
            if(curRow==0 || curRow==N-1 || curCol==0 || curCol==M-1)
                return true;
            
            for(int dir = 0; dir < 4; dir++){
                int nextRow = curRow + dx[dir];
                int nextCol = curCol + dy[dir];
                
                if(visited[nextRow][nextCol]) continue;
                if(map[nextRow][nextCol]!=' ') continue;
                
                visited[nextRow][nextCol] = true;
                queue.offer(new int[]{nextRow, nextCol});
            }
        }
        
        return false;
    }
}