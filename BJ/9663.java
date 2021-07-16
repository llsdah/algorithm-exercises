import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int cnt=0;
	static int[] arr;
	static int N;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		
		int n = sc.nextInt();// 체스판 크기 
		N=n;
		arr = new int[n];// 열이 index  = 안에 입력된 값이 행 위치ㅣ
		
		nq(0);
		System.out.println(cnt);
	}
	
	private static void nq(int dep) {
		
			if(dep == N) { // 모든 원소 다 채운 것입니다. 그럼 증가 종료
				cnt++;
				return;
			}
		
			for(int i=0; i<N;i++) { // for문이라 전체 다 입력될 겁니다. 
				arr[dep] =i;//입력될 행위치 입력 
				if(check(dep)) nq(dep+1);//만약 넣을 수 있다면 !! 증가 시킵니다 
			}
			
		
	}

	private static boolean check(int pos) {
		for(int i=0;i<pos;i++) { //해당 열의 위치 
			if(arr[pos]==arr[i]) return false; // 같은 행에 존재 하면 안됩니다.
			else if(Math.abs(pos-i)==Math.abs(arr[pos]-arr[i])) return false;
			//해당 식은 대각선일 경우 그 차이가 같습니다. 
		}
		
		return true;
	}
}
