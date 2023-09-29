import java.util.*;
class Solution {
    public String solution(String sentence) {
        String answer = "";
        // 규직 1과 2 나누어 생가가 
        ArrayList<Integer> pos = new ArrayList<>(); // 위치 지정용 
        ArrayList<String>  word = new ArrayList<>();
        
        char temp = ' ';
        char[] arr = sentence.toCharArray();
        int leng = sentence.length();
        String no = "invalid";
        
        
        while(leng>0){ //무조건 참
            if(leng<3) return no;
            
            // 규칙 2 소문자로 시작 합니다. 
            if(small(arr,0)){
                temp = arr[0];
                int index = 0;
                for(int i=1; i<leng;i++){
                    if(arr[i]==temp){
                        index =i;
                        break;   
                    }
                }
                if(index==0) return no;
                word.add(sentence.substring(0,index+1));// 여기까지가 정답입니다.
                sentence = sentence.substring(index+1);
                arr = sentence.toCharArray(); // 새롭게 재정의 
                leng = arr.length;
            }else{
                // 규칙 1번 대문자
                if(!small(arr,1)) return no;
                temp = arr[1];// 두번쨰 부터 소문자니까 
                
                int index = -1;
                for(int i =2; i<leng;i++){
                    if(small(arr,i)){
                        index =i;
                        if(arr[index]!= temp) break;
                    } // 작은 문자? 그리고 달라지면 종료!
                }
                
                if(index == -1) return no ;// 안된다는 거니까
                
                while(index>=1){
                    if( temp==arr[index]) break;
                    index--;
                }
                word.add(sentence.substring(0,index+2));//?
                sentence = sentence.substring(index+2);
                arr = sentence.toCharArray();
                leng = arr.length;
            }
            
        }// while 건
        StringBuilder sb = new StringBuilder();
        for(String str : word){
            sb.append(check(str));
            sb.append(" ");
        }    
        answer = sb.toString().trim();   
        return answer;
    }
    public String check(String str){
        char[] arr = str.toCharArray();
        if(small(arr,0)) str = str.replace(arr[0],' ');
        if(small(arr,1)) str = str.replace(arr[1],' ');
        if(small(arr,2)) str = str.replace(arr[2],' ');
       str= str.replace(" ","");
        
        return str;
        
    }
    public boolean small(char[] arr, int index ){
        if(arr[index]>='a'&&arr[index]<='z') return true;
        return false;
    }
    
}

/*
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

*/
