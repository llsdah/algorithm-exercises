// 시간초과.. 흠...
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();// 원판 갯수 
		int total = (int) (Math.pow(2, n)-1);
		
		// 갯수, 시작 중간 끝
		solve(n,1,2,3);
		System.out.println(total);
		String[] arr = sb.toString().split(","); // 다름 점은 이건데.. 이거 때문에 시간이 초과라니.. 흠.. 
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}
	private static void solve(int n, int start, int via, int end) {

		if(n==1) {
			sb.append(start +" "+end+",");
			return;
		}
		solve(n-1,start,end,via);
		sb.append(start+" "+end+",");
		solve(n-1,via,start,end);
		
	}
}
