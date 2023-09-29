import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static long M = 0;
    static int result =-1; 
	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		long N = scan.nextLong(); // 시작 값
		M = scan.nextLong(); // 도달해야되는 값 

		dfs(N,0);
		System.out.println(result);
	}
	private static void dfs(long N,int cnt) {
	    if(N > M) return;
        if( N==M){
            result = cnt+1; // 1더해서 출력 
            return;
        }
        dfs(N*10+1,cnt+1);
        dfs(N*2,cnt+1);
	}
	
}

/*

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	
	static long st = 0;
	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		long N = scan.nextLong(); // 시작 값
		long M = scan.nextLong(); // 도달해야되는 값 

		st =M;
		long result = dfs(N,M,0);
		
		if(result > M) result =-1;
		else result++;
		System.out.println(result);
	}
	private static long dfs(long N,long M,int cnt) {
		if( N>=M) {
			if(N==M) {
				return cnt;
			}else {
				return (int)1e9;
			}
		}
		
		return Math.min( (int)1e9 , Math.min(dfs((N*10)+1,M,cnt+1),  dfs(N*2 , M , cnt+1))); 
		
	}
	
}

*/
