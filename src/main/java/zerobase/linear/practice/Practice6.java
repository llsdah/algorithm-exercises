package zerobase.linear.practice;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 순서대로 먼저 요청 먼저 수행
 * Queue -> FIFO에 따라 인쇄
 * 인쇄하기
 *
 * 문서의 중요도 확인  -> 현재 중요도보다 높은것이 나중에 있으면 맨뒤로 배치
 * 그렇지 않다면바로 인쇄
 * 출력의 인덱스 값대로 보여기제 해라
 *
 * 문서갯수 출력대상번호 우선순위     출력순서
 * 6      0          1 1 9  1 1  5
 */
public class Practice6 {
    public static void main(String[] args) {
        int docs = 1;
        int target = 0;
        int[] priority = {5};
        solution(docs,target,priority);

        docs = 4;
        target = 2;
        priority = new int[]{1,2,3,4};
        solution(docs,target,priority);

        docs = 6;
        target = 0;
        priority = new int[]{1,1,9,1,1,1};
        solution(docs,target,priority);

    }

    private static void solution(int docs, int target, int[] priority) {
        Queue<Practice6_doc> que = new LinkedList<>();

        for(int i = 0; i < docs; i++){
            que.add(new Practice6_doc(i,priority[i]));
        }
        int cnt = 1;

        while(true){

            Practice6_doc cur = que.poll();
            Practice6_doc[] highq = que.stream().filter(x -> x.priority > cur.priority).toArray(Practice6_doc[]::new);
            if(highq.length > 0){
                que.add(cur);
            }else{
                if(cur.no == target){
                    System.out.println(cnt);
                    break;
                }
                cnt++;
            }

        }

    }

}

class Practice6_doc{
    int no;
    int priority;
    public Practice6_doc(int no,int priority){
        this.no = no;
        this.priority = priority;
    }
}









