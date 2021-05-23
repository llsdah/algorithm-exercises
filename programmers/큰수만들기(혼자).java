import java.util.*;

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
