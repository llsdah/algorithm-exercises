import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length;i++){
            que.add(works[i]);
        }
        for(int i=n;i>0;i--){
            int num = que.poll();
            if(num==0) break;
            que.add(num-1);
        }
        int temp = que.size();
        for(int i =0; i < temp;i++){
            int num = que.poll();
            answer+=(num*num);       
        }
        
        return answer;
    }
}
/* 수정 전 2
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int sum =0;
        for(int i=0; i<works.length;i++){
            sum+=works[i];
        }
        if(n>=sum) return 0;
        while(n>0){
            Arrays.sort(works);
            works[works.length-1]--;
            n--;
        }
         
        for(int i =0; i<works.length;i++){
            if(works[i]<=0) continue;
            answer+=(works[i]*works[i]);       
        }
        return answer;
    }
}
*/
/* 수정 전 1
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
*/
