package studyProgrammers;

import java.util.Arrays;

public class 쿼드압축후갯수세기 {

	public static void main(String[] args) {

		int m = 6;
		// String[] order = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		String[] order = { "XYZ", "XWY", "WXA" };
		int[] course = { 2, 3, 4 };

		// String p ="()))((()";

		int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

		int[][] arr2 = {

				{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 }

		};

		int[] result = solution(arr2);
		System.out.println("result : " + Arrays.toString(result));
	}

	static int[] answer;
	public static int[] solution(int[][] arr) {
		answer = new int[2];

		for(int x=0;x < arr.length;x++) {
			
			for( int y=0;y< arr[0].length;y++ ) {
				
				if( arr[x][y]==0) {
					answer[0]++;
				}else {
					answer[1]++;
				}
				
			}
			
		}
		System.out.println(Arrays.toString(answer));
		foursquar(arr);

		return answer;

	}

	public static void foursquar(int[][] arr) {
		int stWid = 0;
		int wid = arr[0].length;// x
		int heEnd = 0;
		int hei = arr.length;// y

		// 상왼 오, 하 왼 오
		boolean[] check = new boolean[4];


		if( arr.length==2) {
			
			justTwo(arr);
			return;
		}
		
		int[][] upLeft_arr = new int[wid / 2][hei / 2];
		int[][] upRight_arr = new int[wid / 2][hei / 2];
		int[][] upDown_arr = new int[wid / 2][hei / 2];
		int[][] downRight_arr = new int[wid / 2][hei / 2];

		
		// 상 왼
		int upLeft = -1;
		upLeft: for (int x = stWid; x < wid / 2; x++) {

			for (int y = heEnd; y < hei / 2; y++) {

				upLeft_arr[x][y] = arr[x][y];
				if (upLeft == -1) {
					upLeft = arr[x][y];
				}
				if (upLeft == arr[x][y]) {
					check[0] = true;
				} else {
					check[0] = false;

					break upLeft;
				}

			}

		}
		if (check[0]) {
			answer[upLeft] += -(wid / 2 * hei / 2) + 1;

		}

		stWid = wid / 2;
		heEnd = 0;

		// 상 오
		int upRight = -1;
		upRight: for (int x = stWid; x < wid; x++) {

			for (int y = heEnd; y < hei / 2; y++) {

				upRight_arr[x-(wid / 2)][y] = arr[x][y];
				
				if (upRight == -1) {
					upRight = arr[x][y];
				}
				if (upRight == arr[x][y]) {
					check[1] = true;
				} else {
					check[1] = false;

					break upRight;
				}

			}

		}
		if (check[1]) {
			answer[upRight] += -(wid / 2 * hei / 2) + 1;

		}

		stWid = 0;
		heEnd = arr.length / 2;

		// 하 왼
		int upDown = -1;
		upDown: for (int x = stWid; x < wid / 2; x++) {

			for (int y = heEnd; y < hei; y++) {

				upDown_arr[x][y-(wid / 2)] = arr[x][y];
				if (upDown == -1) {
					upDown = arr[x][y];
				}
				if (upDown == arr[x][y]) {
					check[2] = true;
				} else {
					check[2] = false;
					break upDown;
				}

			}

		}

		if (check[2]) {
			answer[upDown] += -(wid / 2 * hei / 2) + 1;

		}

		stWid = arr.length / 2;
		heEnd = arr.length / 2;

		// 하 오
		int downRight = -1;
		downRight: for (int x = stWid; x < wid; x++) {

			for (int y = heEnd; y < hei; y++) {

				downRight_arr[x-(wid / 2)][y-(wid / 2)] = arr[x][y];
				if (downRight == -1) {
					downRight = arr[x][y];
				}
				if (downRight == arr[x][y]) {
					check[3] = true;
				} else {
					check[3] = false;
					break downRight;
				}

			}

		}

		if (check[3]) {
			answer[downRight] += -(wid / 2 * hei / 2) + 1;

		}
		System.out.println("answer : "+Arrays.toString(answer));
		//
		if( !check[0]) {
			foursquar(upLeft_arr);
		}
		
		if( !check[1]) {
			foursquar(upRight_arr);
		}
		
		if( !check[2]) {
			foursquar(upDown_arr);
		}
		
		if( !check[3]) {
			foursquar(downRight_arr);
		}
		
		
		
	}

	private static void justTwo(int[][] arr) {
		int stWid = 0;
		int wid = arr[0].length;// x
		int heEnd = 0;
		int hei = arr.length;// y

		// 상왼 오, 하 왼 오
		boolean[] check = new boolean[4];
		
		// 상 왼
		int upLeft = -1;
		upLeft: for (int x = stWid; x < wid / 2; x++) {

			for (int y = heEnd; y < hei / 2; y++) {

				if (upLeft == -1) {
					upLeft = arr[x][y];
				}
				if (upLeft == arr[x][y]) {
					check[0] = true;
				} else {
					check[0] = false;

					break upLeft;
				}

			}

		}
		if (check[0]) {
			answer[upLeft] += -(wid / 2 * hei / 2) + 1;

		}

		stWid = wid / 2;
		heEnd = 0;

		// 상 오
		int upRight = -1;
		upRight: for (int x = stWid; x < wid; x++) {

			for (int y = heEnd; y < hei / 2; y++) {

				if (upRight == -1) {
					upRight = arr[x][y];
				}
				if (upRight == arr[x][y]) {
					check[1] = true;
				} else {
					check[1] = false;

					break upRight;
				}

			}

		}
		if (check[1]) {
			answer[upRight] += -(wid / 2 * hei / 2) + 1;

		}

		stWid = 0;
		heEnd = arr.length / 2;

		// 하 왼
		int upDown = -1;
		upDown: for (int x = stWid; x < wid / 2; x++) {

			for (int y = heEnd; y < hei; y++) {

				if (upDown == -1) {
					upDown = arr[x][y];
				}
				if (upDown == arr[x][y]) {
					check[2] = true;
				} else {
					check[2] = false;
					break upDown;
				}

			}

		}

		if (check[2]) {
			answer[upDown] += -(wid / 2 * hei / 2) + 1;

		}

		stWid = arr.length / 2;
		heEnd = arr.length / 2;

		// 하 오
		int downRight = -1;
		downRight: for (int x = stWid; x < wid; x++) {

			for (int y = heEnd; y < hei; y++) {

				if (downRight == -1) {
					downRight = arr[x][y];
				}
				if (downRight == arr[x][y]) {
					check[3] = true;
				} else {
					check[3] = false;
					break downRight;
				}

			}

		}

		if (check[3]) {
			answer[downRight] += -(wid / 2 * hei / 2) + 1;

		}

	}

}
