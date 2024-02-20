package zerobase.linear.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Palindrome
 *
 */
public class Practice2 {

    public static void main(String[] args) {

    }

    public static boolean checkPalindrome(String str){
        Deque deque = new ArrayDeque();
        boolean isFront = true;
        boolean isPalindrome = true;

        for(String s: str.split(" ")){
            deque.addFirst(s);
        }
        while(!deque.isEmpty()){
            String s1 = (String)deque.pollFirst();
            String s2 = (String)deque.pollLast();

            // 값이 있는 경우에만 다르면 에러이다.
            if(s1 != null && s2 !=null && !s1.equals(s2)){
                isPalindrome = false;
                break;
            }

        }
        return isPalindrome;
    }

}
