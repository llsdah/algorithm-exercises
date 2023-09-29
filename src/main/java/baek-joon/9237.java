import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();
		Integer[] num = new Integer[n];
		for(int i=0;i<n;i++) {
			num[i] =sc.nextInt();
		}
		
		Arrays.sort(num, Collections.reverseOrder());

		System.out.println(Arrays.toString(num));
		for(int i=0; i<n;i++) {
			num[i] = i+ num[i]+1;
		}
		System.out.println(Arrays.toString(num));
		int max = Arrays.stream(num).mapToInt(Integer::intValue).max().getAsInt();
		
		System.out.println(max+1);
		
	}

}
