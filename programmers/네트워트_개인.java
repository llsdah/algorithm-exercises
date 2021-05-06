import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> graph = 
        new ArrayList<ArrayList<Integer>>();
    boolean[] visit;
    int result =0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit =new boolean[n];
        for(int i =0; i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<computers.length;i++){
            for(int k =0; k<computers[i].length;k++){
                if(computers[i][k]==1){
                    graph.get(i).add(k);
                }
            }        
        }
        
        for(int i =0; i< n;i++){
            if(visit[i]==false){
                bfs(i);
                result++;
            }
        }
        answer = result;
        return answer;
    }
    
    public void bfs(int start){
        Queue<Integer> q =new LinkedList<>();
        q.offer(start);
        visit[start]=true;
        
        while(!q.isEmpty()){
            
            int now = q.poll();
            
            for(int i =0; i<graph.get(now).size();i++){
                if( visit[graph.get(now).get(i)]){
                    continue;
                }else{
                    visit[graph.get(now).get(i)]=true;
                    q.offer(graph.get(now).get(i));
                }
                
            }
        }
        
    }
}
