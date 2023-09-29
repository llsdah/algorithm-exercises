package backJun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int cnt = 0;
		boolean flag = true;
		int n = sc.nextInt(); // 총 후보수

		int my = sc.nextInt();
		if( n!=1) { // 왕.. 당연히 경쟁이라서 2명이상입력이 줄알았는데.. 혼자도 있네.
			int[] arr = new int[n - 1];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			// if(arr.length==1)
			while (true) {
				Arrays.sort(arr);
				int max = arr[arr.length - 1];
				if (my > max) {
					break;
				}
				arr[n - 2]--;
				my++;
				cnt++;
			}
			
		}

		System.out.println(cnt);

	}
}

/*

*/
