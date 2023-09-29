// 시간 초과 부분 큐가 아니라 그냥 stations 자체의 코드를 통해 풀면되겠다. 
import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(stations);
        for(int i =0;i<stations.length;i++){
            q.offer(stations[i]); // 설치 아파트 추가
        }
        int pos = 1;// 시작지점이 111
        while(pos<=n){ // 같아 질떄까지 있는지 체크
            // 비어 있으면 안대!!,
            // 범위안에 있으면
            if(!q.isEmpty() && pos >= q.peek()-w){
                pos = q.poll()+w+1;// 범위 밖으로 이동!!
            }else{ // 범위에 없다!
                answer++;// 기지국 하나 뚝딱
                pos +=(w*2+1); //설치했으니 해당범위 밖으로 이동. 
                
            }
            
        }
        
        return answer;
    }
}

/* 시간 초가. 
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
            for(int k= (num-w >0 ? num-w : 0); k<= (num+w <= n-1 ? num+w : n-1);k++) {
                home[k]=true;
            }  
        }
        int mid =0;
        for(int i=0; i<n;i++){
            if(!home[i]){
                mid = i+w;
                check(home,mid,w);
                answer++;
            }
        }
        return answer;
    }
    public void check(boolean[] home, int mid, int w){
        while(mid>0&&home[mid]){
            mid--;
        }
        int st = mid-w;
        int end = mid+w;
        for(int i= (st > 0 ? st : 0); i<= (end <=home.length-1 ? end : home.length-1 );i++){
            home[i]=true;
        }
        
    }
}


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
*/
