
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// 3마리 캥거루 논다. ㅜ직선 서로 다른 좌표
		
		while(sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			int one = b-a;
			int two = c-b;
			int cnt = Math.max(one, two)-1;
			
			System.out.println(cnt);
			
		}
	}
}
