package AlgorismStudyUtube;

import java.util.Arrays;

// 피보나치 수열
public class 더하기123 {

	
	public static void main(String[] args) {
		
	int n=4;
	cache[1] = 1;
	cache[2] = 2;
	cache[3] = 4;
		
	System.out.println(doFunc(n));
		
	}
	static int cache[] = new int[1001];

	public static int doFunc(int n ) {
		if(cache[n]!=0) {
			return cache[n];
		}
		return cache[n] = doFunc(n-1) +doFunc(n-2)+doFunc(n-3);
	}
	
	
}
