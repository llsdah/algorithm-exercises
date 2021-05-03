package 이코테.DP;

import java.util.Arrays;

public class 일로만들기 {

	static int[] dp = new int[100];

	public static void main(String[] args) {
		Arrays.fill(dp, 99999999);
		//최소 값할때는 채워야 겠다 
		int n = 26;
		dp[1] =0;
		dp[0] =0;
		for(int i =2; i<=26;i++) {
			//dp[i] = dp(i);
			dp[i] =dp[i-1]+1;
			
			if(i%5==0) {
				dp[i] = Math.min(dp[i],dp[i/5]+1);
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i],dp[i/3]+1);
			}
			if(i%2==0) {
				dp[i] = Math.min(dp[i],dp[i/2]+1);
			}
			
		}
		
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[26]);
	}

	private static int dp(int n) {
		
		if(n==1) {
			return 1;
		}else if(n<0) {
			return 0;
		}
		
		if(n%5==0) {
			if(dp[n/5]!=0) {
				return dp[n/5]+1;
			}
			
			return dp(n/5);
		}
		if(n%3==0) {
			if(dp[n/3]!=0) {
				return dp[n/3]+1;
			}
			return dp(n/3);
		}
		
		if(n%2==0) {
			if(dp[n/2]!=0) {
				return dp[n/2]+1;
			}
			return dp(n/2);
		}
		if(dp[n-1]!=0) {
			return dp[n-1]+1;
		}
		
		return dp(n-1);
		
	}

}
