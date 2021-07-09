import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt(); // 총 후보수 
		int my = sc.nextInt();
		int[] arr = new int[n-1];
		
		for(int i =0; i<n-1;i++) {
			arr[i] =sc.nextInt();
		}
		int cnt =0;
		while(true) {
			Arrays.sort(arr);
			int max = arr[n-2];
			if( my>max) {
				break;
			}
			arr[n-2]--;
			my++;
			cnt++;
		}
		
		System.out.println(cnt);
		
	}
}

/* 어디서 틀리 걸까 . 

package backJun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int cnt =0;
		int n = sc.nextInt(); // 총 후보수 
		if( n==1) {
			int my = sc.nextInt();
		}else if(n==2){
			int my = sc.nextInt();
			int arr = sc.nextInt();
			if(my<arr) {
				cnt=arr-my+1;
			}else if(my==arr) {
				cnt=1;
			}

		}else {
			
			int my = sc.nextInt();
			int[] arr = new int[n-1];
			
			for(int i =0; i<n-1;i++) {
				arr[i] =sc.nextInt();
			}
			boolean flag = true;
			//if(arr.length==1) 
			while(true) {
				Arrays.sort(arr);
				int max = arr[arr.length-1];
				if( my>max) {
					break;
				}
				arr[n-2]--;
				my++;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}

/*

*/

