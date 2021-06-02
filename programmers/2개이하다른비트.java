class Solution {
    int max = 0;
    public long[] solution(long[] numbers) {
        int leng = numbers.length;
        long[] answer = new long[leng];
        for(int i =0; i< leng;i++){
            max =0;
            char[] st = bi(numbers[i]);
            answer[i] = cnt(st,numbers[i]+1);
        }
        return answer;
    }
    public long cnt(char[] st, long num){
        boolean flag = true;
        while(flag){
            int cnt =0;
            char[] arr = bi(num);
            for(int i=0; i <max+1;i++){
                if(st[i]!=arr[i]){
                    cnt++;
                }
                if(cnt>=3) break;
            }
            if( cnt<=2){
                flag = false;
                return num;
            }
            num++;
        }
        return num; 
    }
    
    public char[] bi(long num){
        StringBuilder sb = new StringBuilder();
        while(num > 0 ){
            sb.append(num%2);
            num=num/2;
        }
        max = Math.max(max,sb.toString().length());
        String str = sb.toString()+"0000000000000000000000000"; 
        return str.toCharArray();
    }
}

/*
정답!!
import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        int leng = numbers.length;
        long[] answer = new long[leng];
        for(int i =0; i< leng;i++){
            if(numbers[i]%2==0){
                answer[i] = numbers[i]+1;
                continue;
            }
            char[] st = bi(numbers[i]);
            answer[i] = cnt(st);
        }
        return answer;
    }
    public long cnt(char[] st){
        int pos = 0;
        for(int i =0; i<st.length;i++){
            if(st[i]=='0'){
                pos =i;// 자리 저장 
                st[i]='1';
                break;
            }
        }
        for(int i =pos-1;i>=0;i-- ){
            if(st[i]=='1'){
                st[i]='0';
                break;
            }
        }
        long num =0;
        for(int i=0; i<st.length;i++){
            num+= ((st[i]-'0')*Math.pow(2,i));
        }
        //System.out.println(Arrays.toString(st));
        return num; 
    }
    
    public char[] bi(long num){
        StringBuilder sb = new StringBuilder();
        while(num > 0 ){
            sb.append(num%2);
            num=num/2;
        }
        String str = sb.toString()+"0"; 
        return str.toCharArray();
    }
}

*/
