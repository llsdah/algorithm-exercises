
import java.util.Arrays;

public class 개미전사 {

	static int[] dp =new  int[100];
	public static void main(String[] args) {

		int[] arr = {1,3,1,5,1,3,2,4,10};
		int n =arr.length;
		
		
		dp[0] =arr[0];
		dp[1] =Math.max(arr[0],arr[1]);
		
		for(int i=2;i<n;i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
