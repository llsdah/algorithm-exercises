import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int[] cnt = new int[n+1];
        Arrays.fill(cnt,1);
        for(int k=0;k< reserve.length;k++){
            cnt[reserve[k]]++;        
        } // 여벌 있는 것 
        for(int i=0; i<lost.length;i++){
            cnt[lost[i]]--;
        }
        
        for(int i=1; i<cnt.length;i++){
            
            if(cnt[i]==0){
                if(i==1){
                    if(cnt[i+1]>=2){
                    cnt[i]++;
                    cnt[i+1]--;   
                    }
                }else if(i==cnt.length-1){
                    if(cnt[i-1]>=2){
                    cnt[i]++;
                    cnt[i-1]--;   
                    }
                } else{
                    if(cnt[i-1]>=2){
                    cnt[i]++;
                    cnt[i-1]--;   
                    }else if( cnt[i+1]>=2){
                        cnt[i]++;
                        cnt[i+1]--;
                    }
                }
                
            }
        }
        answer = (int)Arrays.stream(cnt).filter(i -> i >=1).count()-1;
        
        return answer;
    }
}
