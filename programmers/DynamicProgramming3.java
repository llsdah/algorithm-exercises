package studyProgrammers;

import java.util.Arrays;
import java.util.HashMap;

/*


등굣길
문제 설명
계속되는 폭우로 일부 지역이 물에 잠겼습니다. 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다. 
집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.

아래 그림은 m = 4, n = 3 인 경우입니다.

가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래,
 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.

격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 

오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 

1,000,000,00 7로 나눈 나머지를 

return 하도록 solution 함수를 작성해주세요.

제한사항
격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
물에 잠긴 지역은 0개 이상 10개 이하입니다.
집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.

입출력 예

m		n		puddles		return

4		3		[[2, 2]]		4



*/
public class DynamicProgramming3 {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 }};

		
		
		System.out.println();
		int ttt = solution(m, n, puddles);
		
		System.out.println("ttt"+ ttt);
	}

	
	// 시작 점 1,1 
	public static int solution(int m, int n, int[][] puddles) {

/*

배열 문제는 배열을 생성해서 풀면 조금 편한거 같다.  
	
	
	
*/		
		
		int[][] dp = new int[n+1][m+1];
		// 행 열이 반대 이고 row
		// 해당 지역의 경로를 -1 값을 해둡니다. 
		
		for ( int i=0; i<puddles.length;i++){
			dp [puddles[i][1]] [puddles[i][0]] =-1;

		}
		
		dp[1][1] =1 ; // 시작점으로 잠고 이동
		
		//행 부터 이동
		for( int i=1 ; i<= n; i++) {
			
			// 열이동 
			for( int k = 1; k<=m; k++) {
				
				if(dp[i][k]==-1) {
					// 막다른 경로면 더하지도 말고 아무것도 하지말고 ㅖ속
					continue;
				}
				
				// 0 은 우리 없는 경로로 생각하기로 했담.
				// 현재 경로에 밑에 있는거 더해 주기 기본값이 0이니까 
				if( k-1 >0 && dp[i][k-1] != -1) {
					dp[i][k] +=dp[i][k-1];
				}
				
				// 현재 경로 밑에를 지나 올 수 있으면 밑에 값 더 해 주기 
				if(i-1 >0 && dp[i-1][k]!=-1) {
					dp[i][k] += dp[i-1][k];	
				};
				
			}
		
		
		}
		
		
		
		return dp[n][m];
		
	}

}



/*
 * 
 *  내 풀이 엉망이다. 
 *  
 *  
 * public static int solution(int m, int n, int[][] puddles) { int answer = 0;
 * 
 * // 행열 반대 입니다. int[][] test = new int[n][m];
 * 
 * // 웅덩이 갯수 System.out.println(puddles.length);
 * 
 * HashMap<int[], Integer> map = new HashMap<int[], Integer>(); int[] temp = new
 * int[2];
 * 
 * 
 * // 값 입력 for( int i=0; i<puddles.length;i++) { temp[0] = puddles[i][0];
 * temp[1] = puddles[i][1]; map.put(temp,1);
 * 
 * temp[0] = puddles[i][0]-1; temp[1] = puddles[i][1]; map.put(temp,1);
 * 
 * temp[0] = puddles[i][0]; temp[1] = puddles[i][1]-1; map.put(temp,1);
 * 
 * temp[0] = puddles[i][0]-1; temp[1] = puddles[i][1]-1; map.put(temp,1);
 * 
 * System.out.println(Arrays.toString(temp));
 * 
 * 
 * }
 * 
 * int[] temp2 = {1,3}; System.out.println(map.get(temp2)==null ? 0: 1);
 * 
 * 
 * // 두개가 다 되면 1개 증가하면서 이동 1개만 되면 그대로 이동 두개다 안되면 이동 안함. // 우물이 된다는 건 거기 기준 2,2,에
 * 있다는 것은 2,2, 각각 -1 씩한 2,1, 1,2 1,1이 안된다는 의미이다. 이것을 저장해야된다. //저 맵을 만나서 temp, 1
 * 이면 종료
 * 
 * int end = m+n; // 이만큼 가면 종료됨 더하면서 가야지 int start = 1;
 * 
 * // 그 이건 수학식 int count = 1;
 * 
 * 
 * int number = 0;
 * 
 * boolean row = false; boolean col = false;
 * 
 * for( int i=0; i<n;i++) { count =1; number =i;
 * 
 * for(int k = 0;k<m;k++ ) { row = row_ck(i+1,k,map); col = col_ck(i,k+1,map);
 * 
 * // true 가능 if( row&&col ) {
 * 
 * }else if (row||col) {
 * 
 * }else { break; }
 * 
 * }
 * 
 * i=number; }
 * 
 * 
 * return answer;
 * 
 * }
 * 
 * private static boolean row_ck(int i, int k, HashMap<int[], Integer> map) { //
 * TODO Auto-generated method stub int[] temp = {i,k}; if ( map.get(temp) != 1)
 * { return true; };
 * 
 * 
 * return false; }
 * 
 */