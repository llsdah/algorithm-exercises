import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		String one = sc.nextLine();
		String two = sc.nextLine();
		
		//문자 ㅜ디집기 
		char[] arr = two.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length;i++) {
			sb.append(arr[i]);
		}
		// 반대로 거꾸로 돌아가자 그래야댐 
		while(sb.length() >one.length()) {
			if(sb.charAt(sb.length()-1)=='A') {
				sb.deleteCharAt(sb.length()-1);		
			}else {
				sb.deleteCharAt(sb.length()-1);
				sb.reverse();
			}
			
		}
		int num =0;
		if(one.equals(sb.toString())) {
			num =1;
		}
		
		System.out.println(num);
		
		
	}

}


/* 시간 초관 분 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		String one = sc.nextLine();
		String two = sc.nextLine();
		
		int num =0;
		//문자 ㅜ디집기
		if(two.equals(one)||check(ch(one)+"B",two)||check(one+"A",two)){
			num =1;
		}
		System.out.println(num);
		
	}
	private static boolean check(String str,String two) {
		if(str.length()>two.length()) return false;
		if(str.equals(two)) return true;
		boolean flag =false;
		if(check(ch(str)+"B",two)||check(str+"A",two)){
			flag =true;
		}
		
		
		
		return  flag;
	}
	private static String ch(String one) {
		StringBuilder sb = new StringBuilder();
		char[] arr = one.toCharArray();
		for(int i=0; i<arr.length;i++) {
			sb.append(arr[i]);
		}
		return sb.reverse().toString();
	}

}

*/
