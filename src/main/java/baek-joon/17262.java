import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	//모든 국회의원박탈.
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();//총 인원수 
		int[][] arr = new int[n][2];
		for(int i=0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
		}
		
		
		int st =arr[0][0];
		int end = arr[0][1];
		
		int cnt =0;
		
		for(int i=0; i<n;i++) {
			for(int k=0;k<1;k++) {
				if(arr[i][k+1]<st) {
					cnt+= st-arr[i][k+1];
					st = arr[i][k];
				}else {
					if(arr[i][k]>end) {
						cnt +=arr[i][k]-end;
						end = arr[i][k+1];
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
