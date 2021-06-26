
//거꾸로 돌아가는 것도 생가하자. 

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt();
		int[][] arr = new int[n][2];
		
		int day=0; //가장 긴날 체크용
		for(int i=0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
			day = Math.max(day, arr[i][0]);
		}
		// 날짜 작은 순으로 정렬 후 뒤에는 큰 것대로 정력
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o2[0]==o1[0]) {
					return o2[1]-o1[1];
				}
				return o2[0]-o1[0];
			}
		});
		System.out.println();
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
		int sum =0;
		System.out.println("day  "+day);
		for(int i= day;i > 0;i--) {
			int pos =0;// 해당 값 더했으니 변경해야됨.
			int max =0;
			for(int k=0; k<n;k++) {
				if( i<= arr[k][0]&&max<arr[k][1]) {
					max = arr[k][1];
					pos =k;
				}
			}
			sum +=max;
			arr[pos][1]=0;
			System.out.println(max+ " max : pos "+ pos);
			
		}
		System.out.println(sum);
		
	}

}

/*

package backJun;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
		}
		// 날짜 작은 순으로 정렬 후 뒤에는 큰 것대로 정력
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[0]==o2[0]) {
					return o2[1]-o1[1];
				}
				return o1[0]-o2[0];
			}
		});
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
		int sum =0;
		for(int i=0; i<n;i++) {
			if(arr[i][0]<=0) continue;
			sum+=arr[i][1];
			ch(arr,i);
			System.out.println();
		}
		System.out.println(sum);
		
	}

	private static void ch(int[][] arr, int pos) {
		int num = arr[pos][0]; // 날짜
		for(int i= pos;i<arr.length;i++) {
			if(arr[i][0]<=0) continue;
			arr[i][0] -= num;
		}
		for(int i=0; i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}

}

/*


*/

*/
