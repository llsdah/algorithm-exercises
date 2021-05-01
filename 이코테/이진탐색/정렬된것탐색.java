package 이코테.이진탐색;

import java.io.InputStreamReader;
import java.util.Scanner;

public class 정렬된배열에서의수구하기 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));
		//int n = scan.nextInt();
		//int m = scan.nextInt();
		int n = 7;
		int m = 2;
		int[] arr = {1,1,2,2,2,2,3};
		// 특정값이 등장하는 처음과 마지막 위치를 찾아 계산하는 것이 빠르다.
		
		
		
	}

}
/*
내가 생각한답 

		// 인텍스 값으로 시작합니다. 
		int start =0;
		int end = arr.length-1;
		
		int mid =0;
		boolean ck = true;
		int cnt =0;
		while(ck) {
			
			mid = (end+start)/2;
			
			if( arr[mid]==m) {
				
				ck= false;
			}else if (arr[mid]>m) {
				end = mid-1;
				
			} else if (arr[mid]<m) {
				start = mid+1;
			}
			
			if( start>=end) {
				ck =false;
				cnt =-1;
			}
		}
		
		if(cnt==-1) {
			System.out.println("없음");
		}else {
			cnt =1;
			for(int i=mid+1;i<arr.length;i++) {
				
				if(arr[i]==m) {
					cnt++;
				}else {
					break;
				}
			}
			
			for(int i=mid-1;i>=0;i--) {
				
				if(arr[i]==m) {
					cnt++;
				}else {
					break;
				}
			}
			System.out.println(cnt);
		}
		


*/
