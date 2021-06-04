import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2]; // 최고 최 저 
        int zero = 0;
        int cnt =0;
        for(int i=0;i<lottos.length;i++){
            int lotto = lottos[i];
            if(lotto==0) {
                zero++;
                continue;
            }
            for(int k =0; k<win_nums.length;k++){
                if(lotto==win_nums[k]){
                    cnt++;
                    break;
                }
            }
        }
        answer[0] =prize(cnt+zero);
        answer[1] =prize(cnt);
        
        return answer;
    }
    public int prize(int num){
        int prize = 0;
        if( num>=6){
            prize=1;
        }else if ( num>=5){
            prize=2;
        }else if ( num>=4){
            prize=3;
        }else if ( num>=3){
            prize=4;
        }else if ( num>=2){
            prize=5;
        }else{
            prize =6;
        }
        return prize;
    }
}
