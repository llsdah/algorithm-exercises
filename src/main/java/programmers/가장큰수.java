import java.util.*;
// 내림차순 검사 . 하기 
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i =0; i <arr.length;i++){
            arr[i] = numbers[i]+"";
        }
        // 재정의 정의 하기
        Comparator<String> comp = (n1,n2) -> (n2+n1).compareTo(n1+n2);
        Arrays.sort(arr ,comp);
        
        if(numbers.length==1){
            return numbers[0]+"";
        }
        
        String temp = "";
        for(int i=0;i<numbers.length;i++){
            temp+=arr[i];
        }
        
        return temp;
    }
}


/* 시간초과
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        for(int i =0; i<numbers.length;i++){
            for(int k=i+1;k<numbers.length;k++){
                int st = Integer.valueOf(numbers[i] +""+ numbers[k]);
                int end = Integer.valueOf(numbers[k] +""+ numbers[i]);
                if(st<end){
                    int temp = numbers[i];
                    numbers[i] = numbers[k];
                    numbers[k]= temp;
                }
            }
        }
        for(int i =0; i<numbers.length;i++){
            answer+=numbers[i];
        }
        return answer;
    }
}


*/
