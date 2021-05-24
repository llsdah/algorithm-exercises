import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B_test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		
			int a = scan.nextInt();
			int[] num = new int[a];
			for(int i =0; i< a;i++) {
				num[i] = scan.nextInt();				
			}
			int pl = (int)Arrays.stream(num).filter(i-> i>0).count();
			int mi = (int)Arrays.stream(num).filter(i-> i<=0).count();
			int total = 0;
			if(pl >0) {
				int[] arr  = Arrays.stream(num).filter(i-> i>0).toArray();
				total += count(arr);
			} 
			if( mi>0) {
				int[] arr  = Arrays.stream(num).filter(i-> i<=0).toArray();
				total += count(arr);
			}
			
			System.out.println(total);
	}
	

	private static int count(int[] arr) {
		Arrays.sort(arr);
		int num =0;
		for(int i=arr.length-1 ;i>=1;i=i-2) {
			num+=(arr[i]*arr[i-1]);
		}
		if(arr.length%2==1) {
			num +=arr[0];
		}
		
		return num;
	}

}
