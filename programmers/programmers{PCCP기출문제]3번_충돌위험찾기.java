import java.util.*;

class Solution {
    static Queue<int[]>[] recode;
    static int robotCnt;
    static int result;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        robotCnt = routes.length;
        recode = new LinkedList[robotCnt];
        
        for(int idx = 0; idx < robotCnt; idx++)
            recode[idx] = new LinkedList<>();
        
        recoding(points, routes);
        
        dangerousCounting();
        
        return result;
    }
    
    public void dangerousCounting() {
        int cnt = 0;
        
        while (cnt < robotCnt) {
            int[][] map = new int[101][101];
            cnt = 0;
            
            for (int idx = 0; idx < robotCnt; idx++) {
                if (recode[idx].isEmpty()) {
                    cnt++;
                    continue;
                }
                
                int[] tmp = recode[idx].poll();
                map[tmp[0]][tmp[1]]++;
            }
            
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) result++;
                }
            }
        }
    }
    
    public void recoding(int[][] points, int[][] routes) {
        for (int idx = 0; idx < robotCnt; idx++) {
            int[] route = routes[idx];
            int r = points[route[0] - 1][0];
            int c = points[route[0] - 1][1];
            
            recode[idx].add(new int[] {r, c});
            
            for (int j = 1; j < route.length; j++) {
                int nr = points[route[j] - 1][0];
                int nc = points[route[j] - 1][1];
                
                while (nr != r) {
                    if (nr > r) r++;
                    else r--;
                    
                    recode[idx].add(new int[]{r, c});
                }
                while (nc != c) {
                    if (nc > c) c++;
                    else c--;
                    
                    recode[idx].add(new int[]{r, c});
                }
            }
        }
    }
}
