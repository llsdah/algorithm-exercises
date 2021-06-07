import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		String str = sc.next();
		char[] arr = str.toCharArray();
		int cnt =0; // 없는 사람 
		for(int i =0; i<arr.length;i++) {
			if(arr[i]=='L') {
				cnt++;
			}
		}
		if(cnt!=0) {
			cnt = cnt/2 -1;
			n = n-cnt;
		}
			
		System.out.println(n);
		
	}
}

