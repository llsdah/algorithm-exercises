
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int num =0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[n];
		for(int i =0; i<n;i++) {
			arr[i] =sc.nextInt();
		}
		
		Arrays.sort(arr);
		int[] leng = new int[n-1];
		for(int i =0; i<arr.length-1;i++) {
			leng[i] = arr[i+1]-arr[i];
		}
		Arrays.sort(leng);
		System.out.println(Arrays.toString(leng));
		int ans =0;
		for(int i=0;i<n-K;i++) {
			ans+=leng[i];
		}
		
		System.out.println(ans);
		
	}
}
