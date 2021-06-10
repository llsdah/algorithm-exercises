package backJun;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
	 
		String str = sc.nextLine();
		String st = sc.nextLine();
		int num_str = str.length();
		int num_st = st.length();
		int cnt=0;
		
		for(int i=0;i<num_str;i++) {
			String temp = "";		
			if(i+num_st>=num_str) {
				temp = str.substring(i);				
			}else {
				temp = str.substring(i,i+num_st);		
				
			}
			
			if( temp.equals(st)) {
				cnt++;
				i =i+num_st-1;
			}
			
		}

		System.out.println(cnt);
	}
}

