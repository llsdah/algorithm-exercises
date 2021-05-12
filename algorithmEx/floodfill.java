package AlgorismStudy1;

import java.util.Arrays;


// 재귀
public class Num_2 {

	
	public static void main(String[] args) {

		
		int n =5 ;
	
		//int num = fac(n); // 팩토리얼
		
		//Flood fill 알고리즘 // 색칠 알고리즘 
		int[][] arr = {
				{0,0,0,0,0	},
				{0,0,0,1,1},
				{0,0,0,1,0},
				{1,1,1,1,0},
				{0,0,0,0,0}
				};
		int row=1, col =1;
		
		fill(arr,row,col,n);
		
		for(int i=0; i < n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	
	} 
	
	private static void fill(int[][] arr, int row, int col,int n) {

		if(row<0||row>n-1||col<0||col>n-1) {
			return;
		}
		if(arr[row][col]!=0)return; // 여기가 base 종료 조건
		arr[row][col] =1;
		
		
		fill(arr,row-1,col,n);
		fill(arr,row+1,col,n);
		fill(arr,row,col-1,n);
		fill(arr,row,col+1,n);
		
	
	
	}
	
	
	public static int fac(int n ) {
		if( n==0) { // base case
			return 1;
		}
		return n*fac(n-1); // recurisive;
	}
	
}
