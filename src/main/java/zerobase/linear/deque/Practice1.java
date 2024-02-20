package zerobase.linear.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

/**
 * 데이터 재 정렬
 * D-0 D-1 D-2 ... D-n 순서의 데이터를
 * D-0 D-n D-1 D-n-1 ...
 * 양끝으로 번갈아 가면서 정렬이 됩니다. !! 확인해 봅시다.
 *
 * 1 2 3 4 5
 * 1 5 2 4 3
 *
 */

public class Practice1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        solution(arr);
    }
    public static void solution(int[] arr){

        Deque deque = new ArrayDeque();
        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(x -> deque.addLast(x));
        while (!deque.isEmpty()){
            result.add(deque.removeFirst());
            if(!deque.isEmpty()){
                result.add(deque.removeLast());
            }
        }
    }
}
