import java.util.*;

class Solution {
    static int[] distArr;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        visited = new boolean[n+1];
        distArr = new int[n+1];
        Arrays.fill(distArr, 100000001);
        distArr[destination] = 0;
        
        for(int idx = 0; idx <= n; idx++)
            list.add(new ArrayList<Integer>());
        
        for(int[] road : roads){
            int node1 = road[0];
            int node2 = road[1];
            
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }
        
        bfs(destination);
        
        for(int idx = 0; idx < answer.length; idx++){
            int res = distArr[sources[idx]];
            
            if(res != 100000001)
                answer[idx] = distArr[sources[idx]];
            else
                answer[idx] = -1;
        }
        
        return answer;
    }
    
    private static void bfs(int node){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, 0});
        visited[node] = true;
        
        while(!queue.isEmpty()){
            int[] nodeInfo = queue.poll();
            
            int curNode = nodeInfo[0];
            int dist = nodeInfo[1];
            
            for(int idx = 0; idx < list.get(curNode).size(); idx++){
                int nextNode = list.get(curNode).get(idx);
                
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    distArr[nextNode] = Math.min(distArr[nextNode], dist+1);
                    queue.offer(new int[]{nextNode, dist+1});
                }
            }
        }
    }
}