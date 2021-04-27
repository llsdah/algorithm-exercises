package backJun;

import java.io.InputStreamReader;
import java.util.Scanner;

public class B_test {

	public static void main(String[] args) {
		
	
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		
		
		String temp = scan.next();
		
		char[] arr = temp.toCharArray();
		String test= "";
		int index = -1;
		
		
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<temp.length();i++) {
			if(arr[i]>='0'&&arr[i]<='9') {
				sb.append(arr[i]);
			}else if( arr[i]=='+' &&index==-1) {
				test += sb.toString();
				sb.delete(0, sb.length());
				sb.append(',');
				sb.append('+');
				sb.append(',');
				
			}else {
				test += sb.toString();
				sb.delete(0, sb.length());
				sb.append(',');
				sb.append('-');
				sb.append(',');
				
				index =0;
			}
			
			
		}
		test+=sb.toString();
		String[] str = test.split(",");
		int num = Integer.parseInt(str[0]);
		for(int i =1;i<str.length-1;i++) {
			
			if(str[i].equals("+")) {
				num += Integer.parseInt(str[i+1]);
			} else if ( str[i].equals("-")) {
				num -= Integer.parseInt(str[i+1]);
			}
			
			
		}
		
		System.out.println(num);
	}
	
}
