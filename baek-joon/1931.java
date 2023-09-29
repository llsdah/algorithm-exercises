package backJun;

import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			// 끝 순서 대로 오름차순으로 정리 그러나
			@Override
			public int compare(int[] o1, int[] o2) {
				// 끝이 같은 경우 시작순서가 빠른대로 처리
				if (o1[1] == o2[1])
					return o1[0] - o2[0];

				return o1[1] - o2[1];
			}

		}

		);
		int end = 0;
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i][0] >= end) {
				cnt++;
				end = arr[i][1];
			}

		}
		System.out.println(cnt);
	}

}
