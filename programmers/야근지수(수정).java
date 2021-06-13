import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        while(n>=works.length){
            for(int i =0; i<works.length;i++){
                if(works[i]<=0) continue;
                works[i]--;
                n--;
            }
        }
        
        while(n>0){
            int max = Arrays.stream(works).max().getAsInt();
            
            for(int i =0; i<works.length;i++){
                if(n<=0) break;
                else if( max == works[i]){
                    works[i]--;
                    n--;
                }
            }
        }
        
        for(int i =0; i<works.length;i++){
            if(works[i]<=0) continue;
            answer+=(works[i]*works[i]);       
        }
        return answer;
    }
}
