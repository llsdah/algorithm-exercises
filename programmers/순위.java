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
