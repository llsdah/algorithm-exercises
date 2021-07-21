
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n =sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int cnt =sc.nextInt();// 몇번 히ㅓㄴ
		
		for(int i=0;i<n;i++) {
			int max =arr[i];// 해당수의 최대값
			int pos =i; // 위치 
			for(int k=i+1;k<n;k++) {
				if( cnt-(k-i) >=0) { // 전체 회선 해서 0보다 큰경우 전체 찾기 
					if(max<arr[k]) {  
						max =arr[k];// 맥스값변경위해
						pos =k;// 위치도 변경 안될떄까지
					}
				}
			}
			for(int k=pos;k>i;k--) { // 해당 위치의 최대 값에서 안될떄까지 찾은거
				int temp = arr[k];// 위치 면접
				arr[k] = arr[k-1];
				arr[k-1] =temp;
			}
			cnt-=(pos-i); // 전체 몇번 바꿔씨디?
			if(cnt<=0) break;
			
		}
		
		for(int i=0; i<n;i++) {
			if(i==n-1) {
				System.out.print(arr[i]);
				break;
			}
			System.out.print(arr[i]+" ");
		}
		
	}
}
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n =sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int cnt =sc.nextInt();// 몇번 히ㅓㄴ
		
		loof : while(cnt>0) {
			
			for(int i=0;i<n-1;i++) {
				if(arr[i]<arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]=temp;
					cnt--;
				}
				if(cnt==0) break loof;
			}
		}
		for(int i=0; i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
