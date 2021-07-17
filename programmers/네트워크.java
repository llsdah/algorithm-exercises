import java.util.*;
class Solution {
    int[] parent;// 최대 노드 200개
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 부모 찾으면 되잖아 그치 
        parent = new int[n];
        // 부모 노드 자신으로 초기화 
        for(int i=0; i<n;i++){
            parent[i]=i;
        }
        
        for(int i =0; i<n;i++){
            list.add(new ArrayList<Integer>());
        }
        // 노드 연결 
        for(int i =0; i<computers.length;i++){
            for(int k=0; k<computers[i].length;k++){
                if(computers[i][k]==0) continue;
                list.get(i).add(k);
            }
        }
        
        for(int i =0; i<list.size();i++){
            for(int k=0; k<list.get(i).size();k++){
                int num = list.get(i).get(k);
                if(find(i)!=find(num)){
                    union(find(i),find(num));
                }
            }
        }
        
        System.out.println(Arrays.toString(parent));
        int[] arr = new int[201];// 최대 200
        for(int i =0; i<n;i++){
            arr[parent[i]]++;
        }
        answer = (int)Arrays.stream(arr).filter( k-> k!=0).count();
        
        return answer;
    }
    public int find(int x){
        if(x ==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y){
        if(x>y) parent[x] =y;
        else parent[y] = x;
    }
}
