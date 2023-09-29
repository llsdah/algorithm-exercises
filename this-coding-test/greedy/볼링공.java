package 이코테.Greedy;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		
		int n =8;
		int m =5;
		int[] arr = {1,5,4,3,2,4,5,2};
		int[] cnt = new int[m+1];
		
		
		int ans = 0;
		for(int i=0; i<arr.length;i++) {
			
			cnt[arr[i]]++;
		}
		System.out.println(Arrays.toString(cnt));
		for(int i =1; i<cnt.length;i++) {
			n =n - cnt[i];
			ans += (cnt[i]*n);
			
		}
		
		System.out.println(ans);
		
		int count =0;
		for(int i =0; i < arr.length;i++) {
			
			for(int k=i; k<arr.length;k++) {
				
				if(i==k||arr[i]==arr[k]) {
					continue;
				}
				count++;
				
			}
		}
		
		System.out.println(count);
	}
}
