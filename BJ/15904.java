
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int num =0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
	
		String str = sc.nextLine();
		String st = "UCPC";
		char[] arr = st.toCharArray();
			for(int i =0; i<arr.length;i++) {
			char ch = arr[i];
			str = check(ch,str);
		}
		System.out.println();
		System.out.println(num);
		if(num==4) {
			System.out.println("I love UCPC");
		}else {	
			System.out.println("I hate UCPC");
		}
		
	}

	private static String check(char ch, String str) {
		int pos= 0; 
		char[] arr=str.toCharArray();
		
		for(int i =0; i<arr.length;i++) {
			if(ch==arr[i]) {
				pos =i;
				num++;
				break;
			}
		}
		
		if( pos +1 == arr.length) {
			str = "XX";
		}else {
			str  = str.substring(pos+1);
		}
		System.out.println( str);
		return str;
	}
}
