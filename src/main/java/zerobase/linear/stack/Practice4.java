package zerobase.linear.stack;

import java.util.Stack;

/**
 * 두문자열 비교
 * 3단 #은 바로 이전의 문자를 삭제하는 기능입니다.
 * tree == tp#ree
 */
public class Practice4 {

    public static void main(String[] args) {
        String a = "tree";
        String b = "tpp##ree";
        String checkA = check(a);
        String checkB = check(b);

        if(checkA.equals(checkB)){
            System.out.println("true");
        }
    }

    public static String check(String str1){
        Stack stack = new Stack();
        for(char c : str1.toCharArray()){
            if(c == '#' && !stack.isEmpty()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }
}
