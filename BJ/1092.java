import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int c = sc.nextInt(); // 총 크레인수
		ArrayList<Integer> crain = new ArrayList<>();
		for (int i = 0; i < c; i++) {
			int num = sc.nextInt();
			crain.add(num);
		}

		int b = sc.nextInt();// 배수
		ArrayList<Integer> bea = new ArrayList<>();
		for (int i = 0; i < b; i++) {
			int num = sc.nextInt();
			bea.add(num);
		}
		Collections.sort(crain,Collections.reverseOrder());
		Collections.sort(bea,Collections.reverseOrder());
		if (crain.get(0) < bea.get(0))
			System.out.println("-1");
		else {
			int cnt = 0;
			while (!bea.isEmpty()) {
				int pos = 0;
				for(int i =0; i< crain.size();i++) {
					if(pos == bea.size())break;
					else if(crain.get(i)>=bea.get(pos)) {
						bea.remove(pos);
						i++;
					}else pos++;
					i--;
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}

// 시간 조초과. 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int c = sc.nextInt(); // 총 크레인수 
		int[] crain = new int[c];
		for(int i=0;i<c;i++) {
			crain[i]=sc.nextInt();
		}

		// 크레인 수 돌리고 그안에서 큰것부터 실고, 그안에서 큰 순서 대로 돌면되겠지 . 
		
		
		int b = sc.nextInt();// 배수 
		int[] bea = new int[b];
		for(int i=0;i<b;i++) {
			bea[i]=sc.nextInt();
		}
		Arrays.sort(crain);
		Arrays.sort(bea);
		// 방문 체크용 // 맨 마지막이 들어가면 끄내면됨
		int cnt = 0;
		boolean[] flag = new boolean[b];
		
		loof : while(true) {
			
			for(int i =c-1;i>=0;i--) {
				for(int k =b-1;k>=0;k--) {
					if(flag[k]) continue;
					if(crain[i]>=bea[k]) {
						flag[k]= true;
						break;
					}
				}
			}
			cnt++;
			for(int i =0; i<b;i++) {
				if(!flag[i]) break;
				if(i==b-1) break loof;
			}
			
		}
		
		System.out.println(cnt);
	}
}


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
