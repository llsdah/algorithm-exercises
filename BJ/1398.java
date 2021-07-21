import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		long[] arr = new long[16];
		
		int n =sc.nextInt();
		long[] num = new long[n];
		for(int i=0; i<n;i++) {
			num[i] =sc.nextLong();
		}
		
		for(int i=0; i<8;i++) {
			int temp = i*2;
			arr[temp] = (long) Math.pow(10, i);
			arr[temp+1] = 25*(long) Math.pow(100, i);
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for(int i=0; i<n;i++) {
			long number =num[i];
			
			int pos = 16;
			int cnt =0;
			while(pos>0) {
				pos--;
				if(arr[pos]>number) continue;
				cnt+=(number/arr[pos]);
				number%=arr[pos];
				
			}
			num[i] = cnt;
		}
		
		for(int i=0; i<n;i++) {
			System.out.println(num[i]);
		}
		
		
	}
}
