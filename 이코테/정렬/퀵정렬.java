package 이코테.정렬;

import java.util.Arrays;

public class 퀵정렬 {

	public static void main(String[] args) {
		
		
		int arr[] = {7,6,2,0,8,1,9};
		int n = arr.length;
		
		quickSort(arr,0,n-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void quickSort(int[] arr, int start, int end) {
		
		// 원소 갯수가 한개인 경우 종료합니다. 
		if( start>=end) {
			return;
		}
		int pv = start;
		int left = start+1;
		int right = end;
		while(left<=right) {
			
			// 피벗보다 큰데이터를 찾을 떄까지 반복
			while(left<=end&&arr[left]<=arr[pv]) {
				left++;
			}

			// 비벗보다 작은 데이터를 찾을 때까지 반복
			while(right>start&&arr[right]>=arr[pv]) {
				right--;
			}
			
			// 엇갈린 경우 작은 데이터와 비펏을 교ㅔ 합니다. 
			if(left >right) {
				int temp = arr[pv];
				arr[pv] = arr[right];
				arr[right] = temp;
			}else { // 엇갈리지 않았다면 작은 데이터와 큰데이터를 교체 합니다.
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] =temp;
			}
			
		}
		// 분할 이후 왼쪽 부분과 오른쪼 ㄱ부분에서 각각 정렬 수행합니다. 
		quickSort(arr,start,right-1);
		quickSort(arr,right+1,end);
		
	}
	
}
