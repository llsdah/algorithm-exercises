class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        //가장 큰값 찾고 
        //그 작은 값 중에 젤큰값 찾으면 되네 
        int max=0;
        int min=0;
        
        for(int i =0; i<sizes.length;i++){
            max = sizes[i][0]>sizes[i][1] 
                ? (sizes[i][0] > max ? sizes[i][0] : max)
                : (sizes[i][1] > max ? sizes[i][1] : max);
        }
        
        for(int i =0; i<sizes.length;i++){
            min = sizes[i][0] > sizes[i][1] 
                ? (sizes[i][1] > min ? sizes[i][1] : min)
                : (sizes[i][0] > min ? sizes[i][0] : min);
        }
        
        answer = max*min;
        return answer;
    }
}
