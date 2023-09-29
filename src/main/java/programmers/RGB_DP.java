package AlgorismStudyUtube;

import java.util.Arrays;

public class RGB_DP {

	// index 값 1;
	static int[][] ans = new int[1002][4];
	static int[][] rgb = new int[1002][4];
	static int R = 1;
	static int G = 2;
	static int B = 3;

	public static void main(String[] args) {
		int input = 100;
		for(int i =0; i< ans.length;i++) {
			
			Arrays.fill(ans[i], 99999);
		}
		
		
		for (int i = 0; i <= input; i++) {
			for (int j = R; j <= B; j++) {
				rgb[i][j] = 10;
			}
		}

		ans[1][R] = rgb[1][R];
		ans[1][G] = rgb[1][G];
		ans[1][B] = rgb[1][B];
		for (int i = 2; i <= input; i++) {
			for (int k = R; k <= B; k++) {
				for (int h = R; h <= B; h++) {

					if (h != k) {
						ans[i][k] = Math.min(ans[i][k], rgb[i][k] + ans[i - 1][h]);

					}

				}

			}
		}

		
		System.out.println(Arrays.deepToString(ans));
	}
	

}
