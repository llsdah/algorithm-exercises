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
        for(int i=0; i<n;i++){
            answer[i]=num; // 중간 수로 다 채우기
        }
        for(int i=0; i<n;i++){
            if(re==0) break;
            answer[i]++; // 나머지를 돌아가면 추가 시키기
            re--;
        }
        Arrays.sort(answer);
        
        
        return answer;
    }
}
