import java.util.Arrays;

public class 효율적인화폐구성 {

	public static void main(String[] args) {

		int[] dp = new int[10000];
		Arrays.fill(dp,10001 );
		int n = 3;// 화폐의수
		int target = 12;// 만들고자하는 수
		int[] arr = { 3, 5 ,7};// 화폐 단위

		Arrays.sort(arr);
		dp[0]=0;
	
		for(int i =0; i < arr.length;i++) {
			
			for(int k =arr[i]; k<=target;k++) {
				
				if( dp[k-arr[i]]<10001) {
					dp[k] =Math.min(dp[k-arr[i]]+1, dp[k]);
				}
				
			}
			
			
		}
		System.out.println(dp[target]);
		
	}
}
