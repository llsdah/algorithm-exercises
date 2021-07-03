class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();
        
        // 상하 이동 체크 중간은 N
        int ud =0;
        for(int i =0; i<arr.length;i++){
            if(arr[i]=='N'){
                ud+=13;
            }else if(arr[i]<'N'){
                ud+=(arr[i]-'A');
            }else {
                ud+=('N'-arr[i]+13);
            }
        }
        // 좌우이동의 최소값 찾기
        int move = arr.length-1;// 최소이동은
        for(int i =0; i <arr.length;i++){
            if(arr[i]!='A'){
                int next =i+1;
                while(next<arr.length&&arr[next]=='A'){
                    next++;
                }
                int temp = i*2+arr.length-next;
                move = Math.min(move,temp);
            }
        }
        
        answer = ud+move;
        return answer;
    }
}

/* 나중인데 한번 더 봐야게싿. 


import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();
        int sum =0;
        for(int i=0; i<arr.length;i++){
            int num =0;
            if(arr[i]=='N') num=13;
            else if(arr[i]>'N') num='N'-arr[i]+13;
            else num = arr[i]-'A';
                
            sum+=num;
        }
        int move=(int)1e9;
        for(int i=0;i<arr.length;i++){
            int next =i+1;
             while(next < arr.length && name.charAt(next) == 'A') next++;
            move = Math.min(move, i + arr.length - next + 
                            Math.min(i, arr.length - next));
        }
        
        sum+=move;
        return sum;
    }
    
}


/*
INT N =13;
A B C D E
F G H I J
K L M N O
P Q R S T 
U V W X Y 
Z

*/

*/
