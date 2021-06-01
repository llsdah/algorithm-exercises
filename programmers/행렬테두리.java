class Solution {
    int[][] number;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        // row, col 
        number = new int[rows][columns];
        int cnt =1;
        for(int i =0; i <rows;i++ ){
            for(int k=0; k<columns;k++){
                number[i][k]=cnt;
                cnt++;
            }
        }
        for(int i = 0 ; i < queries.length; i++ ){
            int[] st = new int[2];
            int[] end = new int[2];
            st[0] =queries[i][0]-1;
            st[1] =queries[i][1]-1;
            end[0] =queries[i][2]-1;
            end[1] =queries[i][3]-1;
            int temp = squ(st,end);
            answer[i]=temp;
        }
        return answer;
    }
    
    public int squ(int[] st, int[] end) {
        int min =(int)1e9;
        int temp = number[st[0]][st[1]];
        min = Math.min(min,temp);
        boolean check = false;
        // 가 세 역가 역세
        // st[0] st[1] ~ st[0] end[1];
        for(int col = st[1]+1; col <= end[1] ; col++){
            int num = number[st[0]][col];
            number[st[0]][col] = temp;
            temp =num;
            min = Math.min(min,temp);
        }
        // st[0] end[1] ~ end[0] end[1];
        for(int row = st[0]+1; row <= end[0] ; row++){
            int num = number[row][end[1]];
            number[row][end[1]] = temp;
            temp =num;
            min = Math.min(min,temp);
        }
        // end[0] st[1] ~ end[0] end[1];
        for(int col = end[1]-1; col >= st[1] ; col--){
            int num = number[end[0]][col];
            number[end[0]][col] = temp;
            temp =num;
            min = Math.min(min,temp);
        }
        // st[0] st[1] ~ end[0] st[1];
        for(int row = end[0]-1; row >= st[0] ; row--){
            int num = number[row][st[1]];
            number[row][st[1]] = temp;
            temp =num;
            min = Math.min(min,temp);
        }
        return min;
    }
    
}
