package 이코테.정렬;

import java.util.Arrays;

public class 선택정렬 {

	public static void main(String[] args) {
		
		int arr[] = {7,6,2,0,8,1,9};
		
		for(int i=0; i< arr.length;i++) {
			
			for(int k = i; k<arr.length;k++) {
				
				if( arr[k]<arr[i]) {
					int temp = arr[i];
					arr[i] = arr[k];
					arr[k] =temp;
				}
				
				
			}
			
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	
}
