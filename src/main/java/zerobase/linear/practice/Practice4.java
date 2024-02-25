package zerobase.linear.practice;

import java.util.HashMap;
import java.util.Stack;

/**
 * 괄호 홀짝 검사
 * 정상 닫혀 있는지
 */
public class Practice4 {

    public void sol(String str){
        Stack<String> stack = new Stack<>();
        boolean check = true;
        HashMap<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");

        for(String s : str.split("")){
            if(map.containsKey(s)){
                stack.push(s);
            }else if(map.containsValue(s)) {
                if (stack.isEmpty()) {
                    check = false;
                    break;
                } else {
                    String cur = stack.pop();
                    if (!s.equals(map.get(cur))) {
                        check = false;
                        break;
                    }
                }
            }
        }

        if(check && stack.isEmpty()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }

}
