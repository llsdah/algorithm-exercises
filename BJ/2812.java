import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt(); // 자리 수 
		int k = sc.nextInt(); // 지우기 
		String number  =sc.next();
		int ttt =k;
		char[] arr =number.toCharArray();
		String ans ="";
		
		Deque<Character> dq =new ArrayDeque<>();
		Stack<Character> st =new Stack<>();
		for(int i=0; i<n;i++) {
			// 맨 뒤에가 지금 넣는 값보다 작으면 삭제 계속 삭제 단 K값이 0일떄 까지만
			while(k>0&&!dq.isEmpty()&&dq.getLast()<arr[i]) {
				dq.removeLast();
				k--;
			}
			dq.addLast(arr[i]);
		}
		StringBuilder sb =new StringBuilder();
		while(dq.size()>k) {
			sb.append(dq.removeFirst());
		}
		ans = sb.toString();
		System.out.println(ans);
		System.out.println("---------");
	
		k=ttt;
		for(int i=0; i<n;i++) {
			// 맨 뒤에가 지금 넣는 값보다 작으면 삭제 계속 삭제 단 K값이 0일떄 까지만
			while(k>0&&!st.isEmpty()&&st.peek()<arr[i]) {
				char temp =st.pop();
				k--;
			}
			st.push(arr[i]);
		}
		ans="";
		while(st.size()>k) {
			ans =st.pop()+ans;
		}
		System.out.println(ans);
	
	}
}



