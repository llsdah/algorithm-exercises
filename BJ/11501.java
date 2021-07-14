




// 시간 초과 부분 역시나. 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int y = sc.nextInt();
		for(int i =0; i<y;i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int k=0;k<n;k++) {
				arr[k]=sc.nextInt();
			}
			int num = price(n,arr);
			System.out.println(num);
		}
		
	}

	private static int price(int n, int[] arr) {
		int sum =0;
		int end = arr.length;
		for(int i=0; i<arr.length;i++) {
			int start = i;
			int st = arr[i];
			int[] temp = Arrays.copyOfRange(arr, start, end);
			int max = Arrays.stream(temp).max().getAsInt();
			sum+= ( max >st ? max-st :0);
			
		}
		
		
		return sum;
	}
	
}
