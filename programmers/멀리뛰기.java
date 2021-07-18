
// 심각하게 많이 틀리네 
import java.util.*;
class Solution {
    public long solution(int n) {
        long answer = 0;
        // 한번에 한칸 또는 두칸.
        long[] arr = new long[n+1];
        
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3;i<=n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        
        answer = arr[n]%1234567;
        return answer;
    }
}
