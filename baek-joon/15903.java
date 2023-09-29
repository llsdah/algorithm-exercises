import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt(); //  숫자 수 
		int k = sc.nextInt(); // 더하는 횟수 

		long[] num = new long[n];
		
		for(int i =0; i < num.length;i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		
		
		for(int i=0; i<k;i++) {
			num = sum(num);
			Arrays.sort(num);
		}
		long ans = Arrays.stream(num).sum();
		System.out.println(ans);
	}
	private static long[] sum(long[] arr) {
		
		long sum = arr[0]+arr[1];
		arr[0] = sum;
		arr[1] = sum;
		return arr;
		
	}
}
