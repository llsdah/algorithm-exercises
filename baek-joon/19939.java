
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 박의 갯수 
		int m = sc.nextInt();
		int[] arr =new int[m];


		int pos =0;
		
		while(n>0) {
			arr[pos] = ++pos;
			n-=pos;
			if(pos==m) break;
		}
		
		if(n<0) System.out.println(-1);
		else { // n 이 남은 경우 큰 순서대로 정리 하면됨
			pos--;
			while(true) {
				if(n<=0) break;
				arr[pos]++;
				n--;
				pos--;
				if(pos<0) pos = m-1;
			}
			System.out.println(arr[m-1]-arr[0]);
		}
		
		
	}

}
/*
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 원판 갯수
		int m = sc.nextInt();
		int[] arr =new int[m];


		int pos =0;
		
		while(n>0) {
			arr[pos] = ++pos;
			n-=pos;
			if(pos==m) break;
		}
		
		if(n<0) System.out.println(-1);
		else System.out.println(arr[m-1]-arr[0]);
		
		
	}

}

*/
