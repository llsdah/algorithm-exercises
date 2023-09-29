class Solution {
    
    private static int[][] map;
    private static int zero=0;
    private static int one=0;
    private static int size;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        map =arr;
        size = arr.length;
        dfs(size,0,0);
        answer[0]=zero;
        answer[1]=one;
        
        return answer;
    }
    public void dfs(int size,int c,int r){
        if(size==1){
            if(map[c][r]==1){
                one++;
            }else{
                zero++;
            }
            return;
        }
        
        if( isSame(size,c,r)){
            return; // 같은지 여부 
        }
        dfs(size/2,c,r);
        dfs(size/2,c+size/2,r);
        dfs(size/2,c,r+size/2);
        dfs(size/2,c+size/2,r+size/2);
        
    }
    public boolean isSame(int size,int x, int y){
        int num =map[x][y];
        for(int i = x; i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(num != map[i][j]){
                    return false;
                }
            }
        }
        
        if(num==0){
            zero++;
        }else{
            one++;
        }
        return true;
    }
    
}
