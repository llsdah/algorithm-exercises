

/* 수정 전.. 무싄 식을 세워야 할까. 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int num =0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		
		int[] arr = new int[6];
		for(int i =0; i<6;i++) {
			arr[i] =sc.nextInt();
		}
		Arrays.sort(arr);
		int ans = 0;
		if( n==1) {
			for(int i=0; i <5;i++) {
				ans+=arr[i];
			}
			System.out.println(ans);
		}
		long total = n*n*n;
		for(long k=0; k<4;k++) {
			for(int i =0; i<3;i++) {
				ans+=arr[i];
			}
		}
		
		for(long i=0; i< 4*(2*(n-1)-1);i++) {
				ans+=(arr[0]+arr[1]);	
		}

		long temp = 0;
		for(long i=0; i<(n-2)*(n-2)+(n-2);i++) {
			temp+=arr[0];
		}
		temp = 4*temp;
		
		for(long i =0; i <(n-2)*(n-2);i++) {
			ans+=arr[0];
		}

		ans +=temp;
		
		System.out.println(ans);
	}
}




*/
