import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt(); // 총 칸의수
		int m =sc.nextInt();// 바구니 크기 
		int num =sc.nextInt();// 사과 수 
		
		int left =1;
		int right =m; // 끝자리 
		int cnt =0;
		for(int i=0; i< num;i++) {
			int pos = sc.nextInt();
			if(left<=pos&&pos<=right) continue;
			if(left> pos) {
				cnt+=(left-pos); // 이만큼 이동해야됨
				right += -(left-pos);
				left= pos;
			} else {
				cnt += (pos-right);
				left += (pos -right);
				right = pos;
			}
		}
		System.out.println(cnt);
	}
}


/* 틀림..
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int pos =1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt(); // 총 칸의수
		int m =sc.nextInt();// 바구니 크기 
		int num =sc.nextInt();// 사과 수 
		
		int cnt =0;
		for(int i=0; i< num;i++) {
			int  apple = sc.nextInt();
			cnt += ch(n,m,apple);
			//System.out.println( "pos  : "+pos);
			
		}
		System.out.println();
		System.out.println(n+" "+m+" "+num);
		System.out.println(cnt);

	}

	static boolean flag =false;
	private static int ch(int n, int m, int apple) {
		int cnt =0;
		while(true) {
			if( n<=pos+m-1) flag =true;// 만나고 계산
			else if(pos+m-1<=0) flag=false;
			
			if( pos+m-1>=apple && apple>=pos) break;

			if(flag)	pos--;
			else pos++;
			
			System.out.println("apple : "+apple +" pos : "+pos);
			cnt++;
		}
		System.out.println("cnt : "+ cnt);
		return cnt;
	}
	
}
*/
