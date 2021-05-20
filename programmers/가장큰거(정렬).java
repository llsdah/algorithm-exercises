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
