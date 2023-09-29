import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int N = scan.nextInt(); // 구멍난 위치 
		int K = scan.nextInt(); // 테이프길 이 
		boolean[] check = new boolean[1001];
		Arrays.fill(check, true);
		for(int i =0; i<N ; i++) {
			int num = scan.nextInt(); // 구멍 난 곳이 1 입니다. 
			check[num] =false;
		}
		int cnt =0;
		for(int i=1; i<1001;i++) {
			if(!check[i]) {
				ch(check,i,K);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

	private static void ch(boolean[] check, int st, int k) {
		for(int i =st; i< st+k;i++) {
            if( i>=check.length) break;
			check[i]=true;
		}
	}
}
