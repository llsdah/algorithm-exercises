import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<scoville.length;i++){
            q.offer(scoville[i]);
        }
        int cnt=0;
        while(!q.isEmpty()&&q.peek()<K){
            if(q.size()==1) return -1;
            int st = q.poll();
            int end = q.poll();
            int sum = st+(end*2);
            q.offer(sum);
            cnt++;
        }
        if(q.isEmpty()) return -1;
        answer = cnt;
        return answer;
    }
}
