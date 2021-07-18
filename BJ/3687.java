import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static HashMap<Integer, String> min = new HashMap<>();
	static HashMap<Integer, String> max = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();// 원판 갯수 
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] =sc.nextInt();
		}
		
		
		String[] max = new String[101];// 많아야 최대 100개 
		max[2]="1";
		for(int i=3;i<=100;i++) {
			StringBuilder sb = new StringBuilder();
			int temp = i/2;
			if(i%2==1) { // 홀수 일 경후 
				temp = i/2-1;
				sb.append(7);
			}
			
			for(int k=0;k<temp;k++) { // 갯수만큼 1
				sb.append(1);
			}
			max[i] = sb.toString();
			
		}
		
		// 최 소값 
		// 인덱스 값이 갯수 -2 입니다.!!! 
		long[] min = new long[101];
		// 중요 !! 최소니까 최대 값을 넣어주고 시작 
		Arrays.fill(min,Long.MAX_VALUE);
		String[] nums = {"1","7","4","2","0","8"};
		min[2] =1;
		min[3] =7;
		min[4] =4;
		min[5] =2;
		min[6] =6;
		min[7] =8;
		min[8] =10; // 시작이 0일 수는 없으니까 !!!. 8이면 10 이면 젤 작아 가장 주의 
		
		for(int i=9;i<101;i++) {
			for(int k=2;k<=7;k++) { // 빼거다
				
				// 해당 갯수에서 최소 + 추가된 것중 최소 ! 
				String num = min[i-k]+nums[k-2];
				min[i] = Math.min(Long.parseLong(num),min[i]);// 그냥 넣은것중에 최소
			}
		}
		
		
		
		for(int i =0; i<n;i++) {
			System.out.printf("%s %s\n",min[arr[i]],max[arr[i]]);
		}
		
	}
	
}




/*
// 반복할 필요없이 값을 dp로 저장후 출력하자 
public class Main {

	static HashMap<Integer, String> min = new HashMap<>();
	static HashMap<Integer, String> max = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();// 원판 갯수 

		min.put(2, "1");
		min.put(5, "2");
		min.put(4, "4");
		min.put(6, "0"); // 단 시작이 6이면 6 ;
		min.put(3, "7");
		min.put(7, "8");

		
		// 갯수를 넣으면 숫자가 나오게 
		long[][] arr = new long[n][2];
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			arr[i][0] = min(num);
			arr[i][1] =max(num);
		}
		
		// 최
		
	}
	private static long max(int num) {
		StringBuilder sb = new StringBuilder();
		if(num%2==1) {
			num-=3;
			sb.append(7);
			
		}
		
		while(num>0) {
			num-=2;
			sb.append(1);
		}
		return Long.valueOf(sb.toString());
	}
	
	private static long min(int num) {
		if(num==6) return 6;
		
		
		return 0;
	}
}

	
*/
