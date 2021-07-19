import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // 그리디로 풀자 
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // 가정의 수 + 현재 기지국 위치 + 범위 
        //System.out.println("Hello Java");
        boolean[] home = new boolean[n];
        for(int i=0; i<stations.length;i++){
            int num = stations[i]-1;// 위치 한개 빼기 
            for(int k= (num-w >0 ? num : 0); k< (num+w < n ? num : n);k++) {
                home[k]=true;
            }  
        }
        int st = 0;
        int end = 0;
        for(int i=0; i<n;i++){
            if(!home[i]){
                st= i;
                end = i+2*w;
                check(home,st,end);
                answer++;
            }
        }
        return answer;
    }
    public void check(boolean[] home, int st, int end){
        for(int i=st;i< (end <home.length ? end : home.length );i++){
            home[i]=true;
        }
        
    }
}
