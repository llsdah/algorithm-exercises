 import java.util.*;
class Solution {
    
    int end = 0;// 해당 시정의 끝 위치 
    boolean[] possible = new boolean[2];
    boolean flag = true;
    StringBuilder sb = new StringBuilder();
    public String solution(String sentence) {
        // 시작 1은 무조건 대문자 시작!! 
        // 시작 2는 무조건 소문자 시작.
        String answer = "";
        char[] arr =  sentence.toCharArray();
        if(arr[0]>='a'&&arr[0]<='z') { // 시작이 소문지면 2번째 입니다.
            small(arr);
            //possible[1] = !possible[1]; 
        }else {
            big(arr); // 대문자 시작일때
            flag= false;
        }

        if(flag){
            
        }else{
            small(arr);
        }
        System.out.println(sb.toString());
        return answer;
    }
    public void small(char[] arr){ // 작은거 찾는 거니까 가운데는 무조건 큰것
        char st = arr[end]; // 처음은 0이니까 두번쨰일떄도 end면 됨. 
        sb.append(" ");
        for(int i =end+1; i <arr.length;i++){
            if(st==arr[i]){
                end =i;//해당위치의 끝나는 점
                break;
            }
            sb.append(arr[i]);
        }
        sb.append(" ");
    }
    public void big(char[] arr){
        char st = arr[end+1]; // 이것이 소문자로 같아야댐
        sb.append(" ");
        for(int i=end;i<arr.length;i++){
            if(arr[i]>='a'&&arr[i]<='z') { // 시작이 소문지면 2번째 입니다.
                if(st != arr[i]){
                    end = i; // 끝점 저장. 한칸뒤가 대문자 이다.  
                    break;
                }
            }else{
                sb.append(arr[i]);// 소문자 아니면 대문자. 
            }   
        }
        // 대문자 한개 날려야댐
        sb.append(" ");
    }
}
