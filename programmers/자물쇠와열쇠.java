package studyProgrammers;

import java.util.HashMap;
import java.util.Stack;

public class A_Test {

	public static void main(String[] args) {

		// int m = 4;
		// int n = 5;
		// String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		int[][] n = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] tt = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		String sentense = "HaEaLaLaObWORLDb";

		boolean result = solution(n, tt);

		// long[] result = solution4(n,z,roads,queries);

		System.out.println("result : " + result);

	}

	public static boolean solution(int[][] key, int[][] lock) {
// 더 넣은 부분의 배열을 생성하고. 그것을 돌려가면서 생성하기 
// 시계방향 90도	회원 배우기 	

		// 1. 큰 영역 복사
		int offset = key.length - 1;// 중심 길이

		for (int r = 0; r < offset + lock.length; r++) {

			for (int c = 0; c < offset + lock.length; c++) {

				
				
				for (int rot = 0; rot < 4; rot++) { // 회전하는것 0, 1,2,3

					int[][] arr = new int[58][58]; // 전체 최대 크기 20개 20개 이므로

					for (int i = 0; i < lock.length; i++) {

						for (int k = 0; k < lock.length; k++) {

							arr[offset + i][offset + k] = lock[i][k];

						}

					}

					match(arr, key, rot, r, c);// 키를 일치하는 함수 입니다.

					// 일치하는 함수
					if (check(arr, offset, lock.length)) {

						return true;
					} // 영역이 다 1이면 열쇄가 맞는것 바로 반환

				} // 세번쨰 for문 입니다.

			} // 두번째for 문 col

		}

		return false;
	}

	private static boolean check(int[][] arr, int offset, int n) {

		for(int i =0; i<n;i++) {
			for(int k=0;k<n;k++) {
				
				if( arr[offset+i][offset+k] != 1) {
					return false;
				}
				
			}
		}
		
		return true;
	}

	private static void match(int[][] arr, int[][] key, int rot, int r, int c) {
		int n = key.length;
		// 키의 값 더해보기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (rot == 0) {
					arr[r + i][c + j] += key[i][j];
				
				} else if (rot == 1) { // 90도 회전한것
					arr[r + i][c + j] += key[j][n - 1 - i]; // 첫번째 열이 첫번쨰 행이 된다. 끝에 꺼는 첫번쨰가 된다
				
				} else if (rot == 2) { // 180도 회전한것
					arr[r + i][c + j] += key[n - 1 - i][n - 1 - j]; // 첫번째 열이 첫번쨰 행이 된다. 끝에 꺼는 첫번쨰가 된다
				
				} else if (rot == 3) { // 270도 회전한것 반시계 90도 
					arr[r + i][c + j] += key[n - 1 - j][i]; // 첫번째 열이 첫번쨰 행이 된다. 끝에 꺼는 첫번쨰가 된다
				
				}

			}
		}

	}

}
