import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A_Test {

	public static void main(String[] args) {

		int[] p ={2,1,3,2};
		int n =2;
		int result = solution(p,n);
		System.out.println("result : " + result);
		
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Printer> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) { // print큐에 인덱스번호, 우선순위 삽입
			q.offer(new Printer(i, priorities[i]));
		}
		System.out.println(Arrays.toString(priorities));
		System.out.println("시작 시 q size : "+ q.size());
		System.out.println();
		while (!q.isEmpty()) {

			System.out.println(" while 시작 시 q size : "+ q.size());
			boolean flag = false;
			int com = q.peek().prior;
			for (Printer p : q) {
				System.out.println("p . 값 "+ p.prior);
				System.out.println(com+" com : for문 끝난 후  q size : "+ q.size());
				if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
					flag = true;
					break;
				}
			}
			
			System.out.println(com+" com : for문 끝난 후  q size : "+ q.size());
			if (flag) {
				q.offer(q.poll());
			} else {// 현재 맨앞의 숫자가 가장 클 때
				if (q.poll().location == location) {
					answer = priorities.length - q.size(); // 순위는 길이에서 뒤에 남아있는 갯수 
					break;
				}
			}
			System.out.println();
		}
		return answer;
	}

}


class Printer {
	int location;
	int prior;

	Printer(int location, int prior) {
		this.location = location;
		this.prior = prior;
	}
}
