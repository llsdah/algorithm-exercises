
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        answer = (long)money;
        long temp = price;
        for(int i=1; i<=count;i++){
            answer-= temp*i;
        }
        if(answer<0) answer = answer*(-1);
        else answer =0;
        

        return answer;
    }
}
