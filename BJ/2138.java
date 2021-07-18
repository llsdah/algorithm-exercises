package backJun;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();// 원판 갯수 
		String temp1 = sc.next();
		String temp2 = sc.next();
		char[] st = temp1.toCharArray();
		char[] ch = temp2.toCharArray();
		
		// 누르고 안누를 때 내가 i 번쨰 스위치를 누르면 i-1 번만 변경된다 생각 왜?
		// i 번쨰는 i+1 번쨰에서 누를 꺼기 때문에 !!!
		int cnt = 0;
		int index =0; // 최대가 n까지 
		if(Arrays.equals(st, ch) ) {
			System.out.println("굿");
		}
		while(true) {
			if(Arrays.equals(st, ch) ) {
				break;
			}
			for(int i=index;i<n;i++) {
				if(st[i]!=ch[i]) {
					index=i;
					break;
				}
			}
			ch(index,st);
			index++;
			if(index==n) index=0;
			System.out.println(index+Arrays.toString(st));
			cnt++;
			if(cnt==5) break;
		}
		System.out.println(cnt);
	}
	
	// 전구 바꾸기 
	public static void ch(int pos,char[] arr) {
		if(pos==0) {
			arr[pos+1] = arr[pos+1]=='1' ? '0' :'1';
			arr[pos] = arr[pos]=='1' ? '0' :'1';
		}else {
			arr[pos-1] = arr[pos-1]=='1' ? '0' :'1';
			arr[pos] = arr[pos]=='1' ? '0' :'1';
		}
		
		
	}
}


/*


	
*/
