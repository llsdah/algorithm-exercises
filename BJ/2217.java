import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		
		int temp = scan.nextInt();
		int[] nums = new int[temp];
		for(int i =0; i< temp;i++) {
			nums[i] =scan.nextInt();
		}		
		
		Arrays.sort(nums);
		int max =0;
		for(int i =0;i<nums.length;i++ ) {
			max =Math.max(max, nums[i]*( nums.length-i) );
			
		}
		
		System.out.println(max);
	}
	
}
