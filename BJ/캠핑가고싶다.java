import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));
		
		
		int[][] ans = new int[10000][3];
		int n =0;
		while(true) {
			int a  = scan.nextInt();
			int b  = scan.nextInt();
			int c  = scan.nextInt();
			ans[n][0] = a;
			ans[n][1] = b;
			ans[n][2] = c;
			
			n++;
			if( a==0&&b==0&&c==0) {
				break;
			}
			
		}
		int[] answer = new int[n];
		int cnt =0;
		for(int i=0; i<n;i++) {
			
			while( ans[i][2]>ans[i][1]) {
				cnt+=ans[i][0];
				ans[i][2] = ans[i][2] -ans[i][1];
			}
			cnt = cnt + Math.min(ans[i][2], ans[i][0]);
			answer[i] = cnt;
			cnt=0;
		}
			
		for(int i=0; i < n-1;i++) {
			System.out.println("Case "+(i+1)+" : "+answer[i]);
		}
		
		// 8 중 5일 동안만 사용이 가능합니다. 20일휴가 있습니다.
		// 1~8 5, 9~16 6 16~ 20 4 14 이?
		
	}


}



/*
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B_test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int[][] ans = new int[20][3];
		int n = 1;
		while (n<10) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();

			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			int mok = c/b;
			int els = c%b;
			int sum = (mok*a)+els;
			System.out.println("Case "+n+" : "+sum);
			n++;

		}
	}

}

*/
