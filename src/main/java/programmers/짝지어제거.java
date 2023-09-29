import java.util.*;

// stack 사용힌트
class Solution
{
 		public static int solution(String s) {


		char[] arr = s.toCharArray();
		
		Stack<Character> st = new Stack<Character>();
		
		for(int i =0; i< arr.length;i++) {
			
			if(st.isEmpty()|| st.peek()!=arr[i]) {
				st.push(arr[i]);
			
			}else if( st.peek()==arr[i]) {
				st.pop();
			}
			
		}
		
		return st.isEmpty() ? 1:0;
	}
}



// 처음 풀이.. 시간 초과.
class Solution
{
 		public static int solution(String s) {

		StringBuffer sb = new StringBuffer();

		char[] arr = s.toCharArray();
		char temp = ' ';
		int num = s.length();
		int count = 0;

		// 멈추는 경우 길이가 s인데, count <2 은경우
		temp = arr[0];
		sb.append(temp);

		while (true) {

			for (int i = 1; i < num; i++) {

				if (temp == arr[i]) {
					if (arr.length == 2) {
						return 1;
					}
					sb.deleteCharAt(sb.length() - 1);

					for (int k = i + 1; k < num; k++) {
						sb.append(arr[k]);
					}
					;
			
					arr = sb.toString().toCharArray();
					sb.delete(0, sb.length());

					temp = arr[0];
					sb.append(temp);
					num = arr.length;
					count = 0;

					break;
				} else {
					temp = arr[i];
					sb.append(temp);
					count = 1;
				}

			}

			if (count == 1) {
				return 0;
			}

		}

	}
}
