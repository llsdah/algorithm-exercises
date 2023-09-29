
package Algorism;

import java.util.Arrays;

public class 가장긴바이토닉_DP {

	public static void main(String[] args) {

		// 증가하는 부분과 감소하는 부분이 있는 수열. => 바이토닉 수열 
		
		int[] dpH = new int[1001];
		int[] dpL = new int[1001];
		
		Arrays.fill(dpH, 1);
		Arrays.fill(dpL, 1);
		
		int[] input = {1,5,2,1,4,3,4,5,2,1};
		int cnt = 9; // 전체 인덱스 니까 다 포함 할꺼니까 .. 한개 뺀거 로
	
		
		for( int i =2; i<=cnt;i++) {
			
			for(int k=i;k>=1;k--) {
				
				if(input[k]<input[i]) {
					dpH[i] =Math.max(dpH[i], dpH[k]+1);
				}
				
			}
			
		} //최대 값등 

		
		for( int i =cnt-1; i>=1;i--) {
			
			for(int k=i;k<=cnt;k++) {
				
				if(input[k]<input[i]) {
					dpL[i] =Math.max(dpH[i], dpH[k]+1);
				}
				
			}
			
		}
	
		int max = 0;
		for( int i =0; i<=cnt ;i++) {
			if(max < dpH[i]+dpL[i]) {
				max = dpH[i]+dpL[i];
			}
		}
		
		
		System.out.println(max-1);
	}
	
	
	
}
