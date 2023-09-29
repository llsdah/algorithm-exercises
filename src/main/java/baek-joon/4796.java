import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int[][] ans = new int[20][3];
		int n = 1;
		while (true) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();

			if (a == 0 && b == 0 && c==0) {
				break;
			}
			int mok = c/b;
			int els = c%b;
			int sum = (mok*a)+Math.min(els,a);
			System.out.println("Case "+n+": "+sum);
            n++;
		}
	}

}
