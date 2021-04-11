class Solution {

	static boolean[][] check;
	static int count;// 영역수  
	static int space;//영역 크기
	
	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		
		
		count=0;
		space=0;
		int[][] pic = picture;
		
		check = new boolean[pic.length][pic[0].length];

		for (int i = 0; i < pic.length; i++) {

			for (int k = 0; k < pic[0].length; k++) {

				if (pic[i][k] != 0 && !check[i][k]) {
					// 통과 했으니까 일단
					check[i][k] = true;
					point(i, k, pic);
				}
			}

		}
		
		numberOfArea =count;
		maxSizeOfOneArea = space;
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	// 가로 세로 다른것을 찾아요
	private static void point(int x, int y, int[][] picture) {

		// 여기 왔다는 거 자체가 0이 아니고 , 기존의 값도 없다는 거니까 무조건증가?
		int sp =1;
		for (int i = x; i < picture.length; i++) {
			for (int k = y; k < picture[0].length; k++) {

				// 자신인 경우에는 다음으로 넘어가면됨.
				if (i == x && k == y) {
					continue;
				}

				if (picture[i][k] == picture[x][y] && !check[i][k]) {
					check[i][k] = true;
					sp++;
				} else {
					break;
				}
			}

		}
		
		count++; //영역수 1개 추가 
		space = Math.max(space, sp);// 가장 큰 넓이 
		
	}// 종료
	
	
}
