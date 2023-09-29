import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] nums= new int[n+2];
        Arrays.fill(nums,1);
        nums[0]=0;
        nums[n+1]=0;
        // 남은거 한개씩 더해 주기 
        for(int i=0;i<reserve.length;i++){
            nums[reserve[i]]++;
        }
        //없으면 스스로 뺴기 ..
        for(int i=0; i<lost.length;i++){
            nums[lost[i]]--;
        }
        System.out.println(Arrays.toString(nums));
        // 옆에 있는거 부터 2개 이상이면 뻇끼 
        for(int i=0; i<lost.length;i++){
            if(nums[lost[i]]>=1){
                continue;
            }else if(nums[lost[i]-1]>=2) { // 앞사람에게 빌리
                nums[lost[i]-1]--;
                nums[lost[i]]++;
            }else if( nums[lost[i]+1]>=2){ // 뒤사람 빌리
                nums[lost[i]+1]--;
                nums[lost[i]]++;
            }
        }
        System.out.println(Arrays.toString(nums));
        answer = (int)Arrays.stream(nums).filter(i -> i>=1).count();
        
        return answer;
    }
}

/* 옛날 꺼 . 
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


*/
