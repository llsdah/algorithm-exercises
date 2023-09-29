import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();
		int space =sc.nextInt();
		int[] num = new int[n];
		String word = sc.next();
		for(int i=0; i<n;i++) {
			if(word.charAt(i)=='H') num[i]=1;
		}
		
		int cnt =0;
		for(int i =0; i<n;i++) {
			if(word.charAt(i)=='P') {
				// 우선 작은 위치 부터 돌자
				int max = Math.max(0, i-space);
				boolean flag =false;
				for(int k=max;k<i;k++) {
					if(num[k]==1) {
						num[k]=0;
						cnt++;
						flag =true;
						break;
					}
				}
				
				// 큰 위치 까지 앞에서 부터 돌면댑니다. 
				if(!flag) {
					int min = Math.min(n-1, i+space);
					for(int k=i;k<=min;k++) {
						if(num[k]==1) {
							num[k]=0;
							cnt++;
							break;
						}
					}
				}
				
			}
			
		}
	
		System.out.println(cnt);
	}
}
