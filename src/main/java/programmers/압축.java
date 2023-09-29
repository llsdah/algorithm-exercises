import java.util.*;

class Solution {
	static int[] nums = new int[1001];
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static char[] arr;
	static int[] ans = new int[1000];
	static int index;

	public static int[] solution(String msg) {
		msg = msg.toUpperCase();
		arr = msg.toCharArray();
		for (int i = 0; i < 26; i++) {

			map.put((char) ('A' + i) + "", i + 1);

		}

        
        if( msg.length()==1) {
			int[] answer = new int[1];
			answer[0] = map.get(msg);
			return answer;
			
		}
        
		for (int i = 0; i < arr.length; i++) {

			i = save(i);

		}

		int[] answer = Arrays.stream(ans).filter(i -> i != 0).toArray();
		return answer;
	}

	private static int save(int pos) {
		String str = "";
		for (int i = pos; i < arr.length - 1; i++) {
			str += arr[i];
			if (map.containsKey(str + arr[i + 1])) {
				
				if (i == arr.length - 2) {					
					str += arr[i+1];
					ans[index] = map.get(str);
					index++;
					str = "";
					return i;
				}

			} else {
				ans[index] = map.get(str);
				index++;
				map.put(str + arr[i + 1], map.size() + 1);
		
				if (i == arr.length - 2) {
					ans[index] = map.get(arr[i + 1] + "");
					return i + 2;
				}

				return i;
			}

		}

		return arr.length;
	}// 단어 저장용
}
