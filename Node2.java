package studyProgrammers;

import java.util.Arrays;

/*

순위   = 플로이드-와셜

문제 설명
n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 
권투 경기는 1대1 방식으로 진행이 되고, 
만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 
심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 
하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.

선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 
정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 
solution 함수를 작성해주세요.

제한사항
선수의 수는 1명 이상 100명 이하입니다.
경기 결과는 1개 이상 4,500개 이하입니다.
results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
모든 경기 결과에는 모순이 없습니다.

입출력 예
n		results														return
5		[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]			2

입출력 예 설명
2번 선수는 [1, 3, 4] 선수에게 패배했고 
5번 선수에게 승리했기 때문에 4위입니다.
5번 선수는 4위인 2번 선수에게 패배했기 때문에 5위입니다.

*/

public class Node2 {

	public static void main(String[] args) {

		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

		int result = solution(n, results);
		System.out.println("result : " + result);

	}

	// 최대 경로 즉 순위 
	static final int MAX_VALUE = 1000000;
	static int[][] nodes;
	
	
	public static int solution(int n, int[][] results) {
		int answer = 0;
		nodes(n,results);
		
		for( int i = 1;i<=n;i++) {
			boolean valid =true;
			for(int h =1; h<=n;h++) {
				// i 번째 노드에서 각 노드를 확인해서 모든 노드에 대해 가거나 돌아올 수 있으면 등수 확정이 가능하다. 
				if(i != h && nodes[i][h]==MAX_VALUE && nodes[h][i]== MAX_VALUE) {
					valid = false;
					break;
				}
				
			}
			if(valid) {
				answer ++;
			}
			
		}
		
		return answer;
	}

	// 플로이드-와셜 알고리즘의 가중치 계산을 위한 메소드 
	private static void nodes(int n, int[][] results) {
		// 초기화 , 알기 쉽게 0을 없다고 생각하고 1개씩 추가 
		nodes = new int[n+1][n+1];
		
		for( int i =0; i<=n ;i++) {
			// 암수 안에 있는 것들을 채울 수 있는 것 모두 최대 거리로 일단 변싄
			Arrays.fill(nodes[i], MAX_VALUE);
		}
		
		//승리하면 일단 1 등으로 한다. 거리가 1이다.
		//2중 배열을 그냥 배열에 입력하는 것이 가능 합니다. 
		for(int[] win :results) {
			
			// 승리한것 기존의 한개씩 증가해서 그냥 그대로  0 이 승리 , 1이 패배 
			nodes[win[0]][win[1]]=1;
		}
		
		// 플로이드 와셜 알고리즘의 기본 개념에 맞게 시작-도착 직선거리보다 
		// 시작 중간 도착 거리가 짧으면 기록한다. 
		
		
		for(int k = 1; k<=n; k++) { // 거쳐가는 노드 
			for(int i = 1; i<=n; i++) { // 시작하는 노드 
				for(int h = 1; h<=n; h++) {  // 조착하는 모트 
					
					int pathLength = nodes[i][k] + nodes[k][h];
					if(nodes[i][h]> pathLength) {
						nodes[i][h] = pathLength;
					}
					
				}
				
			}
			
		}
		
		
		
	}


}

/*
 * 
 * 
 * // 정확하게 순위를 매길 수 있는 사람 하하하 static int[] check; // 입력된 번호를 확인 했는지 유무 static
 * boolean[] fail; // 등수 false 값을 만나면 등수가 됩니다. public static int solution(int n,
 * int[][] results) { check = new int[n+1];// 0번 값은 필요없음 fail = new
 * boolean[n+1];// 0번 값은 필요없음 보기 편하게 하기 위해
 * 
 * 
 * // 사람을 돌면서 찾아서 false가 1개 인거 찾기 for(int i=1; i<=n;i++) {
 * 
 * int person = results[i][1];
 * 
 * 
 * }
 * 
 * 
 * int answer = 0; return answer; }
 * 
 * 
 * 
 */
