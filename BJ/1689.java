import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	// 통나무 자르기 숫자가 크니까 이분탐색으로 빠르게 
	static long max =0;
	static long fp =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();// 통나무 길이

		long[][] arr = new long[n][2];
		
		for(int i =0;i<n;i++) {
			arr[i][0] = sc.nextLong(); // 시작점
			arr[i][1] = sc.nextLong(); // 끝 정
		}
		
		Arrays.sort(arr, new Comparator<long[]>() {
			
			public int  compare(long[] o1, long[] o2) {
				if(o1[1]==o2[1]) return o1[0] -o2[0]>0 ? 1 : -1;
				return o1[1] -o2[1] > 0 ? 1:-1;
			}
		}); // 끝자리 순서대로 정렬 
		
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		int max = 1; // 최대 갯 수 더하기 
		
		long end = arr[0][1];

		int pos =1;
		
		while(pos<n-1){			
			int cnt = 1; // 1개는 시작이니까 
			for(int i =pos; i < n;i++) {
				pos = i;
				if(end >arr[i][0]) {
					cnt++;
					max = Math.max(max, cnt);
				}else break;
				
			}
			end = arr[pos][1];
		}
		System.out.println(max);
		
	}
	
}
