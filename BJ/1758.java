import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int c = sc.nextInt(); // 총 크레인수
		int[] arr= new int[c];
		for(int i =0; i< c;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int cnt = 0;
		for(int i =c-1;i>=0;i--) {
			int num = arr[i]-((c-i)-1);
			cnt += (num >0 ? num : 0);
		}
		System.out.println(cnt);
	
	}
}
