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
