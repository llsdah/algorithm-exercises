package studyProgrammers;

public class 단체사진찍기 {

	public static void main(String[] args) {

		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };

		int result = solution(n, data);
		System.out.println("result : " + result);

	}

	static char[] 캐릭터 = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static char[] pos = new char[8];
	static boolean[] visited = new boolean[8];
	static int cnt = 0;

	public static int solution(int n, String[] data) {
		int answer = 0;

		backtracking(0, n, data);
		answer =cnt;
		return answer;
	}

	private static void backtracking(int depth, int n, String[] data) {

		// 8명 줄세우는 경우의 수를 모두 담책 합니다. 8!
		if (depth == 8) {
			if (isPos(n, data)) {
				cnt++;
			}
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {

				visited[i] = true;
				pos[depth] = 캐릭터[i];
				backtracking(depth + 1, n, data);
				visited[i] = false;
			}
		}

	}

	private static boolean isPos(int n, String[] data) {

		for (int i = 0; i < n; i++) {
			char[] condition = data[i].toCharArray();
			int from = 0;
			int to = 0; // 각 해당하는 캐릭터 위치 구하기

			int cond = condition[4] - '0';// 거리 변수 변환

			for (int k = 0; k < 8; k++) {

				if (pos[k] == condition[0]) {
					from = k;
				}
				if (pos[k] == condition[2]) {
					to = k;
				}

			}

			int gap = Math.abs(from - to) - 1;// -1 해야 몇칸인지 않다?흠..

			switch (condition[3]) {

			case '=': {
				if (gap != cond) {
					return false;
				}
				break;
			}
			
			case '>': {
				if (gap <= cond) {
					return false;
				}
				break;
			}
			
			case '<': {
				if (gap >= cond) {
					return false;
				}
				break;
			}
			

			}

		}

		return true;
	}

}
