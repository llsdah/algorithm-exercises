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
/*
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[][] map = new boolean[n+1][n+1];
        for(int i =0; i <edge.length;i++) {
            map[edge[i][0]][edge[i][1]]  =map[edge[i][1]][edge[i][0]] =true;
        }

        int[]   visit = new int[n+1];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(1); 
        int max =0;

        while(!q.isEmpty()) {
            int value =q.poll();

            for( int k =2;k<=n;k++) {

                if(visit[k]==0&& map[value][k]) {
                    visit[k] = visit[value]+1;
                    q.add(k);
                    max = Math.max(max, visit[k]);
                }

            }//for

        }//while

        int answer =0;
        for( int i =0; i<visit.length;i++) {
            if(max==visit[i]) {
                answer++;
            }
        }

        return answer;

    }
}

*/
