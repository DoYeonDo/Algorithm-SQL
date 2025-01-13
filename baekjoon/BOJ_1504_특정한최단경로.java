package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int N, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long path1 = 0;
        path1 += dijkstra(1, v1);
        path1 += dijkstra(v1, v2);
        path1 += dijkstra(v2, N);

        long path2 = 0;
        path2 += dijkstra(1, v2);
        path2 += dijkstra(v2, v1);
        path2 += dijkstra(v1, N);

        long result = Math.min(path1, path2);
        System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
    }

    static int dijkstra(int start, int end) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.node;
            int currentCost = current.cost;

            if (currentCost > distance[currentNode]) continue;

            for (Node neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.node;
                int nextCost = currentCost + neighbor.cost;

                if (nextCost < distance[nextNode]) {
                    distance[nextNode] = nextCost;
                    pq.offer(new Node(nextNode, nextCost));
                }
            }
        }

        return distance[end];
    }
}
