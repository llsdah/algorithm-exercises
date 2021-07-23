package backJun;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();
		int[] cnt = new int[n];
		for(int i=0;i<n;i++) {
			int num =sc.nextInt();
			int[] arr = new int[num];
			for(int k=0; k<num;k++) {
				arr[k] = sc.nextInt();
			}
			
			cnt[i] = check(num,arr);
			
			
		}
		for(int i=0; i<n;i++) {
			System.out.println(cnt[i]);
		}
		
		
	}

	private static int check(int n, int[] arr) {

		PriorityQueue<Integer> q = new PriorityQueue<>();
		//System.out.println("arrr["+Arrays.toString(arr));
		for(int i =0; i<n;i++) {
			q.offer(arr[i]);
		}
		
		int sum =0;
		while(q.size()>1) {
			if(q.size()==1) {
				break;
			}
			int num1 = q.poll();
			int num2 = q.poll();
			q.offer(num1+num2);
			sum+=num1+num2;
		}
		
		sum+= q.poll();
		return sum;
	}
}



/*



*/
