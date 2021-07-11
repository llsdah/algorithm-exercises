// 틀림.. 

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int c = sc.nextInt(); // 총 크레인수 
		int[] crain = new int[c];
		int[] cnt = new int[c];
		for(int i=0;i<c;i++) {
			crain[i]=sc.nextInt();
		}
		
		int b = sc.nextInt();// 배수 
		int[] bea = new int[b];
		int[] visit = new int[b];
		for(int i=0;i<b;i++) {
			bea[i]=sc.nextInt();
		}
		Arrays.sort(crain);
		Arrays.sort(bea);
		
		int pos = c-1;// 위치 
		// 배를 맨끝에서 돌면서 검색한다. 크레인에 하나 올린다. 
		
		while(true) {
			int temp =0;
			for(int i=b-1; i>=0;i--) { // 맨 큰것부터 가져옵니다. 
				if(visit[i]>=1) continue;
				if(bea[i]<=crain[pos]) { // 배보다 작거나 같으면 
					cnt[pos]++;// 어디에ㅓ 올렸는지
					visit[i]= 1;
					temp =i;
					pos --;
				}else {
					pos++;
				}
				break;
			}
			if(pos<0) pos = c-1;
			if(temp ==0) break;
		}
		
		System.out.println(Arrays.stream(cnt).max().getAsInt());
	}
}
// 시간 초과 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int c = sc.nextInt(); // 총 크레인수 
		int[] crain = new int[c];
		int[] cnt = new int[c];
		for(int i=0;i<c;i++) {
			crain[i]=sc.nextInt();
		}
		
		int b = sc.nextInt();// 배수 
		int[] bea = new int[b];
		int[] visit = new int[b];
		for(int i=0;i<b;i++) {
			bea[i]=sc.nextInt();
		}
		Arrays.sort(crain);
		Arrays.sort(bea);
		
		int pos = c-1;// 위치 
		// 배를 맨끝에서 돌면서 검색한다. 크레인에 하나 올린다. 
		
		while(true) {			
			for(int i=b-1; i>=0;i--) { // 맨 큰것부터 가져옵니다. 
				if(visit[i]>=1) continue;
				if(bea[i]<=crain[pos]) { // 배보다 작거나 같으면 
					cnt[pos]++;// 어디에ㅓ 올렸는지
					visit[i]= 1;
					pos --;
					break;
				}
			}
			if(pos<0) pos = c-1;
			long temp = Arrays.stream(visit).filter(i -> i >=1).count();
			if(temp == visit.length) break;
		}
		
		System.out.println(Arrays.stream(cnt).max().getAsInt());
	}
}
