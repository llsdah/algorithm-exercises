import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	
	// 큐를 두개 나눈다 더하기랑 뺴기랑 따로 따로 넣는다. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 문제수 
		int max = sc.nextInt();// 역량
		int total = sc.nextInt();// 풀이 가능한 갯수
		
		int[][] arr = new int[n][2];
		for(int i =0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1 , int[] o2) {
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		
		int sum = 0;
		for(int i =0; i< n;i++) {
			if(total ==0) break;
			if(max>=arr[i][1]) {
				sum+=140;
				total--;
			}else if( max>=arr[i][0]) {
				sum+=100;
				total--;
			}
			
		}
		
		System.out.println(sum);
	}
}
