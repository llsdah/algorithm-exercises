import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		// 가장싼 1개 나머지의 값 지풀 하면됩니다. 
		// 따로 사면 정가 구입. 
		// 순서대로 정렬하면대지 
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++) {
			arr[i] =sc.nextInt();
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		int sum =0;
		int total = 0;
		while(n>0)	{
			n--;
			sum+=arr[n];
			cnt++;
			if(cnt == 3) {
				sum+= -arr[n];
				total+=sum;
				cnt=0;
				sum=0;
			}
			
		}
		total+=sum;
		System.out.println(total);
		
	}
}
