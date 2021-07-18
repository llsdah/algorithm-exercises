import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // 상관없이 두개 정렬해서 맞춰 가면되는데?
    
        Arrays.sort(A);
        Arrays.sort(B);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<B.length;i++){
            q.offer(B[i]);
        }
        for(int i=0; i<A.length;i++){
            
            while(!q.isEmpty()){
                if(q.peek()>A[i]){
                    q.poll();
                    answer++;
                    break;
                }
                q.poll();
            }
        }
        
        
        return answer;
    }
}
