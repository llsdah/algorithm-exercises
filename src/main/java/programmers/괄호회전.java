import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int num = s.length();
        int cnt = 0;
        for(int i =0; i< num;i++){
            String arr1 = s.substring(i);
            String arr2 = s.substring(0,i);
            if(check(arr1,arr2)){
                cnt++;
            }
        }
        answer = cnt;
        return answer;
    }
    public boolean check(String str1,String str2){
        Stack<Character> st = new Stack<>();
        String str = str1+str2;
        //System.out.println(str);
        char[] arr = str.toCharArray();
        boolean flag = true;
        
        for(int i=0; i<arr.length;i++){
            if(arr[i]=='('||arr[i]=='{'||arr[i]=='['){
                st.push(arr[i]);
                continue;
            }else if(st.isEmpty()){
                flag =false;
                break;
            }
            if(arr[i]==')'&&st.peek()=='('){
                st.pop();
            } else if(arr[i]==']'&&st.peek()=='['){
                st.pop();
            } else if(arr[i]=='}'&&st.peek()=='{'){
                st.pop();
            }else {
                flag= false;
                break;
            }
            
        }
        if(st.size()!=0){
            flag=false;
        }
        return flag;
    }
}
