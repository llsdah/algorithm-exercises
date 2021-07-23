
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();
		long[] cnt = new long[n];
		
		for(int i=0;i<n;i++) {
			int num =sc.nextInt();
			long[] arr = new long[num];
			for(int k=0; k<num;k++) {
				arr[k] = sc.nextInt();
			}
			
			cnt[i] = check(num,arr);
			
			
		}
		for(int i=0; i<n;i++) {
			System.out.println(cnt[i]);
		}
		
		
	}

	private static long check(int n, long[] arr) {

		PriorityQueue<Long> q = new PriorityQueue<>();
		//System.out.println("arrr["+Arrays.toString(arr));
		for(int i =0; i<n;i++) {
			q.offer(arr[i]);
		}
		
		long sum =0;
		while(q.size()>1) {
			if(q.size()==1) {
				break;
			}
			long num1 = q.poll();
			long num2 = q.poll();
			sum+=num1+num2;
			if(q.isEmpty()) {
				break;
			}
			q.offer(num1+num2);
		}
		
		return sum;
	}
}

