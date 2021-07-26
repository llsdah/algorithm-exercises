import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

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
