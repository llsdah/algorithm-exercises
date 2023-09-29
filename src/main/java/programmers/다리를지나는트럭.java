import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // q를 생성해서 다리 길이만큼 0을 넣어줍니다.
        // 다리위에 존재하는 합계 구하면서 비교해 넘치면 0 넣고 아니면 트럭 올리면됩니다. 
        // 넘칠때마다 트럭이 내려오면 합계에서 빼면 됩니다>!
        int answer = 0;
        int sum =0;
        int pos =0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i <bridge_length;i++){
            q.offer(0);
        }
        while(!q.isEmpty()){
            sum+=-q.poll(); // 1초마다 계속 지나 갑니다. 
            if( pos <truck_weights.length){ //남은 트럭있음.
                if(sum+truck_weights[pos]<=weight){
                    q.offer(truck_weights[pos]);//합보다 작으면 올리 수 있다. 
                    sum+=truck_weights[pos];// 올렸으니더하고
                    pos++;
                }else{
                    q.offer(0);// 못올리면 0 넣고. 
                }    
            }
            answer++;// 시간 올리고.
            
        }
        
        
        return answer;
    }
}
