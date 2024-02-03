package zerobase.linear.stack;

import java.util.Stack;

/**
 * 후위표기법을 통한 연산
 * 괄호를 치며 중위를 후위로 바뀌어 보면 알 수 있습니다.
 * 22+ -> 4
 *
 * 52-  3
 * 25-  -3
 */

public class Practice3 {

    public static void main(String[] args) {
        String str1 = "1 1 + 2 * 3 * 2 / 5  -";

        double test = backCount(str1);
    }

    public static Double backCount(String number){
        Stack<Double> stack = new Stack();

        for(String str : number.split(" ")){

            if(str.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(str.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(str.equals("/")){// 앞에다가 붙여야합니다.!! 뒤에서 부터 나오니까!
                stack.push(1/stack.pop()*stack.pop());
            }else if(str.equals("-")){ // 앞에다가 붙여야합니다.!! 뒤에서 부터 나오니까!
                stack.push(-stack.pop()+stack.pop());
            }else{
                stack.push(Double.parseDouble(str));
            }

        }
        return stack.pop();
    }
}
