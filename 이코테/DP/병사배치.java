package 이코테.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 병사배치하기 {

	static int n;
	static ArrayList<Integer> v = new ArrayList<>();
	static int[] dp = new int[2000];
	public static void main(String[] args) {

		n=7;
		v.add(15);
		v.add(11);
		v.add(4);
		v.add(8);
		v.add(5);
		v.add(2);
		v.add(4);
		
		Collections.reverse(v);
		for(int i =0; i<n;i++) {
			dp[i]=1;
		}
		for(int i=1; i<n;i++) {
			
			for(int j=0; j<i;j++) {
				if(v.get(j)<v.get(i)) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			
		}
		
		int maxValue =0;
		for(int i =0; i<n;i++) {
			maxValue =Math.max(dp[i], maxValue);
		}
		System.out.println(n-maxValue);
		
	}
}
 
