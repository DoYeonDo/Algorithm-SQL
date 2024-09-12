import java.util.*;

class Solution {
    static int[] parent;
    static PriorityQueue<Edge> pq;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int idx = 0; idx < n; idx++)
            parent[idx] = idx;
        
        pq = new PriorityQueue<>();
        
        for(int[] cost : costs){
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];
            
            pq.offer(new Edge(start, end, weight));
        }
        
        int useEdge = 0;
        for(int cnt = 0; cnt < costs.length; cnt++){
            Edge e = pq.poll();
            if(find(e.start) != find(e.end)){
                union(e.start, e.end);
                answer += e.weight;
            }
            useEdge++;
        }
        
        return answer;
    }
    
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a != b)
            parent[b] = a;
    }
    
    private static int find(int a){
        if(a == parent[a])
            return a;
        
        else
            return parent[a] = find(parent[a]);
    }
}