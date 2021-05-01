package 이코테.정렬;

import java.util.Arrays;

public class 계수정렬 {

	public static void main(String[] args) {
		
		int arr[] = {7,6,2,0,8,1,9,9,9};
		
		int num = Arrays.stream(arr).max().getAsInt()
				- Arrays.stream(arr).min().getAsInt()+1;
		
		int[] cnt = new int[num];
		
		for(int i = 0; i <arr.length;i++) {
			
			cnt[arr[i]]++;
			
		}
		
		for(int i =0; i <cnt.length;i++) {
			
			for(int k =0; k<cnt[i];k++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		
		
		System.out.println(Arrays.toString(arr));
		
	}
	
}
