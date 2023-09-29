import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        // n개의 자연수 이루어집 즉, 나누어서 젤 큰수 큰처를 더해가면댐.
        // 중복이 가능핟. 중요
        int[] answer = new int[n];
        int[] no = {-1};// 안되면
        if(n>s) return no;
        int num = s/n;
        int re = s%n;
        Arrays.fill(answer,num); // for문보다 효율적인가봐...
        for(int i=0; i<re;i++){
            answer[i]++; // 나머지를 돌아가면 추가 시키
        }
        Arrays.sort(answer);
        
        
        return answer;
    }
}
