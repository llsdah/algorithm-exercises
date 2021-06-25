import java.util.*;
class Solution {
    // 정렬 한다. -> 깊은 복사 -> 각 사람의 수만큼 돌면서 최소값과 같아 지는 경우 해당 값에 그 값을 더한다.  
    // 최초의 사람은 무조건 들어간다 생각 그래서 여기는 것들이 변화 안함.. 그러나 갯수가 많아 탐색이 안됨. 
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long[] arr = new long[times.length];
        
        for(int i=0; i<times.length;i++){
            arr[i] = times[i]; // 해당 시점의 순간. 
        }
        
        for(int i=1; i<n;i++){
            for(int k=0; k<arr.length;k++){
                long temp = Arrays.stream(arr).min().getAsLong();
                if(arr[k]== temp){
                 arr[k]+=times[k];
                  break;
                }
            }
        }
        answer = Arrays.stream(arr).min().getAsLong();
        
        return answer;
    }
}
