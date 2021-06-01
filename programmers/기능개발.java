import java.util.*;

class Solution {
    int maxday = 0;
    int[] cnt = new  int[100];
    public int[] solution(int[] progresses, int[] speeds) {
        for(int i=0; i <speeds.length;i++){
            count(progresses[i],speeds[i]);        
        }
        int[] answer = Arrays.stream(cnt).filter( i-> i !=0).toArray();
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
