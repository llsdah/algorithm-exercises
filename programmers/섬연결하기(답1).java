import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 섬연결 {

	public static void main(String[] args) {

		// int m = 4;
		// int n = 5;
		// String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		int n = 5;
//		int[][] tt = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
//		int[][] tt =  {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};
//		int[][] tt = {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}};
//		int[][] tt = {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}};

//		int[][] tt ={{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}};
		int[][] tt = {{0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}};
//		int[][] tt = {{0, 1, 1}, {0, 2, 2}, {0, 3, 3}, {0, 4, 4}, {1, 3, 1}};

		String sentense = "HaEaLaLaObWORLDb";

		int result = solution(n, tt);

		// long[] result = solution4(n,z,roads,queries);

		System.out.println("result : " + result);

	}
	
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


