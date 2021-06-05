package AlgorismStudy1;

import java.util.Arrays;

// 재귀
public class Bit {

	public static void main(String[] args) {

		char[] arr = {'a' ,'b','c','d'};
		System.out.println((1<<0));
		print(arr,4);
		System.out.println();
		int[] nums = {1,2,3,4,5,6,7,6,9};
		count(nums,nums.length);
		
	}
	// 비트 활용해서 두수의 합 구하기 
	private static void count(int[] nums, int length) {
		int cnt =0;
		for(int i =0; i <(1<<length);i++) {
			int sum =0;
			for(int k =0;k<length;k++) {
				if( (i& 1<<k)!=0) {
					sum+=nums[k];
				}
			}
			if(sum==7) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
		
		
	}
	private static void print(char[] arr, int num) {
		
		for(int i =1; i< (1<<num);i++) {

			for(int k=0; k<num;k++) {
				if( (i & 1<<k) !=0   ) {
					System.out.print(i+""+arr[k]+""+k+" ");
				}
			}
		}
		
		
	}

}
