import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        // 2가지 경우 끝에 것을 안떈다 뗸타 
        int leng = sticker.length;
        int[] one = new int[leng]; // 마지막 안훔침
        int[] two = new int[leng];
        
        one[0] = sticker[0];
        one[1] = Math.max(sticker[0],sticker[1]);
        // 둘중 큰 값이 오도록!
        for(int i=2; i<leng;i++){
            one[i] = Math.max(one[i-1],sticker[i]+one[i-2]);
        }
        
        // 마지막 것을 훔치는 경우, 첫번쨰는 0
        two[1] = sticker[1];
        
        for(int i=2; i<leng;i++){
            two[i] = Math.max(two[i-1],sticker[i]+two[i-2]);
        }
        
       answer = Math.max(one[leng-2],two[leng-1]); 
       //첫번쨰는 마지막을 안훔친다!!! 주의!!

        return answer;
    }
}
