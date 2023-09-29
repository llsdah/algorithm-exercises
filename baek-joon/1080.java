import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int row = scan.nextInt();
		int col = scan.nextInt();
		int[][] A = new int[row][col];
		int[][] B = new int[row][col];
		for (int i = 0; i < row; i++) {
			String str = scan.next();
			for (int k = 0; k < col; k++) {
				A[i][k] = str.charAt(k) - '0';
			}
		}

		for (int i = 0; i < row; i++) {
			String str = scan.next();
			for (int k = 0; k < col; k++) {
				B[i][k] = str.charAt(k) - '0';
			}
		}

		int cnt = 0;
		loof: for (int i = 0; i <= row - 3; i++) {
			for (int k = 0; k <= col - 3; k++) {
				if (A[i][k] != B[i][k]) {
					cnt++;
					change(A, i, k);
					boolean flag = Arrays.deepEquals(A, B);
					if (flag)
						break loof;
				}
			}
		}

		// 3바이 3을 다 뒤집는 거얌.

		System.out.println(cnt);
	}

	public static void change(int[][] A, int row, int col) {

		for (int i = row; i < row + 3; i++) {
			for (int k = col; k < col + 3; k++) {
				A[i][k] = A[i][k] == 1 ? 0 : 1;
			}
		}

	}

}
