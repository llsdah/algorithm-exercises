package 이코테.정렬;

import java.util.Arrays;

public class 두배열의원소교체 {

	public static void main(String[] args) {
		
		int arr1[] = {1,2,5,4,3};
		int arr2[] = {5,5,6,6,5};
		
		for(int i =0; i<arr1.length;i++) {
			
			for(int k =i; k<arr1.length;k++) {
				
				if( arr1[i]>arr1[k]) {
					int temp = arr1[i];
					arr1[i] =arr1[k];
					arr1[k] =temp;
				}
				
			}
		}
		
		for(int i =0; i<arr2.length;i++) {
			
			for(int k =i; k<arr2.length;k++) {
				
				if( arr2[i]>arr2[k]) {
					int temp = arr2[i];
					arr2[i] =arr2[k];
					arr2[k] =temp;
				}
				
			}
		}
		int k =3;
		
		
		for(int i =0; i<k;i++) {
			
			if( arr1[i]>arr2[arr2.length-1-i]) {
				break;
			} else {
				int temp = arr1[i];
				arr1[i] =arr2[arr2.length-1-i];
				
				arr2[arr2.length-1-i] =temp;
			}
		}
		
		System.out.println(Arrays.stream(arr1).sum());
		
	}
	
}
