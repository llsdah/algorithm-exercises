import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[] dp1 =new int[len];
        int[] dp2 =new int[len];
        // 마지막 것 을 훔친다 ? 0 번쨰는 0 입니다.
        dp1[1] = money[1];
        
        for(int i=2;i<len;i++){
            dp1[i]= Math.max(money[i]+dp1[i-2],dp1[i-1]);
        }
        // 안훔침..
        
        dp2[0]=money[0];
        //dp2[1]=Math.max(money[0],money[1]);
        dp2[1]=money[1];
        for(int i=2; i<len;i++){
            dp2[i]=Math.max(dp2[i-1],money[i]+dp2[i-2]);
        }
        
        answer = Math.max (dp1[len-1],dp2[len-2]);
        return answer;
    }
}
