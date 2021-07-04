import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> st = new Stack<>();
        int cnt =0;
        loof : for(int i=0; i<number.length();i++){
            int num = number.charAt(i)-'0';
            if(st.isEmpty()){
                st.push(num);
                continue;
            }
    
            if(st.peek()>=num){
                st.push(num);
            }else{
                while(st.peek()<num){
                    st.pop();
                    cnt++;
                    if(cnt==k){
                        answer = number.substring(i);
                        break loof;         
                    }    
                    if(st.isEmpty()){
                        break;
                    }
                }
                st.push(num);
            }
            if(cnt==k){
                break;
            }
        }
        
       // System.out.println(st.size()+"  "+cnt);
        while(!st.isEmpty()){
            answer = st.pop()+answer;
            //sb.append(st.pop());
        }
        
        
        if( answer.length() >number.length()-k){
            answer = answer.substring(0,number.length()-k);
        }
        return answer;
    }
}
/* 0704 

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int value =0;
        int max = number.length() -k;
        int st = 0;
        StringBuilder sb = new StringBuilder();
        
        while(k>0){
            int pos =0; // 새로운 것이 시작할 위치 
            value =0;
            for(int i =st;i<number.length();i++){
                int num = 0;
                if(i+max>=number.length()){
                    num =Integer.valueOf(number.substring(i));
                }else num =Integer.valueOf(number.substring(i,i+max));

                if (num>value){
                    value = num;
                    pos = i+1;
                }
            }
            //System.out.println(value);
        
            if(pos!=0){
                sb.append(number.charAt(pos-1));    
            }
            k = pos-st;
            st = pos;
            max--;
        }
        
        answer = sb.toString();
        
        return answer;
    }
}

*/
/* 과거 형 
class Solution {
    String ans ="";
    int cnt = 0;
    public String solution(String number, int k) {
        String answer = "";
        // 자릿 수 구하는 형식으로 해보자 
        int max_nums = number.length()-k;
        String num = number;
        for(int i=max_nums;i>=1;i--){
            num = cut(num,i);
            if(cnt==k){ // 여기 조건 한개 더 필요 
                ans+=num;
                break;
            }
        }
        answer = ans;
        return answer;
    }
    public String cut(String num, int number){
        int idx = 0;
        String result ="";
        if( num.length()<=number){
            return result;
        }
        
        int comp = Integer.parseInt(num.substring(0,number));
        for(int i =1; i<num.length();i++){
            int temp = 0;
            if( num.length()==number+i ){
                temp = Integer.parseInt(num.substring(i));
            }else if (num.length()>number+i){
                temp = Integer.parseInt(num.substring(i,number+i));
            }else break;
            
            if(comp >= temp ){ continue;}
            else {
                idx = i;
                comp = temp;
            }
        }
        // idx == 자리 수 시작위치 
        result = num.substring(idx+1);
        
        cnt +=idx;
        ans+=num.charAt(idx);
        
        return result;
    }
}
*/
