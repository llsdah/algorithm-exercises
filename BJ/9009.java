import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int[] d = new int[46];
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt();
		d[0]=1;
		d[1]=1;
		for(int i=2; i<d.length;i++) {
			d[i]=d[i-1]+d[i-2];
		}

		long[] num =new long[n];
		for(int i=0; i<n;i++) {
			num[i]=sc.nextLong();
		}
		for(int i=0; i<n;i++) {
			nums(num[i]);
			System.out.println();
		}
		
		
	}
	private static void nums(long num) {

		StringBuilder sb = new StringBuilder();
		while(num>0) {
			
			for(int i=d.length-1;i>=0;i--) {
				if(d[i]<=num) {
					num= num-d[i];
					sb.append( d[i]+" ");
					break;
				}
			}
		}
		String[] str = sb.toString().split(" ");
		for(int i=str.length-1;i>=0;i--) {
			if(i==0) {
				System.out.print(str[i]);
				break;
			}
			System.out.print(str[i]+" ");
		}
		return;
	}

}
