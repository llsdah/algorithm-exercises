import java.util.*;
class Solution {
    // 이분 탐색 최대 시간 최소간 정한다. -> 중간 시간 정함. -> 그 시간동안 모든 사람이 검사 가능한지 체크, 시간이 남으면 줄이고, 적으면 늘린다. 
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long st = 0; // 시작 시간
        long end = (long)n*times[times.length-1];
        long mid = 0;
        while(st <= end){ // 교차되면 종료...
            mid =(st+end)/2;
            long sum = 0 ; // 몇명 검사 했는지 
            for(int i =0; i<times.length;i++){ // 빨리 심사하는 순 (이미 정렬)
               sum+=(mid/times[i]); 
            }
            if(sum<n) {
                st =mid+1; 
           }// 적은 인원수 처리
            else { 
                end = mid-1;
                 answer=mid;
            } // 더 많이 처리 하거나 같거나 . 하하하 . 같은 경우 떄문에 여기에 ans = mid가 같도록 
                   
        }       
        return answer;
    }
}
/*
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
*/
