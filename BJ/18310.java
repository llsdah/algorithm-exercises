
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length;i++) {
			arr[i] =sc.nextInt();
		}
		Arrays.sort(arr);
		
		//int cnt = (arr[0]+arr[arr.length-1])/2; // 그냥 쉽게 막 찍었는데 .. 맞네
		int cnt = arr[arr.length/2-1]; // 왜 ㅇ게 맞는건지는 모르곘다. 
		System.out.println(cnt);
	}
}
