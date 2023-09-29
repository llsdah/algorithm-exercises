import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static String arr[];
	static Long longs[] = new Long[10];
	static boolean head[] = new boolean[10];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();

		}
		check(str);

		long sum = 0, value = 9;
		for (Long aLong : longs) {
			sum += aLong * value--;
		}
		System.out.println(sum);

	}

	private static void check(String[] str) {

		long inp[] = new long[10];

		for(int k=0;k<str.length;k++) {
			char[] arr = str[k].toCharArray();
			int len = arr.length;
			long d = 1;
			for (int i = len - 1; i >= 0; i--, d *= 10) {
				inp[arr[i] - 'A'] += d;
			}
			head[arr[0] - 'A'] = true; // 맨앞에 나온것들 !!! 1개는 안나온다 마지막 조건.. 
		}

		// 0을 사용하는 경우와 안사용하는 경우 
		long min = Long.MAX_VALUE;
		int last = 0;
		for (int i = 0; i < 10; i++) {
			if (!head[i] && inp[i] < min) {
				last = i;
				min = inp[i];
			}
		}
		inp[last] = 0;
		longs = Arrays.stream(inp).boxed().toArray(Long[]::new);
		Arrays.sort(longs, Collections.reverseOrder());
	}

}


/// 마지막 조건 이 충족... 한개는 맨앞에안온다..
public class Main {
	
	static HashMap<Character, Long> map = new HashMap<>();
	static long no =-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// 각 알파벳의 기여도를 파악해서 순서대로 배워 그리고 합을 출력
		int n = sc.nextInt();
		String[] arr = new String[n];
		for(int i =0; i< n;i++) {
			arr[i] = sc.next();
		}
		
		for(int i =0; i<n;i++) {
			char[] ch = arr[i].toCharArray();
			check(ch);	
		}
		
		int num = map.size();
		long[] nums = new long[num];
		for(char key : map.keySet()) {
			num--;
			nums[num] = map.get(key);
			
		}
		Arrays.sort(nums);
		long sum =0;
		int cnt =9;
		for(int i=nums.length-1;i>=0;i--) {
			sum+=(cnt*nums[i]);
			cnt--;
		}
		
		System.out.println(sum);
	}
	private static void check(char[] ch) {

		int num = ch.length;
		for(int i=0; i<num;i++) {
			char temp = ch[i];
			if(map.getOrDefault(temp,no)==-1) map.put(temp, (long) Math.pow(10,num-1-i) );
			else map.put(temp, map.get(temp)+(long) Math.pow(10,num-1-i) );
		}
		
	}
}
