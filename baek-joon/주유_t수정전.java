package backJun;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class B_test {

	public static void main(String[] args) {
/*
		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();
		int[] dis = new int[n-1];
		int[] cost = new int[n];

		for (int i = 0; i < n-1; i++) {
			dis[i] = scan.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			cost[i] = scan.nextInt();
		}
		*/
		// 제일 왼쪽에서 오른쪾으로 이동합니다. 하핳
		// 제일큰수가 얼마 인지 확인 하지 LONG 타입!!		
		int n=4;
		int[] dis = {3,3,4};
		int[] cost = {1,1,1,1};
		
		
		int sum =0;
		for(int i =0;i<cost.length-1;i++) {
			int nums =cost[i];
			int distance =0;
			for(int k=i; k<cost.length-1;k++) {
				if(nums<=cost[k]) {
					distance+=dis[k];
				}else {
					sum+=(distance*nums);
					distance=0;
					i=k-1;
					break;
				}
			}
			
			if(distance!=0) {
				sum+=(distance*nums);
				break;
			}
		}

		System.out.println(sum);
		
	}

}













