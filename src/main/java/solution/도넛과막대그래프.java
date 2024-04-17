package solution;
import java.util.*;
public class 도넛과막대그래프 {
    public int[] solution(int[][] edges) {
        int[] answer = {0,0,0,0};

        /**

         정점 = 나가는것만 있는것.
         도넛 = 한정점 -> 본인회귀
         막대 = 한정점 -> 직선 한점
         팔자 = 한정점기준-> 순환 2개

         => 그래프에 대한 이해가 있어야 합니다.

         정점 = 나가는 것만 있고 들어오는 것이 없는것, 단 유형이 최소 2가지 이므로 최소 2개 이상 나감
         도넛 = 들어오는거 1개 나가는것 1개
         팔자 = 정점이 둘어오는것 2, 나가는것 2

         */

        // 가는것 나가는것 카운트 위해서
        Map<Integer, int[]> cnt = new HashMap<>();

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            if(!cnt.containsKey(a)){
                cnt.put(a,new int[]{0,0});
            }
            if(!cnt.containsKey(b)){
                cnt.put(b,new int[]{0,0});
            }
            int[] aArr = cnt.get(a);
            aArr[0]++;
            cnt.put(a,aArr);

            int[] bArr = cnt.get(b);
            bArr[1]++;
            cnt.put(b,bArr);
        }

        for(int key : cnt.keySet() ){
            int[] value = cnt.get(key);

            if(value[0]>=2&&value[1]==0){
                answer[0] = key;
            }else if(value[0]==0&&value[1]>=1){
                // 들어오는정점 갯수
                answer[2]++;
            }else if(value[0]>=2&&value[1]>=2){
                // 정점으로 부터 들어옴
                answer[3]++;
            }
        }

        answer[1] = cnt.get(answer[0])[0] - answer[2] - answer[3];


        return answer;
    }

}
