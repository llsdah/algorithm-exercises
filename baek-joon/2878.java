// d=나랑 비스 무리한데 나는안되네.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이진탐색 ? 그리디 ?
// 캔디캔디
public class p2878 {
	static long[] wants;
	static final long REMAIN = (long) Math.pow(2, 64); 
	static long lack;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		wants = new long[n];
		
		long sum = 0;
		for(int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());
			wants[i] = num;
			sum += num;
		}
		
		lack = sum - m;
		
		long result = 0;
		Arrays.sort(wants);
		
		for(int i = 0; i < n; i++) {
			// 요구하는 사탕 갯수만큼 못받을래? 아니면 남은 사람들이랑 똑같이 못받을래?
			// 둘 중 더 많이 받을 수 있는 것을 선택 = 둘 중 더 작은 값을 못받는다.
			long removeCount = Math.min(wants[i], lack / (n - i));
			lack -= removeCount;
			result += removeCount * removeCount;	// Math.pow() 는 int 형식이라 안됨. 
			result %= REMAIN;
		}
		
		System.out.println(result);
	}
}
//view rawp2878.java hosted with ❤ by GitHub
//Blog is powered by kakao / Designed by Tistory

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	//모든 국회의원박탈.
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[m];
		for(int i=0;i<m;i++) {
			arr[i] =sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = Math.abs(n - Arrays.stream(arr).sum());
		
		if(cnt<=1||cnt==m) {		
			System.out.println(cnt);
		}else {
			int[] nums = new int[m];
			int pos =0;
			while(cnt>0) {
				nums[pos]++;
				cnt--;
				pos++;
				if(pos==m) pos=0;
			}
			long sum =0;
			for(int i=0; i<m;i++) {
				sum+=Math.pow(nums[i], 2);
			}
			System.out.println(sum);
		}
		
		
		
		
	}
}
