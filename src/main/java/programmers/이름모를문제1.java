import java.util.*;
class Solution {

    int[] cnt =new int[2];
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int leng = arr.length;
        bina(arr,leng,0,0);
        
        return cnt;
    }
    public void bina(int[][] arr ,int leng,int col,int row){
        if(leng==0){
            return;
        }
        int num = arr[row][col];
        boolean check = true;
        for(int i =row;i<row+leng;i++){
            for(int k=col;k<col+leng;k++){
                if(num!=arr[i][k]) check =false;
            }
        }
        if(check){
            cnt[num]++;
            return;
        }
        bina(arr,leng/2,col+leng/2,row);
        bina(arr,leng/2,col,row+leng/2);
        bina(arr,leng/2,col+leng/2,row+leng/2);
        bina(arr,leng/2,col,row);          
    }
}
