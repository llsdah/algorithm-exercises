import java.util.*;

class Solution {
 	// bit 부분집합 정리 정렬 부분집합... 집합 부분 집합. 잘해보자.!있고 없
	public static int solution(String[][] relation) {
		// 중요 1<<4 이건 비트 즉 , 2진수의 이동이다. 10000 이 된다.
		// 이것보다 작은 값으로 이동하면 0~15까지 이도.

		// 유일성 우선, 원소의 갯수 원소의 갯수가 작은 순으로 정렬 해서...

		int rowsize = relation.length;
		int colsize = relation[0].length;

		// 유일성 만족위한 것ㄴ
		List<Integer> candidate = new LinkedList<Integer>();

		// 원소의 갯수만큼 이동한 것이 부분집히탑
		for (int i = 1; i < (1 << colsize); i++) {
			if (check(relation, rowsize, colsize, i) == true) {
				candidate.add(i);
			}
		}

		int answer = 0;
		// 비트가 작은 순서 대로 정렬
		Collections.sort(candidate, comp);

		while (candidate.size() != 0) {

			int n = candidate.remove(0);
			answer++;

			for (Iterator<Integer> it = candidate.iterator(); it.hasNext();) {
				int c = it.next();
				if ((n & c) == n) {
					it.remove();
				}
			}
		}

		return answer;
	}

	static Comparator<Integer> comp = new Comparator<Integer>() {

		int countBits(int n) {
			int ret = 0;
			while (n != 0) {

				if ((n & 1) != 0) {
					ret++;
				}

				n = n >> 1;
			}
			return ret;
		}

		public int compare(Integer a, Integer b) {
			int x = countBits(a);
			int y = countBits(b);

			if (x > y) {
				return 1;
			} else if (x < y) {
				return -1;
			} else {
				return 0;
			}
		}

	};

	public static boolean check(String[][] ralation, int rowsize, int colsize, int subSet) {

		for (int a = 0; a < rowsize - 1; a++) {

			for (int b = a + 1; b < rowsize; b++) {

				boolean isSame = true;
				// 비트 포함여부 체크 입니다.
				for (int k = 0; k < colsize; k++) {

					// 집합에서 포함된 사항인지 여부 체크 합니다.
					// k 번쨰 비트는 1로 변경한다.
					if ((subSet & 1 << k) == 0) {
						continue;
					}

					if (ralation[a][k].equals(ralation[b][k]) == false) {
						isSame = false;
						// 유일성 만족.. 위해서 한열에서 같은 것이 나온다 .
						break;
					}

				} // k

				if (isSame) {
					// 진짜면 계속 같다 두 퓨플이 같다.
					return false;
				}
			}

		}
		return true;

	}
}
