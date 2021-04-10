package studyProgrammers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
가장 먼 노드 ( 이미지 있음 ) 
가장 먼 노드
문제 설명
n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 
1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 
가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 
노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 
1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 
return 하도록 solution 함수를 작성해주세요.

제한사항
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

입출력 예
n		vertex																		return
6		[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]		3

입출력 예 설명
예제의 그래프를 표현하면 아래 그림과 같고, 
1번 노드에서 가장 멀리 떨어진 노드는 4,5,6번 노드입니다.




*/
public class Node1 {

	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
	
		int result = solution(n,vertex);
		System.out.println("result : " + result);
	}

	private static int solution(int n, int[][] edge) {
		// 그래프를 구현 합니다. 이건 주용하다 외워야 될 느낌
		boolean[][] map = new boolean[n+1][n+1];
		for(int i =0; i <edge.length;i++) {
			map[edge[i][0]][edge[i][1]]  =map[edge[i][1]][edge[i][0]] =true;
		}
		
		
		// 1번만찾으면 되니까.
		int[]	visit = new int[n+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(1); // 1을 왜 넣으ㄹ까?
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
		
		
		System.out.println("map : "+ Arrays.deepToString(map));
		System.out.println("max : "+ max);
		System.out.println("visit : "+ Arrays.toString(visit));
		
		int answer =0;
		for( int i =0; i<visit.length;i++) {
			if(max==visit[i]) {
				answer++;
			}
		}
		
		return answer;
	}
	
}
