
import java.util.Arrays;

public class 프랜즈 {

	public static void main(String[] args) {

		//int m = 4;
		//int n = 5;
		//String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		int m = 6;
		int n = 6;
//		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };

		int result = solution(m, n, board);

		System.out.println("result : " + result);
		// System.out.println("result : " + Arrays.toString(result));
		// System.out.println("result : "+ Arrays.deepToString(result));
	}

	static char[][] boards;
	static boolean[][] check;

	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		boards = new char[m][n];
		check = new boolean[m][n];

		for (int y = 0; y < boards.length; y++) {

			char[] temp = board[y].toCharArray();
			for (int x = 0; x < boards[0].length; x++) {

				boards[y][x] = temp[x];

			}

		}
		
		for (int i = 0; i < boards.length; i++) {
			System.out.println(Arrays.toString(boards[i]));
		}
		for (int i = 0; i < boards.length; i++) {
			System.out.println(Arrays.toString(check[i]));
		}
		System.out.println();

		
		int count = 0;

		loof : while (true) {
			for (int y = 0; y < boards.length - 1; y++) {

				for (int x = 0; x < boards[0].length - 1; x++) {

					if (  boards[y][x]!='1' &&boards[y][x] == boards[y][x + 1] && boards[y][x] == boards[y + 1][x]
							&& boards[y][x] == boards[y + 1][x + 1]) {
						count++;
						check[y][x] = true;
						check[y][x + 1] = true;
						check[y + 1][x] = true;
						check[y + 1][x + 1] = true;

					}

				}

			}
			
			if( count ==0) {
				break loof;
			}
			move();
			
			for (int i = 0; i < boards.length; i++) {
				System.out.println(Arrays.toString(boards[i]));
			}
			for (int i = 0; i < boards.length; i++) {
				System.out.println(Arrays.toString(check[i]));
			}
			System.out.println();

			
			for(int i =0; i<check.length;i++) {
				Arrays.fill(check[i], false);
				
			}
			count=0;
		
		}

		
		
		//정답 체크 영역 
		for (int y = 0; y < boards.length; y++) {

			for (int x = 0; x < boards[0].length; x++) {

				if( boards[y][x]=='1') {
					answer++;
				}
			}

		}
		
		
		for (int i = 0; i < boards.length; i++) {
			System.out.println(Arrays.toString(boards[i]));
		}
		System.out.println();
		for (int i = 0; i < boards.length; i++) {
			System.out.println(Arrays.toString(check[i]));
		}

		return answer;
	}

	//이동영역 체크
	private static void move() {

		for (int y = 0; y < boards.length; y++) {

			for (int x = 0; x < boards[0].length; x++) {

				if (check[y][x]) {
					moveCol(y, x);
				}

			}

		}

	}

	// 열이동
	private static void moveCol(int y, int x) {

		if (y == 0) {
			boards[y][x] = '1';
			return;
		}
		for( int i =y; i>=1;i--) {

			boards[i][x] = boards[i - 1][x];
			boards[i - 1][x] = '1';
		}

	}
}
