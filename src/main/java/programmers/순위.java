// 플로이드워셜 알고리즘. 
import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        // 등수만 찾는다 결국 다 돌아 다니냐가 중요한 문제 
        boolean[][] game = new boolean[n+1][n+1];
        for(int i=0; i<results.length;i++){
            game[results[i][0]][results[i][1]] = true;
        }
        for(int i =1; i<=n;i++){
            for(int k =1; k<=n;k++){
                for(int h =1; h<=n;h++){
                    if(game[k][i]&&game[i][h]){
                        game[k][h] = true;//거쳐 갈 수 있다 즉 , 승부의 내용을 알 수가 있다는 의미 
                    }
                }
            }
        }
        for(int i=1; i<=n;i++){
            int result =0;// 전체 경기가 진행되면 결과알수있음.
            for(int k =1;k<=n;k++){
                if(game[i][k]|game[k][i]) result++;
            }
            if(result==n-1) answer++;
        }
        
        return answer;
    }
}
/*
import java.util.*;

class Solution {
    static final int MAX_VALUE = 100000;
	static int[][] nodes;
	
	
	public static int solution(int n, int[][] results) {
		int answer = 0;
		nodes(n,results);
		
		for( int i = 1;i<=n;i++) {
			boolean valid =true;
			for(int h =1; h<=n;h++) {
	
				if(i !=h && nodes[i][h]==MAX_VALUE && nodes[h][i]== MAX_VALUE) {
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

	private static void nodes(int n, int[][] results) {
		nodes = new int[n+1][n+1];
		
		for( int i =0; i<=n ;i++) {
			Arrays.fill(nodes[i], MAX_VALUE);
		}
		 
		for(int[] win :results) {
			
			nodes[win[0]][win[1]]=1;
		}
		
		
		for(int k = 1; k<=n; k++) {  
			for(int i = 1; i<=n; i++) {  
				for(int h = 1; h<=n; h++) {   
					
					int pathLength = nodes[i][k] +nodes[k][h];
					if(nodes[i][h]> pathLength) {
						nodes[i][h] = pathLength;
					}
					
				}
				
			}
			
		}
	}

}
*/

/* 정렬 후 맞는지 확인 중.. 

    ArrayList<ArrayList<Win>> list = new ArrayList<>();
    public int solution(int n, int[][] results) {
        int answer = 0;
        // 0 번쨰가 승리 했다는 의미 . 
        // 승패 2승 했다면 뒤에 두면은 있다는 의미; 진 사랑 이긴 사람 담을까?
        Arrays.sort(results, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        for(int i =0; i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<results.length;i++){
            int win = results[i][0];
            int lose = results[i][1];
            
        }
        
        return answer;
    }
}

class Win{
    String win;
    String lose;
    Win(String win, String lose){
        this.win = win;
        this.lose = lose;
    }
}

*/
