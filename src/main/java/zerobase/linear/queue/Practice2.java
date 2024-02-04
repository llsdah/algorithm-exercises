package zerobase.linear.queue;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 요세푸스 문제
 * N,K , N 명, K번째 사람을 제외함
 * 모든 사람이 제외 될때 까지 반복해, 제외되는 순서가 요세푸스 순영
 * 제외된 다름번이 첫번쨰
 *
 * N 5, K 2
 * 2,4,1,5,3
 *
 * N 7, K 3
 * 3,6,2,7,5,1,4
 *
 */
public class Practice2 {
    public static void main(String[] args) {
        System.out.println(solution(4,4));
        System.out.println(solution(7,3));
    }

    public static ArrayList solution(int N, int K){
        Queue queue = new LinkedList<>();
        ArrayList list = new ArrayList();
        IntStream.range(1,N+1).forEach(x -> queue.add(x));

        int cnt =0;

        while(!queue.isEmpty()){
            int data = (int) queue.remove();
            cnt+=1;
            if(cnt%K==0){
                list.add(data);
            }else {
                queue.add(data);
            }
        }
        return list;
    }


}
