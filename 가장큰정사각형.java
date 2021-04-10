package studyProgrammers;

public class 가장큰정사각형 {


	public static void main(String[] args) {

		int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };

		int[][] board2 = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };

		int result = solution(board);
//		System.out.println("result : " + Arrays.toString(result));
		System.out.println("result : " + result);
	}

	public static int solution(int[][] board) {
		int answer = 1234;


		for(int x= 1; x<board.length;x++) {
			
			for(int y =1; y<board[x].length;y++) {
			
				int a = board[x-1][y];
				int b = board[x-1][y-1];
				int c = board[x][y-1];
				int d = board[x][y];
			
				if( a>=1&&b>=1&&c>=1&&d>=1) {
					board[x][y] =Math.min(a, Math.min(c, b))+1;
				}
			}
			
		}
		
		
		int max = 0;
		
		for( int i = 0; i<board.length;i++) {
			for(int k=0; k<board[i].length;k++) {
				max = Math.max(max, board[i][k]);
			}
		}
		
		
		answer =max*max;
		return answer;
	}


	
}
