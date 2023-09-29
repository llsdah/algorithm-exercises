
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	// 슬라입 합친다 
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		// 두개 골라서 하나로 합친구.. 1개 남으면 끝났다. 
		// 양수 크기 합친 슬라임의 크기는 x+Y가 되고, 합칠떄 x*y점수 얻는다.
		
		int n =sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<n;i++) {
			q.offer(sc.nextInt());
		}
		long sum = 0;
		while(q.size()>1) {
			int one = q.poll();
			int two = q.poll();
			sum+=(one*two);
			q.offer(one+two);
		}
		System.out.println(sum);
		
	}
}
