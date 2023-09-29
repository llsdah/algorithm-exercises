import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        // 아래에서부터 가장 큰수를 찾자
        int leng = triangle.length-1;
        for(int i=leng-1;i>=0;i--){
            for(int k=0;k<triangle[i].length;k++){
                triangle[i][k] = Math.max(triangle[i][k]+triangle[i+1][k],
                                         triangle[i][k]+triangle[i+1][k+1]);
            }
            
        }
        answer = triangle[0][0];
        return answer;
    }
}

/*
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int m = triangle[n-1].length;
        
        for(int c =n-1-1; c>=0;c--){
            for(int r=0;r<triangle[c].length;r++){
                triangle[c][r] = triangle[c][r]
                    + Math.max(triangle[c+1][r],triangle[c+1][r+1]);
            }
        }
        answer =triangle[0][0];
        return answer;
    }
}
*/
