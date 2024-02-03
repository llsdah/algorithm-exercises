package zerobase.linear.stack;

import java.util.Stack;

/**
 * 괄호 짝 검사를 합시다
 * () 가 한 쌍으로 움직이게
 */
public class Practice2 {

    public static void main(String[] args) {
        System.out.println(check("(((()))")); //false
        System.out.println(check("((()))")); //true


    }

    public static boolean check(String str){
        Stack stack = new Stack();

        boolean flag = false;
        for(String s : str.split("")){
            if(s.equals("(")){
                stack.push(s);
            }else{
                if(stack.isEmpty()){
                    flag =  false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }
        // 로직처리
        if(flag && stack.isEmpty()){
            return true;
        }

        return false;

    }


}
