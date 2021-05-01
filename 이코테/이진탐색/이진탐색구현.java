package 이코테.이진탐색;

import java.io.InputStreamReader;
import java.util.Scanner;

public class 이진탐색구현 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		int n =scan.nextInt(); 
		int target = scan.nextInt();
		// 원소의 갯수 와 찾고자 하는 값 입력받기 
		
		int[] arr = new int[n];
		// 전체 원소의 갯수 
		for(int i =0; i< n; i++) {
			arr[i] = scan.nextInt();
		}
		
		//이진 탐색 ㅅ행 결과 출력
		int result = bs(arr,target,0,n-1);
	
		
	}

	// 반복분 통한 구현
	private static int bs(int[] arr, int target, int start, int end) {
		
		while(start <=end) {
			int mid = (start+end)/2;
			//찾은 경우 중간점 인덱스 반환
			if(arr[mid]==target) return mid;
			// 중간점보다 찾고자하는 값이 작은 경오 왼쪽 확인
			else if(arr[mid]>target) end = mid-1;
			// 중간점보다 큰 경우 오른쫌 탐색
			else start = mid+1;
			
		}
		return -1;
		
	}
	
}
