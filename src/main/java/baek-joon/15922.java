import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 원판 갯수
		int[][] arr = new int[n][2];
		for(int i=0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			
			public int compare(int[] o1,int[] o2) {
				if(o1[0] ==o2[0]) return o1[1]-o2[1];
				return o1[0] -o2[0];
			}
		});
		System.out.println();
		int cnt = 0;
		int min = arr[0][0];
		int max = arr[0][1];
		for(int i=1; i<n;i++) {
			min = Math.min(min,arr[i][0]); // 세상에서 가장 작은 최솟값
			if(max<arr[i][0]) { // 기존에 가진 최대값이 , 현재 순서의 최소값보다 작다면
				System.out.println(min+" : "+max+"  형재"+Arrays.toString(arr[i]));
				cnt+=(max-min);// 값을 넣고
				min = arr[i][0];
				max = arr[i][1];
			}else {
				max = Math.max(max, arr[i][1]);
			}
			
		}
		System.out.println(min+" : "+max);
		cnt += (max-min);
		System.out.println(cnt);
	}
}
