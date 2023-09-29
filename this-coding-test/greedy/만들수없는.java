package 이코테.Greedy;

import java.util.Arrays;

public class 만들수없는금액 {

	public static void main(String[] args) {

		int n =5;
		int[] arr = {3,2,1,1,9};
		
		Arrays.sort(arr);
		
		int target=1;
		for(int i=0; i< n;i++) {
			
			if( target< arr[i] ) {
				break;
			}
			target+=arr[i];
		}
		
		System.out.println(target);
		
	}
}
