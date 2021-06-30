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
