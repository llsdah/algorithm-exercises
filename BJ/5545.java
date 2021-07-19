import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		// 1원당 열량이 가장 높은 피짜
		// 토핑은 0~ 2 개까찌만. 
		int n = sc.nextInt();
		int[] price = new int[2];// 도우 + 토핑
		price[0] =sc.nextInt();
		price[1] =sc.nextInt();
		
		int dough = sc.nextInt();// 도우 열량
		
		int[] topping = new int[n];
		for(int i=0;i<n;i++) {
			topping[i] =sc.nextInt();
		}
	
		Arrays.sort(topping);// 정렬 
		System.out.println();
		int ans = dough /price[0]; // 현재 도우만 있을떄
		int total = price[0];
		int calorie = dough;
		for(int i =n-1;i>=0;i--) {
			int temp = (calorie+topping[i])/(total+price[1]);
			System.out.println(ans +" "+temp);
			if( ans<=temp) {
				total = total+price[1];
				calorie = calorie + topping[i];
				ans= temp;
			}
		}
		
		System.out.println();
		System.out.println(ans);
	
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
		
		// 1원당 열량이 가장 높은 피짜
		// 토핑은 0~ 2 개까찌만. 
		int n = sc.nextInt();
		int[] price = new int[2];// 도우 + 토핑
		price[0] =sc.nextInt();
		price[1] =sc.nextInt();
		
		int dough = sc.nextInt();// 도우 열량
		
		int[] topping = new int[n];
		for(int i=0;i<n;i++) {
			topping[i] =sc.nextInt();
		}
	
		Arrays.sort(topping);// 정렬 
		
		int calorie1 = dough /price[0]; // 현재 도우만 있을떄 
		if(n>2) {
			int calorie2 = (dough+topping[n-1])/(price[0]+price[1]); // 현재 도우만 있을떄 
			int calorie3 = (dough+topping[n-1]+topping[n-2])/
					(price[0]+price[1]+price[1]) ; // 현재 도우만 있을떄 
			calorie1 = Math.max(calorie1, Math.max(calorie2, calorie3));
			
		}else if( n==1) {
			int calorie2 = (dough+topping[n-1])/(price[0]+price[1]); // 현재 도우만 있을떄 			
			calorie1 = Math.max(calorie1, calorie2);
		}
		
		
		System.out.println(calorie1);
		
	}

}

*/
