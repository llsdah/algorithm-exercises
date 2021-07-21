import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	// 쉽게 생각 가장 사람이 많은 졲!!에 우체국을 세우면
	// 단순에 인원의 총합에서 사람이 가장많이 쪽! 에서 +1에서 중심 /2 한다.
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
