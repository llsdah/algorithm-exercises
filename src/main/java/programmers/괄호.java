import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        Stack<Character> st  = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i < arr.length;i++){
            if(arr[i]=='('){
                st.push(arr[i]);
            }else if(st.isEmpty()){
                return false;
            }else if(map.get(arr[i])!= st.pop()){
                return false;
            }
        }
        
        if(!st.isEmpty()){
            return false;
        }
        return answer;
    }
}
