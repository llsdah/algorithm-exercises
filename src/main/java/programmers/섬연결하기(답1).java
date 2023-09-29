
import java.util.*;
class Solution {  // 이렇게 풀어야디 . !
    // 모든경로 방문의 최소의 수 
    ArrayList<Is> node = new ArrayList<>();
    int[] parent =new int[10001];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // 이건 사이클 반별위한 부모 노드 초기화 
        for(int i=0; i<n;i++){
            parent[i]=i;
        }
        
        for(int i=0; i< costs.length;i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            node.add(new Is(a,b,c));
        }
        Collections.sort(node);
        
        for(int i=0; i< node.size();i++){
            int a = node.get(i).a;
            int b = node.get(i).b;
            int c = node.get(i).dis;
            if(find(a)!=find(b)){
                union(a,b);
                answer+=c;
            }
        }
        
        return answer;
    }
    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x] =find(parent[x]);
    }
    public void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a<b) parent[b] =a;
        else parent[a]=b;
    }
}

class Is implements Comparable<Is>{
    int a;
    int b;
    int dis;
    Is(int a, int b, int dis){
        this.a =a;
        this.b =b;
        this.dis = dis;
    }
    public int compareTo(Is o){
        return this.dis- o.dis;
    }
    
}


public class 섬연결 { // 과거 답안.. 
	static int parent[];
	public static int solution(int n, int[][] costs) {
// 최소 간선 찾기 크루스칼알고리즘 간선의 가중치를 오름차순으로 정렬합니다. 
		
		
		int answer =0;
		ArrayList<Node> list = new ArrayList<>();
		parent = new int[n+1];//총 정의 갯수 
		
		for(int i =1;i<=n;i++) {
			parent[i]=i;
		}
		
		for(int i =0; i<costs.length;i++) {
			list.add(new Node(costs[i][0],costs[i][1],costs[i][2]));
		}
		
		Collections.sort(list);
		
		for(Node a : list) {
			if(check(a.st,a.end)) {
				answer+=a.weight;
				union(a.st,a.end);
			}
		}
		
		
		return answer;
	}
	
	// 합치는 과정 두개의 간선에 MST 집합 추가입니다.
	private static void union(int st, int end) {

		int a =find(st);
		int b =find(end);
		
		if(a>b) {
			int temp =a;
			a=b;
			b=temp;
		}
		
		parent[b]=a;
		
	}
	
	// 사이클을 체크하는것 2개의 노드의 최상위 부모가 똑같지 않으면된다.
	// 반복되면 안댐 돌아갑니다..
	private static boolean check(int st, int end) {
		int a = find(st);
		int b = find(end);
		if(a==b) {
			return false;
		}
		return true;
	}

	// 부모노드를 찾는것 
	private static int find(int x) {

		if(x == parent[x]) {
			return x; // 부조찾으면 반환.
		}
		
		return parent[x]=find(parent[x]);
	}
}



// 간선 사이의 가중치를 정렬하는 과정. 
 class Node implements Comparable<Node>{

	 int st=0;
	 int end=0;
	 int weight=0;
	 Node(int st,int end, int weight){
		 this.st =st;
		 this.end =end;
		 this.weight =weight;
	 }
	 
	@Override
	public int compareTo(Node o) {
		return this.weight-o.weight;
	}
	
}

/* 실수.. 하하하하.. 

import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // 모든 점에서 모든 점까지 가는 비용 
        int[][] arr = new int[n][n];
        for(int i=0; i<n;i++){
            Arrays.fill(arr[i],(int)1e9);    
        }
        for(int a=0; a<n;a++){
            arr[a][a]=0;
        }
        
        for(int i=0; i<costs.length;i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            
            arr[a][b]=c;
            arr[b][a]=c;
        }
        
        // n ab = n ak kb;
        
        for(int a=0; a<n;a++){
            for(int b = 0;b<n;b++){
                for(int k=0; k<n;k++){
                    arr[a][b] = Math.min(arr[a][k]+arr[k][b],arr[a][b]);
                }
            }
        }
        for(int k=0; k<n;k++){
            System.out.println(Arrays.toString(arr[k]));
        }
        
        int min = (int)1e9;
        for(int a=0; a<n;a++){
            for(int b = 0;b<n;b++){
                if(a==b) continue;
                min =Math.min(min, arr[a][b]);
            }
        }
        answer = min;
        return answer;
    }
}
*/
