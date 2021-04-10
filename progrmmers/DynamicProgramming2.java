package studyProgrammers;

import java.util.Arrays;
import java.util.Stack;

/*
정수 삼각형 

위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 
거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 
아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 
예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.


제한사항
삼각형의 높이는 1 이상 500 이하입니다.
삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.

입출력 예

triangle							result
[   									30
[7], 
[3, 8], 
[8, 1, 0], 
[2, 7, 4, 4], 
[4, 5, 2, 6, 5]  ]	


*/

public class DynamicProgramming2 {
	
	public static void main(String[] args) {
		

		int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		
		System.out.println(Arrays.deepToString(triangle));
		System.out.println(triangle[0][0]);
		
		int answer = solution(triangle);
		System.out.println(answer);
	}
	
    public static int solution(int[][] triangle) {
        int answer = 0;
        triangle[1][0] += triangle[0][0];
        triangle[1][1] += triangle[0][0];
        	
        for(int i=2 ; i<triangle.length ; i++) {
        	for(int k=0;k<triangle[i].length;k++) {
        	
        		if(k==0) {
        			triangle[i][k] += triangle[i-1][0];
        		} else if( k == triangle[i].length-1) {
        			triangle[i][k] += triangle[i-1][k-1];
        		} else {
        			
        			triangle[i][k] += Math.max( triangle[i-1][k-1], triangle[i-1][k]);
        		}
        	}
        	
        }

        for( int i=0; i<triangle[triangle.length-1].length;i++) {
        	answer = Math.max(triangle[triangle.length-1][i], answer);
        }
        
        
        return answer;
    }
}
