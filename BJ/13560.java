
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 출구게임
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// 한 팀은 모든 팀과 경기 무승 부 없다.
		int n = sc.nextInt();// 참가 팀수 
		// 이기면 1 지면 0 즉 
		// 한팀이 1이면 다른팀은 0 해당 점수의 배열의 유요한지 . 즉 대칭인지?
		int[] point = new int[n];
		for(int i=0;i<n;i++) {
			point[i]= sc.nextInt();
		}
		Arrays.sort(point);// 순 방향 정렬 
		int ans =0;
		boolean flag =true;
		for(int i=0;i<n;i++) {
			// n경기 까지의 모든 점수의 총합은 합의 공식 n+1*n/2이다 
			ans +=point[i];
			if(ans<(i+1)*i/2) {
				flag =false;
				break;
			}
		}
		
		ans = ans == n*(n-1)/2 ? 1: -1; // n은 i+1 공식은 뒤집어 총합이 맞으면 됨
		if(!flag) System.out.println(flag+" "+-1);
		else System.out.println(ans);
		
		
		
	}
}


// 깊이 생각 수학 생각
public class Main {

	// 출구게임
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// 한 팀은 모든 팀과 경기 무승 부 없다.
		int n = sc.nextInt();// 참가 팀수 
		// 이기면 1 지면 0 즉 
		// 한팀이 1이면 다른팀은 0 해당 점수의 배열의 유요한지 . 즉 대칭인지?
		int[] point = new int[n];
		for(int i=0;i<n;i++) {
			point[n]= sc.nextInt();
		}
		Arrays.sort(point);// 순 방향 정렬 
		boolean flag = true;
		int[] time = new int[n];// 
		for(int i =n-1;i>=0;i--) { // 큰것 부터 정렬
			int win = point[i];
			int lose = n-win;
			if( n-time[i]<win) break; // 가질 수 있는 최대 점수 보다 승이 크면 종료
			
			for(int k=0;k<i;k++) {//지금 순서 직전까지 돌명서 lose를 없애야댐 
				
			}
			
			
		}
		
		
	}
}
