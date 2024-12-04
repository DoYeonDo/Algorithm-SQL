import java.util.*;

class Solution {
    //n 세로 길이, m 가로 길이
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<ArrayList<Integer>> list;
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        
        list = new ArrayList<>();
        for(int idx = 0; idx < m; idx++)
            list.add(new ArrayList<>());
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(land[row][col]==1 && !visited[row][col]){
                    bfs(land, row, col);
                }
            }
        }
        
        for(int row = 0; row < m; row++){
            int sum = 0;
            for(int col = 0; col < list.get(row).size(); col++)
                sum += list.get(row).get(col);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    private static void bfs(int[][] land, int row, int col){
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        int cnt = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.offer(new int[]{row, col});
        
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            cnt++;
            int r = loc[0];
            int c = loc[1];
            minCol = Math.min(minCol, c);
            maxCol = Math.max(maxCol, c);
            
            for(int dir = 0; dir < 4; dir++){
                int nr = r + dx[dir];
                int nc = c + dy[dir];
                
                if(0>nr || n<=nr || 0>nc || m<=nc
                  || visited[nr][nc] || land[nr][nc]==0) continue;
                
                visited[nr][nc] = true;
                queue.offer(new int[]{nr,nc});
            }
        }
        
        save(minCol, maxCol, cnt);
    }
    
    private static void save(int minCol, int maxCol, int cnt){
        for(int idx = minCol; idx <= maxCol; idx++){
            list.get(idx).add(cnt);
        }
    }
}