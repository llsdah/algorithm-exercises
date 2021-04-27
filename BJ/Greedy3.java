import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B_test {

	public static void main(String[] args) {
		
	/*
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		
		
		int temp = scan.nextInt();
		int[] nums = new int[temp];
		for(int i =0; i< temp;i++) {
			nums[i] =scan.nextInt();
		}
		*/
		
		int[] arr = {10,3,12,5,15,31};
		//중량의 최소값으로 정렬 후 최대값을 곱해서 최대 중량 구함
		
		Arrays.sort(arr);
		int max =0;
		for(int i =0;i<arr.length;i++ ) {
			max =Math.max(max, arr[i]*( arr.length-i) );
			
		}
		
		System.out.println(max);
	}
	
}
