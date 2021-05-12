package AlgorismStudy1;

import java.util.Arrays;

// 십자가 
public class num_2 {

	public static void main(String[] args) {
	
		int[][] arr = {
				{0,0,0,0,0},
				{0,0,0,2,0},
				{0,0,0,0,0},
				{2,2,2,0,0},
				{0,0,0,0,0}
		};
	// 벽 =2 
		
		cross(arr,1,1);
		for(int i =0; i<arr.length;i++) {
			
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}

	private static void cross(int[][] arr, int row, int col) {

		if(arr[row][col]!=0)return;
		else arr[row][col]=1;
		
		for(int i =row-1;i>=0;i--) {
			if(arr[i][col]!=0)break;
			arr[i][col]=1;
		}
		
		for(int i =row+1;i<arr.length;i++) {
			if(arr[i][col]!=0)break;
			arr[i][col]=1;
		}
		
		
		
		for(int i =col-1;i>=0;i--) {
			if(arr[row][i]!=0)break;
			arr[row][i]=1;
		}
		
		for(int i =col+1;i<arr[0].length;i++) {
			if(arr[row][i]!=0)break;
			arr[row][i]=1;
		}
		
		
		
	}	
}
