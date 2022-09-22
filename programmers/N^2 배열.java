import java.util.*;


// 2차원 배열로 반들어야댐. 
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[n*n];
        // 2차원 배열을 만든다.
        //123 223 333
        //1234 3223 4444
        //12345 
        //22345
        //33345
        //44445
        //55555
        int idx =0;
        for(int i=1;i<=n;i++){
            for(int k =1;k<=n;k++){
                if(i>k) answer[idx]=i;
                else answer[idx] = k;
                idx++;
            }
        }
        int[] arr = new int[(int)(right-left+1)];
        idx=0;
        
        
        for(int temp = (int)left; temp<=right;temp++){
            arr[idx]=answer[temp];
            idx++;
        }
        
        return arr;
    }
}
