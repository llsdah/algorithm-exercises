import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		// 그룹 만들기.가장 최소가 되도록. 
		int n = sc.nextInt();
		int group = sc.nextInt();
		int[] arr = new int[n];
		int[] cnt = new int[n-1];
		for(int i=0; i<n;i++) {
			arr[i] =sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0; i<n-1;i++) {
			cnt[i] =arr[i+1]-arr[i];
		}
		Arrays.sort(cnt);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(cnt));
		// 가장 작은 차이가 발생하는 것을 그룹을 하고. 나머지는 혼자 그룹 이면됩니다.
		// 즉, 10 명이 있고, 3명이 그룹이면, 가장 작은 차이보이는 9개 중에
		// 7개 그룹총 8명이 그룹으로 묶이고 나머지가 혼자 있으면대뵌다.
		int sum =0;
		for(int i=0;i<n-group;i++) {
			sum+=cnt[i];
		}
		System.out.println(sum);
		
	}
}
