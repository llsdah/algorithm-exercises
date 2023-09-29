import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i =0; i< n;i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int max = 0;
		for(int i =0; i<arr.length;i++) {
			if( max+1>=arr[i]) {
				max+=arr[i];
			}else {
				break;
			}
		}
		System.out.println(max+1);
	}
}
