import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length;i++){
            int ans =prices.length-1-i;
            for(int k=i+1;k<prices.length;k++){
                if(prices[i] > prices[k]){
                    ans =k-i;
                    break;
                }
                
            }
            if(ans==0) ans=1;
            answer[i]= ans;
        }
        answer[answer.length-1]=0;
        return answer;
    }
}
