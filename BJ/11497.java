import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		

		int total = sc.nextInt();
		int[] arr_total = new int[total];
		
		for(int i =0; i<total;i++) {
			int num = sc.nextInt();
			int[] arr_num = new int[num];
			for(int k=0; k<num;k++) {
				arr_num[k]=sc.nextInt();
			}
			arr_total[i] = count(arr_num);
			
		}
		
		for(int i =0; i <arr_total.length;i++) {
			System.out.println(arr_total[i]);
		}
		
	}

	private static int count(int[] arr_num) {
		
		Arrays.sort(arr_num);
		int num = arr_num.length;
		int[] arr = new int[num];
		boolean flag = true;
		int st = 0;
		int last = num-1;
		
		for(int i =0; i< num ;i++) {
			int temp = arr_num[i];
			if(flag) {
				arr[st]=temp;
				st++;
			}else {
				arr[last]=temp;
				last--;
			}
			flag = !flag;
			
		}
		int max =0;
		for(int i =1;i<num-1;i++) {
			int temp1= Math.abs(arr[i]-arr[i-1]);
			int temp2= Math.abs(arr[i]-arr[i+1]);
			max = Math.max(max, Math.max(temp1, temp2));
		}
		
		return max;
	}
}
