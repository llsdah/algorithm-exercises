import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		int num = scan.nextInt();
	
		int[] arr = new int[num];
		for(int i =0; i<num;i++) {
			arr[i]=scan.nextInt();
		}
	
		int count =0;
		
		for(int i=arr.length-1;i>=1;i--) {
			
			if(arr[i]<=arr[i-1]) {
				count +=arr[i-1]-(arr[i]-1);
				arr[i-1] = arr[i]-1;
			}

		}
		System.out.println(count);
	}
	
}
