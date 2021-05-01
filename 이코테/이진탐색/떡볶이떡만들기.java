package 이코테.이진탐색;

import java.io.InputStreamReader;
import java.util.Scanner;

public class 떡볶이떡만들기 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));
		//int n = scan.nextInt();
		//int m = scan.nextInt();
		int n = 4;
		int m = 6;
		int[] arr = {19,15,10,17};
		int[] arr1 = new int[n];
		// 전체 원소의 갯수

		/*
		 * for (int i = 0; i < n; i++) { arr[i] = scan.nextInt(); }
		 */
		
		// 떡의 평균 수치에서 나눠 가면서 찾자 
		int aver =0;
		for(int i =0 ; i< arr.length;i++) {
			aver+=arr[i];
		}
		aver = aver/n;
		int cnt =0;		
		while (cnt!=m) {
			cnt = cut(arr,aver);
			
			if( cnt > m ) {
				aver++;
			} else if( cnt < m ) {
				aver--;
			}
			
		}
		System.out.println(aver);
	
	}

	private static int cut(int[] arr, int aver) {
		int cnt = 0;
		for(int i =0; i< arr.length;i++) {
			if( arr[i]>aver) {
				cnt+= (arr[i]-aver);
			} 
		}
		
		
		return cnt;
	}

}
