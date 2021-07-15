import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		// PPAP 만들기 . 그래서 결론 적으로 P가 나오면 됩. 나머지 는 NP
		String str = sc.next();
		// 쌍아서 P가 두개 이상일 경우 뺴기 아니면 틀림 A는 넣을 필요없다. 
		Stack<Character> st = new Stack<>();
		
		char[] arr = str.toCharArray();
		boolean flag = true;
		for(int i =0; i<arr.length;i++) {
			if(arr[i]=='P') st.push(arr[i]);
			else {
				// 2개 이상 P 넣고 , 남은게 1개 이상이고 
				// 여기 까지왔다는 것은 A 라는 것이니까 다름이 P이면됨
				//해당 조건이 맞으면 2개의 P를 뺴고, 다름으로 넘어가면 자동 P가 한개 추가 되는 거임
				if(st.size()>=2&& i<arr.length-1&&arr[i+1]=='P' ) {
					st.pop();
					st.pop();
				}else { // 해당 조건에 안맞으면 취소 
					flag = false;
					break;
				}
			}
			
		}
		
		if(flag&&st.size()==1) System.out.println("PPAP");
		else System.out.println("NP");
		
		
	}
}


/* 시간초과 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		// PPAP 만들기 . 그래서 결론 적으로 P가 나오면 됩. 나머지 는 NP
		String str = sc.next();
		String stand = "PPAP";
		
		
		while(str.contains(stand)) {
			StringBuilder sb = new StringBuilder();
			int pos = str.indexOf("PPAP");
			sb.append(str.substring(0, pos));
			sb.append("P");
			sb.append(str.substring(pos+4));
			str = sb.toString();
			System.out.println(sb.toString());
		}
		if(str.equals("P")) System.out.println(stand);
		else System.out.println("NP");
		
		
	}
}

*/
