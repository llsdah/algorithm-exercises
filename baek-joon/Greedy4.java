
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		
		int bj = scan.nextInt();
		String[] word = new String[bj];
		for(int i=0; i < bj;i++) {
			
			word[i] = scan.next();
			
		}
		
		Arrays.toString(word);
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		
		// 전체 순회 출력을 가능해야댐 .
		for(int i =0; i< word.length;i++) {
			
			char[] arr = word[i].toCharArray();
			
			for(int k =0; k<arr.length;k++) {
				
				if(map.getOrDefault(arr[k], -1)==-1) {
					map.put(arr[k],(int) Math.pow(10, arr.length-1-k));
				} else {
					map.put(arr[k], map.get(arr[k])+(int)Math.pow(10, arr.length-1-k) );
				}
				
			}

		}
		
		Iterator<Character> it = map.keySet().iterator();
		
		int[] arr = new int[map.size()];
		int cnt = 0;
		while(it.hasNext()) {
			char temp = (char)it.next();
			arr[cnt] = map.get(temp);
			cnt++;
		}
		
		Arrays.sort(arr);
		System.out.println("Arr + "+Arrays.toString(arr));
		
		int sum =0;
		int pos = 9;
		for(int i =arr.length-1;i>=0;i--) {
			sum+=(arr[i]*pos);
			pos--;
		}
		
		System.out.println(sum);
		
	}
	
}
