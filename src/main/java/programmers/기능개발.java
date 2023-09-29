// 최근 Array 배열 변환 확인. 
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 최대 값 정리 . => arr 숫자 카운팅 집에 넣고.. String 해서 추력... 변환 출력
        int[] day = new int[progresses.length];
        day[0] = day(100- progresses[0],speeds[0]);
        for(int i =1; i<day.length;i++){
            int num = 100- progresses[i];
            day[i] = day(num,speeds[i]);
            day[i] = Math.max(day[i-1],day[i]);
        }
        // 숫자 변환
        int[] arr = new int[101];
        for(int i=0; i<day.length;i++){
            arr[day[i]]++;
        }
        String str ="";
        for(int i=1;i<101;i++){
            if(arr[i]==0) continue;
            str +=arr[i]+",";
        }
        String[] str_arr = str.split(",");
        int[] answer = new int[str_arr.length];
        for(int i=0; i<answer.length;i++){
            answer[i] = Integer.valueOf(str_arr[i]);
        }
        return answer;
    }
    public int day(int num, int spd){
        int cnt =0;
        while(num>0){
            num= num-spd;
            cnt++;
        }
        return cnt;
    }
}


// 고거
import java.util.*;

class Solution {
    int maxday = 0;
    int[] cnt = new  int[100];
    public int[] solution(int[] progresses, int[] speeds) {
        for(int i=0; i <speeds.length;i++){
            count(progresses[i],speeds[i]);        
        }
        int[] answer = Arrays.stream(cnt).filter( i-> i !=0).toArray(); //확인요망. 
        return answer;
    }
    public void count(int pro, int speed){
        int day =0;
        int per =0;
        while(per<100){
            per =pro+speed*day;
            day++;
        }
        maxday = Math.max(day,maxday);
        cnt[maxday]++;
    }
}
