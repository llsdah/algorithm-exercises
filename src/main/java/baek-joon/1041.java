
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int num =0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		long n = sc.nextInt();
		
		int[] arr = new int[6];
		for(int i =0; i<6;i++) {
			arr[i] =sc.nextInt();
		}
		// 마주 보는 면으로 변싄 각 마주보는 면중 최소한. 
		long sq1 = Math.min(arr[0], arr[5]);
		long sq2 = Math.min(arr[1], arr[4]);
		long sq3 = Math.min(arr[2], arr[3]);
		
		
		long one = Math.min(sq1, Math.min(sq2, sq3));
		long two = Math.min(sq1+sq2, Math.min(sq2+sq3, sq3+sq1));
		long three = sq1+sq2+sq3;
		
		long ans = 0;
		long[] num = new long[4];// 3가지 경우의수 1면 2면 3면
		
		
		num[1] = 5*(n-2)*(n-2)+4*(n-2);//1 면 짜리 
		num[2] = 8*(n-2)+4;
		num[3] = 4;
		
		if( n==1) {
			Arrays.sort(arr);
			for(int i =0; i < 5;i++) {
				ans+=arr[i];
			}
			System.out.println(ans);
		}else {
			
			ans +=(num[1]*one);
			ans+=(num[2]*two);
			ans+=(num[3]*three);
			System.out.println(ans);
		}
	
	}
}

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
