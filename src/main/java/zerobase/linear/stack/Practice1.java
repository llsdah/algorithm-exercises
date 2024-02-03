package zerobase.linear.stack;

import java.util.Stack;

/**
 * 문자열 뒤집기
 * h e l l o -> olleh
 */
public class Practice1 {

    public static void main(String[] args) {

    }
    public String reverseStack(String str){
        Stack stack = new Stack();
        String result = "";

        for(String s : str.split(" ")){
            stack.push(s);
        }
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
    }
}
