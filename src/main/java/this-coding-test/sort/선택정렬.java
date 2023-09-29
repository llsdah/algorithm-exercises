package 이코테.정렬;

import java.util.Arrays;

public class 선택정렬 {

	public static void main(String[] args) {
		
		int arr[] = {7,6,2,0,8,1,9};
		
		for(int i=0; i< arr.length;i++) {
			int idx = i;
			
			for(int k = i+1; k<arr.length;k++) {
				
				if( arr[idx]>arr[k]) {
					idx = k;
				}
				
			}
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx]= temp;
			
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	
}
