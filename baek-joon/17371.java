import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	//2차원 좌표 계 위로 집을 옮길ㄴ다 . 
	static int max = (int)1e9;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		
		
		// 편의시설을 나열, 편의시설을 집으로 나열 
		// 가짱 가까운 것은 0 먼것은 해당 거리가 될꺼임 
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0; i< n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
		}
		
		double dis = Double.MAX_VALUE;
		int pos = 0;
		
		for(int i=0; i<n;i++) { //최대 값을 알아내기 위한 것들. 
			double max = -1;
			for(int k=0; k<n;k++) {
				if( i==k) continue;
			
				double temp = Math.sqrt(Math.pow(arr[i][0]-arr[k][0],2)+ 
						Math.pow(arr[i][1]-arr[k][1],2)); // 루트 작업을 안햄..
				if(  temp > max) max = temp;
			}
			
			if( dis > max) {
				pos =i;
				dis = max;
			}
		}
		
		System.out.println(arr[pos][0]+" "+arr[pos][1]);
		
		
	}

}
