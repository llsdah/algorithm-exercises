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

/* 메모리 초과 방법... 슬프담. deque 라는 것 한개 

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt(); // 자리 수 
		int k = sc.nextInt(); // 지우기 
		String number  =sc.next();
		
		char[] arr =number.toCharArray();
		Stack<Integer> st =new Stack<>();
		int cnt =0;// 삭제 갯수 카운트
		String ans ="";
		
		loof : for(int i=0; i<n;i++) {// 계속 돌면서 체크
			int num = arr[i]-'0';
			if(st.isEmpty()) {
				st.push(num);
				continue;
			}
			
			if( st.peek()>=num) {
				st.push(num);
			}else {
				while(st.peek()<num) {
					st.pop();
					cnt++;
					if(cnt == k ) {
						ans = number.substring(i);
						break loof;
					}
					
					if(st.isEmpty()) break; // 비었으면 그만 
				}
				st.push(num); //추가
			}
			
			if(cnt==k) break; // 삭제 갯수가 맞다면
		
		}
		
		while(!st.isEmpty()) { // 하나씩 추가 
			ans = st.pop()+ans;
		}
		
		if( ans.length()> n-k) { // 더 길다면 
			ans = ans.substring(0,n-k);
		}
		System.out.println(ans);

	}
}
*/
