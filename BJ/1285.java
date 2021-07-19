import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 원판 갯수
		boolean[][] arr = new boolean[n][n]; // T= true
		for(int i =0; i<n;i++) {
			String temp = sc.next();
			char[] ch = temp.toCharArray();
			for(int k =0; k<ch.length;k++) {
				if(ch[k]=='T') arr[i][k]= true;
			}
		}
		int cnt = (int)1e9;// 최소값 
		
		// 행 뒤집는 여부 = 비트 마스크 
		for(int i=0; i<(1<<n);i++) {// 총 경우의 수 2^N
			int sum =0;// 더랗 것 
			for(int k =0; k<n;k++) {
				int num =0; // 끝부분?
				for(int h=0; h<n;h++) {
					boolean flag = arr[k][h];
					if( (i&(1<<h))!=0) flag = !flag; // 다르니 뒤집은 열을
					if(flag) num++;
				}
				sum+=Math.min(num, n-num);
			}
			cnt = Math.min(sum, cnt);
		}
	
		System.out.println(cnt);
	}

}
