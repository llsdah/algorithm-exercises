import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static int n=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		n = sc.nextInt();// 원판 갯수 
		String temp1 = sc.next();
		String temp2 = sc.next();
		char[] st = temp2.toCharArray();
		char[] on = temp1.toCharArray();
		char[] off = temp1.toCharArray();
		
		int one =1;// 전구를 꼈으니까!!
		int two=0;
		// 누르고 안누를 때 내가 i 번쨰 스위치를 누르면 i-1 번만 변경된다 생각 왜?
		// i 번쨰는 i+1 번쨰에서 누를 꺼기 때문에 !!!
		// 그래서 i-1번쨰를 기준으로 다르면 키고 같으면 그냥 두고를 반복한다.
		// 문제 읽기 중요 !! ㅠㅠ.. i-1 i i+1 스위치 누르면 3개의 전구 상태 변경.. 
		
		// 우선 1번의 경우만 다르기 떄문에 
		on[0] = on[0]=='1' ? '0' :'1';
		on[1] = on[1]=='1' ? '0' :'1';

		for(int i=1;i<n;i++) {
			// 첫번쨰 전구를 키는경우
			if(st[i-1]!=on[i-1]) {
				ch(i,on);				
				one++;
			}
			// 끄는경우 
			if(st[i-1]!=off[i-1]) {
				ch(i,off);
				two++;
			}
			
			
		}

		if(Arrays.equals(st, on)&&Arrays.equals(st, off))	System.out.println(Math.min(one,two));
		else if(Arrays.equals(st, on)) System.out.println(one);
		else if(Arrays.equals(st, off)) System.out.println(two);
		else System.out.println(-1);
	
		
	}
	
	// 전구 바꾸기 
	public static void ch(int pos,char[] arr) {
			arr[pos-1] = arr[pos-1]=='1' ? '0' :'1';
			arr[pos] = arr[pos]=='1' ? '0' :'1';
			if( pos==n-1) return;
			arr[pos+1] = arr[pos+1]=='1' ? '0' :'1';
			
	}
}


/*


	
*/

/*
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
	
*/
