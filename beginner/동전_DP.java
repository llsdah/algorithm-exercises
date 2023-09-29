package AlgorismStudyUtube;

import java.util.Arrays;

public class 동전1_DP {

	static int coin[] = new int[101];
	static int dp[] = new int[10001];

	// 구할 때 앞의 수를 구하고 한다.
	public static void main(String[] args) {

		int num = 100;// 경우의 수를 찾고 싶은 금액

		//가지고 있는 코인의 갯수 3개 // 해당 코인의 가치 1,2,5
		coin[1] = 1; 
		coin[2] = 2;
		coin[3] = 5;

		
		dp[0]=1; // 자신의 1 이다.
		
		for(int i =1; i<=3;i++) {
			
			
			for(int k=coin[i];k<=num;k++) {
				dp[k]+=dp[k-coin[i]];
			}
			
		}
		
		System.out.println(dp[num]);
		
	}

}
