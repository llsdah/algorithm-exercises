import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// 0.25 , 0.10,0.05 0.01
		int n = sc.nextInt(); //  거스름돈 줄 수
		int[][] arr =new int[n][2]; // 시작 끝
		for(int i =0; i< n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr,new Comparator<int[]>() {
			// 시작 시간대로 오름 차운 정렬 합니다.  같다ㅕㄴ 끝나느 시간
			@Override 
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				
				return o1[0] -o2[0];
			}
			
		});
		
		PriorityQueue<Integer> q = new PriorityQueue<>();// 가장빨리 끝나는거 정의
		q.add(arr[0][1]); // 끝 값 입력
		
		for(int i=1;i<n;i++) { // 배열의 2번 값부터 순회하면서 
			if(q.peek() <= arr[i][0]) q.poll();
			// end<=st 강의실 추가 필요없음 해당 강의실 사용 
			q.add(arr[i][1]); // 이외는 강의실 시간 중복으로 필요 
		}
		int ans = q.size();
		System.out.println(ans);
	}
}


/*
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// 0.25 , 0.10,0.05 0.01
		int n = sc.nextInt(); //  거스름돈 줄 수
		int[][] arr =new int[n][2]; // 시작 끝
		for(int i =0; i< n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o2[0]-o1[0];
				return o1[1] -o2[1];
			}
			
		});
		
		int cnt =1;
		for(int i=0; i<n-1;i++) {
			int end = arr[i][1];
			for(int k=i+1;k<n;k++) {
				int st = arr[k][0];
				if( st>=end) {
					cnt++;
					i =k-1;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
*/
