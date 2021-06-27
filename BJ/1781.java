package backJun;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt();

		int[][] arr =new int[n][3];
		for(int i=0; i<n;i++) {
			arr[i][0] =i;
			arr[i][1] =sc.nextInt();
			arr[i][2] =sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o2[1]==o1[1]) {
					return o2[2]-o1[2];
				}
				return o2[1]-o1[1];
			}
			
		});
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		int num =n-1;
		int sum =0;
		while(num>0) {
			int temp =0;
			int pos =-1;
			for(int i=0; i<n ; i++) {
				if(arr[i][1]>=num) {
					if(temp<arr[i][2]) {
						temp= Math.max(arr[i][2],temp);
						pos =i;
						
					}
				}else	break;
				
			}
			sum+=temp;
			if(pos!=-1) arr[pos][2]=0;
			num--;
		}
		System.out.println(sum);
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
/*
4
100
200
12345
1003

*/
