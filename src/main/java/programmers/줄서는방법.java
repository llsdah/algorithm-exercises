import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long cnt = 1;
        for(int i=1; i<=n;i++){
            cnt*=i;
            list.add(i);// 숫자 넣어서 순서 나오게 하기 
        }
        k--;// 값을 추론하는데 0까지 할꺼니까 0==1 그러니 한개뺌
        int pos=0; //answer에 값 넣을 용도 
        while(n>0){
            cnt /=n;
            answer[pos] = list.get((int)(k/cnt));
            // long이니 일단 int 변환 후 해당 하는 몫 넣으면 나올 값
            pos++;// 다음으로 이동
            list.remove((int)(k/cnt)); // 넣은거 삭제 
            k%=cnt; // 그만큼 넣었으니 나머지만 다시 돌면됨
            n--; //한개 넣음 제거 
            
        }
        return answer;
    }
}
/*
import java.util.*;
class Solution {
    String ans ="";
    long[] d = new long[21];
    boolean[] visit;
    public int[] solution(int n, long k) {
        // 숫자 범위 안에 들어가는지 체크 이다.
        d[0] =1;
        visit = new boolean[n+1];
        visit[0]=true;
        
        for(int i=1; i<d.length;i++){
            d[i]= i*d[i-1];
        }
        
        long temp =k;
        int cnt =1;
        while(temp>=0){
            if(visit[cnt]) { // 이 숫자를 사용한 경험이 있다면 순차적인 다음 숫자로 넘어감. 
                cnt++;
                continue;
            }
            if(temp>d[n-1]){
                temp += - d[n-1];
                cnt++;
            }else{
                visit[cnt]=true;
                n--;
                ans+=cnt+",";
                cnt=1;
            }
        }
        
        
        String[] arr = ans.split(",");
        int[] answer = new int[arr.length];
        
        for(int i=0; i<arr.length;i++){
            answer[i] =Integer.valueOf(arr[i]);
        }
        
        return answer;
    }
}
*/
