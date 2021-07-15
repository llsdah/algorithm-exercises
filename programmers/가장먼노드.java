import java.util.*;
class Solution {
    int max =0;
    int[] d;
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        d = new int[n+1];
        Arrays.fill(d,(int)1e9);
        d[0]=0;
        int answer = 0;
        for(int i=0; i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i =0;i<edge.length;i++){
            int a= edge[i][0];
            int b= edge[i][1];
            graph.get(a).add(new Node(b,1));
            graph.get(b).add(new Node(a,1));
        }
        
        dij(1);
        int max = Arrays.stream(d).max().getAsInt();
        answer = (int)Arrays.stream(d).filter(i -> i==max).count();
        return answer;
    }
    public void dij(int x){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(x,0));
        d[x] =0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int dist = node.dis;
            int pos = node.pos;
            
            if(d[pos]<dist) continue;
            
            for(int i=0; i<graph.get(pos).size();i++){
                int cost = d[pos]+graph.get(pos).get(i).dis;
                if(cost <d[graph.get(pos).get(i).pos]){
                    d[graph.get(pos).get(i).pos]=cost;
                    q.offer(new Node(graph.get(pos).get(i).pos, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int pos;
    int dis;
    Node(int pos,int dis){
        this.pos = pos;
        this.dis = dis;
    }
    
    public int compareTo(Node o){
        return this.dis -o.dis;
    }
}
