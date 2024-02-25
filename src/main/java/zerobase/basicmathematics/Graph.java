package zerobase.basicmathematics;
import java.util.*;

class Graph {
    private int V;
    private List<List<Node>> adj;

    class Node {
        int dest, weight;

        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Node(dest, weight));
        adj.get(dest).add(new Node(src, weight)); // 반대 방향 간선 추가
    }

    int dijkstra(int src, int dest, List<Integer> mustPassNodes) {
        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(a -> a.weight));
        int[] dist = new int[V];
        Arrays.fill(dist, -1); // 초기값을 -1로 설정
        pq.add(new Node(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;
            for (Node neighbor : adj.get(u)) {
                int v = neighbor.dest;
                int weight = neighbor.weight;
                if (dist[u] != -1 && (dist[v] == -1 || dist[u] + weight < dist[v])) {
                    if (mustPassNodes.contains(v)) {
                        dist[v] = dist[u] + weight;
                    } else {
                        dist[v] = dist[u] + weight;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
        }

        return dist[dest] == -1 ? Integer.MAX_VALUE : dist[dest]; // 최단 거리가 업데이트되지 않은 경우 최대값 반환
    }

    public static void main(String[] args) {
        int V = 6;
        /**
         *
         5, 4, [[1, 2, 1], [1, 3, 3], [2, 4, 2], [3, 5, 5]], [2, 3, 4]
         기댓값 〉
         14
         */
        Graph g = new Graph(V);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 4, 2);
        g.addEdge(3, 5, 5);

        int[] tet2 = {2,3,4};
        Integer[] test = Arrays.stream(tet2).boxed().toArray(Integer[]::new);;

        List<Integer> mustPassNodes = Arrays.asList(test); // 반드시 거쳐가야 하는 노드들
        int src = 1; // 출발 노드
        int dest = V-1; // 도착 노드

        int shortestDistance = g.dijkstra(src, dest, mustPassNodes);
        System.out.println("Shortest distance from " + src + " to " + dest + " passing through nodes " + mustPassNodes + " is: " + (shortestDistance == Integer.MAX_VALUE ? "No path exists" : shortestDistance));
    }
}