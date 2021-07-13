import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] one = new int[money.length];
        int[] two = new int[money.length];
        // 그리디 많이 찾는거는 뒤에서 부터 찾으면 쉽다. 
        // 2가지의 경우로 나누어서 풀기 
        // 1. 마지막 것을 안훔치는 경우 
        one[0] = money[0];
        one[1] = money[1];
        for(int i=2;i<money.length;i++){
           one[i] = Math.max(one[i-1],money[i]+one[i-2]); 
        }
        
        // 2. 마지막 것을 훔치는 경우 즉, 첫번쨰는 0 이다. 
        two[1] = money[1];
        for(int i=2;i<money.length;i++){
           two[i] = Math.max(two[i-1],money[i]+two[i-2]); 
        }
        answer = Math.max(one[money.length-2],two[money.length-1]);
        //여기 마지막 중요 마지막것 안 훔치니까 첫번쨰는 두번째 걸로 해야댕! 
        return answer;
    }
}


/*
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
*/
