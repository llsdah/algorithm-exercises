import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		String str = sc.next();
		
		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		String a = "AAAA";
		String b = "BB";
		
		boolean flag= true; // 잘못되면 
		int cnt = 0;
		for(int i=0; i<arr.length;i++) {
		
			if(arr[i]=='X') {
				cnt++;
			} else {
				if(cnt==3||cnt==1) {
					flag = false;
					break;
				}else if( cnt==2) {
					sb.append(b);
					cnt=0;
				}
				sb.append(".");
			}
			
			if(cnt==4) {
				sb.append(a);
				cnt=0;
			}
			
			
		}
		if(cnt==2) sb.append(b);
		
		
		
		if(flag) System.out.println(sb.toString());
		else 	System.out.println(-1);
		
		
	}

}
