
import java.util.HashMap;
import java.util.Stack;

public class A_Test {

	public static void main(String[] args) {
		
		// int m = 4;
		// int n = 5;
		// String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		int[][] n = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] tt = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		
		String sentense = "HaEaLaLaObWORLDb";

		boolean result = solution(n, tt);


		// long[] result = solution4(n,z,roads,queries);

		System.out.println("result : " + result);
		
	}

	public static boolean solution(int[][] key, int[][] lock) {

		// 자물쇠의 길이 key 길이 만큼 더하기 하하하하핳 
		int num = lock.length;
		
		
		int[][] arr = new int[58][58];		
		for(int r =0; r< lock.length;r++) {
			for(int c = 0; c<lock.length;c++) {
				
				arr[num+r][num+c] = lock[r][c];
				
			}
		} // 자물쇠 등록용
		
		for(int i=0; i<4;i++) {
			
			for(int r =0; r< num+lock.length;r++) {
				
				for(int c =0; c <num+lock.length;c++) {
					int[][] temp = arr;
					
					match(temp, num,key,r,c,i);
					
					if(check(temp,lock,num)) {
						return true;
					};
					
				}
				
			}// 자물쇠 일치 

		}// 회전
		
		
		

		return false;		
	}

	
	private static boolean check(int[][] temp, int[][] lock,int num) {

		
		for(int r=0;r<lock.length;r++) {
			
			for(int c=0; c<lock.length;c++ ) {
				
				if( temp[r+num][c+num]!=lock[r][c]) {
					return false;
				}
				
			}
		}
		
		return true;
	}

	// 회전하기 암기 합니다. 
	private static void match(int[][] temp, int num, int[][] key, int row, int col, int rotation) {

		
		for(int r =0; r<key.length;r++) {
			
			for(int c=0; c<key.length;c++) {
				
				if( rotation ==0) {
					temp[r+row][c+col]+=key[r][c];
				
				} else if(rotation ==1) { // 90 도 
					temp[r+row][c+col]+=key[key.length -1 - c ][r];
				
				}  else if(rotation ==2) { // 180 도 회전 
					temp[r+row][c+col]+=key[key.length -1 -r][key.length -1 -c];
					
				} else if(rotation ==3) {
					temp[r+row][c+col]+=key[c][key.length -1 -r];
				
				}
			
			}
			
		}
		
	} // match

}
/*

00 01 02
10 11 12
20 21 22 

20 10 00 
21 11 01
22 12 02 

22 21 20
12 11 10
02 01 00

02 12 22 
01 11 21
00 10 20


*/
