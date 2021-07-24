import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	//모든 국회의원박탈.
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();//총 인원수 
		
		int[] arr =new int[n];
		for(int i=0; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0; 
		Arrays.sort(arr);
		
		// 1이면 그냥 더해서 끝
		if(n==1) {
			sum+=(arr[0]-1);
		} else if ( arr[0]!=1) {
			sum+=(arr[0]-1);
			arr[0]=1;
		}
		
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i-1]) {
				sum += arr[i] - (arr[i-1] + 1);
				arr[i] = arr[i-1]+1;
				
			}				
		}

		
		System.out.println(sum);
		
	}
}
