package zerobase.linear.practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 스택 LIFO
 * 수열을 만들것이다.
 * 단, 스택에 push하는 순서가 반드시 오름차순을 지키도록 하자.
 *
 * 임의의 수열이 주어졌을때 그수열을 만들 수 있는지
 * 있다면 어떤 순서로 push와 pop 수행해야 되는지
 *
 * 같은정수 2번은 없다.
 *
 * 배열               결과(스택 출력) +push, - ㅔㅐㅔ
 * 4 3 6 8 7 5 2 1    ++++__++_++_____
 * 1 2 5 3 4          NO
 *
 *
 * 즉, 스택에서는 1 2 3 4 5 6 7 8 9 계속 입력 중이다.
 * 입력하다가 배열의 숫자를 만나면 pop 한다, 앞의 숫자면 다시 push한다.
 *
 */
public class Practice7 {
    public static void main(String[] args) {
        int[] num = {4,3,6,8,7,5,2,1};
        solution(num);

        num = new int[]{1,2,5,3,4};
        solution(num);

    }

    private static void solution(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();

        int idx = 0;

        for(int i=0;i<nums.length;i++){
            int num= nums[i];
            if(num>idx){
                for(int k=idx+1;k<num+1;k++){
                    stack.push(k);
                    list.add("+");
                }
                idx = num;
            }else if(stack.peek() != null){
                System.out.println("NO");
                return;
            }
            stack.pop();
            list.add("-");

        }

        for(String item : list){
            System.out.print(item+" ");
        }
        System.out.println("???");

    }

}












