import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt(); //과목 수 
		int mi = sc.nextInt(); // 마일리지 
		int[] arr = new int[n];
		
		//마일리지는 1~ 36 을 배분합니다. 
		for(int i=0; i<n;i++) {
			int st = sc.nextInt(); // 수강 신청 인원 
			int max = sc.nextInt();
			
			int[] stArr = new int[st];
			for(int k =0; k<st; k++) {
				stArr[k] = sc.nextInt();
			}
			if( st<max) 	arr[i] =1;
			else {
				Arrays.sort(stArr);
				int num = st-max;
				arr[i] = stArr[num];
			}
			
		}

		int cnt = 0; 
		Arrays.sort(arr);
		for(int i=0; i<n;i++) {
			mi-=arr[i];
			if(mi<0) break;
			cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
