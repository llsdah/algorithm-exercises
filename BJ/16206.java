import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 16206 입니다. 롤케익크 
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();// 롤케익 받는 수

		int M = sc.nextInt();// 자를 횟 수

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int cnt = (int) Arrays.stream(arr).filter(i -> i == 10).count();
		if (cnt == n) {
			System.out.println(cnt); // 10인 갯수와 같으면 안잘라도됨.
			return;
		}
		Arrays.sort(arr);// 정렬 됐으니까 어짜피 20부터 먼저 들어옴.

		int cut = M;
		// 10의 배수 부터 가장 쉽게 자리느까
		for (int i = 0; i < n; i++) {
			if (arr[i] <= 10)
				continue;// 10보다 작으면 어짜피 못먹는다. 10은 이미 체크
			if (arr[i] % 10 != 0)
				continue;// 10의 배수만 피룡합니다.
			if (arr[i] == 20) {
				cut--;
				cnt += 2; // 1번에 두개
				continue;
			}
			int temp = arr[i];
			while (temp > 10 && cut > 0) {
				if (temp == 20) {
					cut--;
					cnt += 2; // 1번에 두개
					temp = 0;
					continue;
				}
				temp -= 10;// 10개씩 자르니까
				cut--;// 자를 수 있는거 없어지고.
				cnt++;
			}

		}

		// 10의 배수가 아닌거
		for (int i = 0; i < n; i++) {
			if (arr[i] <= 10) continue;// 10보다 작으면 어짜피 못먹는다. 10은 이미 체크
			if (arr[i] % 10 == 0) continue;// 10의 배수면 했다

			int temp = arr[i];
			while (temp > 10 && cut > 0) {
				temp -= 10;// 10개씩 자르니까
				cut--;// 자를 수 있는거 없어지고.
				cnt++;
			}

		}

		System.out.println(cnt);
	}

}
