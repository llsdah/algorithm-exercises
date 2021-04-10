package studyProgrammers;
/*

가장 큰 수
문제 설명
0 또는 양의 정수가 주어졌을 때, 
정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 
[6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	return
[6, 10, 2]	6210
[3, 30, 34, 5, 9]	9534330

*/

import java.util.Arrays;

public class Array2 {
	public static void main(String[] args) {
		
	int[] numbers = {6,10,2};
	String answer = solution(numbers);
	System.out.println(answer);
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length;i++) {
        	str[i] =numbers[i]+"";
        }
        System.out.println((str[1]+str[0]).compareTo(str[0]+str[1]));
        
        Arrays.sort(str, (a,b)->( (b+a).compareTo(a+b)));
        if(str[0].equals("0")) {
        	return "0";
        }
        for(String a:str) {
        	answer +=a;
        }
        
        
        return answer;
    }
}
/*
String answer = "";
String[] str = new String[numbers.length];
for(int i = 0; i < numbers.length; i++) str[i] = String.valueOf(numbers[i]);     

Arrays.sort(str, (a, b) -> ((b+a).compareTo(a+b))); //배열 정렬. 뒤랑 붙여보자
System.out.println(Arrays.toString(str));
if (str[0].equals("0")) return "0"; //0만 입력되는 경우. 예외처리
for(String s: str) answer += s; //문자열(String) 합치기

return answer;

*/