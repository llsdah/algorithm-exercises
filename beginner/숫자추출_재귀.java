package AlgorismStudyUtube;

import java.util.Arrays;

public class 숫자추출_재귀 {

	public static void main(String[] args) {
		
		// 높은 자리대로 출력
		
		System.out.println();
		extra(123 );
		
	}
	
	public static void extra(int n) {
		
		// 대부분 10으로 나눈 몫으로 추출 합니다. 
		
		if(n/10==0) {
			System.out.println(n);
			return;
			
		}
		
		extra(n/10);
		System.out.println(n%10);
	}
	
}
