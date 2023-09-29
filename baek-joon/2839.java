import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));
		
		int n = scan.nextInt();
		
		int five = n/5;
		int num = n%5;
    //하나씩 적어ㅓ가면서 풀어보기 
		if(five==0) {
			if(num ==3) System.out.println(1);
			else System.out.println(-1);
		}
		else if(n==7) System.out.println(-1);
		else if(num==0) System.out.println(five);
		else if(num==1) System.out.println(five-1 +2);
		else if(num==2) System.out.println(five-2+4);
		else if(num==3) System.out.println(five+1);
		else if(num==4) System.out.println(five-1+3);
		else System.out.println(-1);
	}	

}
