package zerobase.linear.queue;

import javafx.scene.SubScene;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 카드 섞기
 * 1번이 맨위 N이 가장 아래 위치
 * 한장만 남을떄까지 반복 시 남는 카드 번호
 * 1. 맨위 버림 -> 2. 그 다음 위 카드를 맨 아래 넣음
 *
 * 4장 -> 4
 * 7장 -> 6
 * 9장 -> 2
 */
public class Practice1 {
    public static void main(String[] args) {
        int num = card(9);
        System.out.println(num);
    }

    public static int card(int N){
        Queue queue = new LinkedList();

        IntStream.range(1,N+1).forEach(x-> queue.add(x));
        System.out.println(queue);

        while(queue.size()>1){
            queue.remove(); //맨위 제거

            int data = (int)queue.remove();
            queue.add(data); //맨 아래 추가

            System.out.println(queue);
        }

        return (int)queue.remove();
    }
}
