import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int pos =people.length-1;
        for(int i=0; i<=pos;i++){
            if(people[i]+people[pos]<=limit){
                answer++;
                pos--;
            }else{
                answer++;
                pos--;
                i--;
            }
        }
        return answer;
    }
}
