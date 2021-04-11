class Solution{
	static List<String> list;
	static long answer = 0;
	public static long solution(String expression) {
		// 그냥 데이터값 입력 중복이 필요없기에
		HashSet<Character> set = new HashSet<Character>();

		// 붙여 넣기 용이하게
		StringBuilder sb = new StringBuilder();

		// 값의 추가삭제 용이
		list = new ArrayList<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch < '0' || ch > '9') {
				set.add(ch); // 연산자 넣기
				list.add(sb.toString());// 숫자 넣기 그 위에 연산자 붙이기
				list.add(Character.toString(ch));// ch+""
				sb = new StringBuilder();// 넣었으니 초기화

			} else {
				sb.append(ch);
			}

		}
		list.add(sb.toString());// 마지막 숫자는 입력해야댐따로

		Character[] cal = Arrays.stream(set.toArray()).toArray(Character[]::new);

		perm(cal, 0);

		return answer;
	}

	// 순영구현
	private static void perm(Character[] cal, int idx) {

		if (idx == cal.length) {
			List<String> copy = new ArrayList<String>();

			for (int i = 0; i < list.size(); i++) {
				copy.add(list.get(i));
			}
			long value = 0;

			for (int i = 0; i < cal.length; i++) {
				int k = 0;

				while (true) {

					if (k >= copy.size()) {
						break;
					}

					if (copy.get(k).equals(cal[i].toString())) {
						long value1 = Long.valueOf(copy.get(k - 1));
						long value2 = Long.valueOf(copy.get(k + 1));

						if (cal[i].toString().equals("-")) {
							value = value1 - value2;
						} else if (cal[i].toString().equals("*")) {
							value = value1 * value2;
						} else {
							value = value1 + value2;
						}

						// 3가지의 수 없에야댐. 그리고 아까의 value값 추가
						copy.remove(k - 1);
						copy.remove(k - 1);
						copy.remove(k - 1);

						copy.add(k - 1, Long.toString(value));
					} else {
						k++;
					}

				}
			}

			if (answer < Math.abs(value)) {
				answer = Math.abs(value);
			}
			return;
		}

		for (int i = 0; i < cal.length; i++) {
			swap(idx, i, cal);
			perm(cal, idx + 1);
			swap(idx, i, cal);

		}

	}// perm

	private static void swap(int idx, int i, Character[] cal) {

		Character temp = cal[idx];
		cal[idx] = cal[i];
		cal[i] = temp;

	}// swap

}

/*
 * 
 * // 잘못풀었던 흔적..... 
 * 
 * 
 * static String[] oper = new String[6]; static int idx=0; public static long
 * solution(String expression) { long answer = 0;
 * 
 * // 숫자와 3가지 문자 + - * 연산은 자유롭게 재정의 가장큰숫자 제출 // 같은 순위의연산자는 없어야 댄다.절대값으로 가장 큰겄!
 * // 홀수번에 는 것은 무조건 연산자. 짝수번에 있는 거는 무조건 숫자
 * 
 * String sp = ""; char[] arr = expression.toCharArray();
 * 
 * for (int i = 0; i < arr.length; i++) {
 * 
 * if (arr[i] == '*' || arr[i] == '-' || arr[i] == '+') { sp += "," + arr[i] +
 * ","; continue; }
 * 
 * sp += arr[i];
 * 
 * } String[] nums = sp.split(","); System.out.println(Arrays.toString(nums));
 * 
 * int n = 3; String[] cal = { "*", "-", "+" }; String[] order = new String[3];
 * boolean[] visit = new boolean[6];
 * 
 * permutaion(cal, order, visit, 0, n, 3);
 * 
 * System.out.println(Arrays.toString(oper));
 * 
 * long sum = 0; long temp = 0; for (int i = 0; i < nums.length; i++) {
 * 
 * if (nums[i].equals("*")) {
 * 
 * } else if (nums[i].equals("-")) {
 * 
 * } else if (nums[i].equals("+")) {
 * 
 * } else { sum += temp; }
 * 
 * }
 * 
 * return answer; }
 * 
 * private static void permutaion(String[] cal, String[] order, boolean[] visit,
 * int depth, int n, int r) {
 * 
 * if (depth == r) { print(order, r); return; }
 * 
 * for (int i = 0; i < n; i++) {
 * 
 * if (visit[i] != true) { visit[i] = true; order[depth] = cal[i];
 * permutaion(cal, order, visit, depth + 1, n, r); visit[i] = false;
 * 
 * } }
 * 
 * }
 * 
 * private static void print(String[] order, int r) { oper[idx] =""; for (int i
 * = 0; i < r; i++) {
 * 
 * oper[idx]+= order[i]; } idx++; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
