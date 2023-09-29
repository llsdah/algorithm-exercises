package backJun;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt(); // 총 칸의수
		int[][] arr = new int[n][2];
		for(int i=0; i< n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[0]==o2[0]) return o2[1] -o1[1];
				return o2[0]-o1[0];
			}
		});
		
		System.out.println();
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		int[] d = new int[10001];
		int pos =0;
		int sum =0;
		for(int i =0;i<n;i++) {
			int pay =arr[i][0];
			int date = arr[i][1];
			for(int k =date;k>=1;k-- ) {
				if(pay>d[k]) {
					d[k]=pay;
					break;
				}
			}
			
		}
		System.out.println(Arrays.toString(d));
		sum =Arrays.stream(d).sum();
		
		System.out.println(sum);
		
		
	}
}

/*

*/


/* 정리 나 그런거 다시 생각 큰거 부터 넣어 보자 . !!!
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt(); // 총 칸의수
		int[][] arr = new int[n][2];
		for(int i=0; i< n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[1]==o2[1]) return o2[0] -o1[0];
				return o1[1]-o2[1];
			}
		});
		
		int pos =0;
		int sum =0;
		for(int i =0;i<n;i++) {
			if(arr[i][1]>pos) {
				sum+=arr[i][0];
				pos =arr[i][1];
			}
			
		}
		
		System.out.println(sum);
		
		
	}
}

*/
