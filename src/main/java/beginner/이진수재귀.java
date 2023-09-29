package AlgorismStudyUtube;

import java.util.Arrays;

public class 이진수_재귀 {

	public static void main(String[] args) {

		// 높은 자리대로 출력

		System.out.println();
		bina(123);
		//1111011
		//1 2 8 16 32 64 

	}

	public static void bina(int n) {

		// 2진수 변환
		if( n/2==0) {
			System.out.print(n);
			return;
		}
		bina(n/2);
		System.out.print(n%2);
	}

}
