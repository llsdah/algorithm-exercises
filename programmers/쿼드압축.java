import java.util.*;
class Solution {
    int[] cnt = new int[2];
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int num  =arr.length;
        dp(arr,0,0,num);// 배열 시작 열 행, 탐색 범위 
        answer[0] = cnt[0];
        answer[1] = cnt[1];
        return answer;
    }
    public void dp(int[][] arr,int row,int col, int num){
        if( num ==1){
            if(arr[row][col]==1) cnt[1]++;
            else cnt[0]++;
            return;
        }
        
        int value = arr[row][col];
        boolean flag = true; // 참인동안 돌라감. 
        loof : for(int i =row; i<row+num;i++){
            if(flag){
                for(int k=col; k<col+num;k++){
                    if(arr[i][k]!=value){
                        flag = false;
                        break loof;
                    }
                }
            }
        }
        
        if(flag){
            cnt[value]++;
        }else{
            int length = num/2;
            
            dp(arr,row,col,length);
            dp(arr,row,col+length,length);
            dp(arr,row+length,col,length);
            dp(arr,row+length,col+length,length);
        }
        
        
    }
}
