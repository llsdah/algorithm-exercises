package studyProgrammers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

/*

큰 수 만들기
문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 
이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
 number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
입출력 예
number				k			return
1924					2			94
1231234			3			3234
4177252841		4			775841



*/
public class Greedy3 {
	public static void main(String[] args) {
	
		
		String number = "1231234";
		int k = 3;
		solution(number, k );
		
		
		
	}

	public static String solution(String number, int k) {
		String answer = "";
		
		// 메모리 축소를 위한 builber 설계
		StringBuilder sb = new StringBuilder();
		
		int temp = 0;
		int index=0;
		
		// 몇개 까지 입력을 하나요 
		for( int i =0; i<number.length()-k;i++) {
			
			//탐색 숫자 초기화. 
			temp =0; 
			
			//몇번쨰 부터 탐색하면되나요.
			for(int j = index;j<=k+i;j++) {
			
				if( temp <number.charAt(j)-'0') {
					
					
					temp = number.charAt(j)-'0';
					index = j+1;
					
				}
			}
			
			sb.append(temp);
		}
		answer = sb.toString();
		return answer;
	}
}




/*
 * 
 * class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<=k+ i; j++) {
         
                if(max < number.charAt(j)-'0') {
                
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
 */



















