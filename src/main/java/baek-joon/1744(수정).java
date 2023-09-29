public class Main {

	static int plus =0;
	static int minus = 0;
	static boolean flag =false;
	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		
			int a = scan.nextInt();
			int[] num = new int[a];
			for(int i =0; i< a;i++) {
				num[i] = scan.nextInt();				
			}
			flag = (int)Arrays.stream(num).filter(i-> i==0).count() ==1 ? true : false; 
			
			int pl = (int)Arrays.stream(num).filter(i-> i>0).count();
			int mi = (int)Arrays.stream(num).filter(i-> i<=0).count();
			int total = 0;
			if(pl >0) {
				int[] arr  = Arrays.stream(num).filter(i-> i>0).toArray();
				total += count(arr);
			} 
			if( mi>0) {
				int[] arr  = Arrays.stream(num).filter(i-> i<=0).toArray();
				total += count(arr);
			}
			if(!flag&&minus<0) {
				total+=plus;
				total+=minus;
			}else {
				total+=plus;
			}
			
			System.out.println(total);
	}
	

	private static int count(int[] arr) {
		Arrays.sort(arr);
		int num =0;
		for(int i=arr.length-1 ;i>=1;i=i-2) {
			if(arr[i-1]==1) {
				num+=arr[i]+1;
				continue;
			}
			num+=(arr[i]*arr[i-1]);
		}
		if(arr.length%2==1) {
			if(arr[0]>=0) {
				plus =arr[0];
			}else if ( arr[0] < 0) {
				minus =arr[0];
			}
		}
		
		return num;
	}

} // 위에 내껀데.. 흠.. 어디가 잘못되었을까..

/*
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scan.nextInt();
		}
		Arrays.sort(num);
		int ans =0;
		// 음수
		for(int i=0;i<n;i++) {
			if(num[i]<=0) {
				if(i==n-1) {
					ans+=num[i];
				}else if(num[i+1]<=0) {
					ans+=(num[i]*num[i+1]);
					i++;
				}else {
					ans+=num[i];
				}
			}else {
				break;
			}
		}
		
		
		//양수 더하기 1 주의 
		for(int i=n-1;i>=0;i--) {
			if(num[i]>0) {
				if(i==0) {
					ans+=num[i];
				}else if(num[i-1]>1) {
					ans+=(num[i]*num[i-1]);
					i--;
				}else {
					ans+=num[i];
				}
			}else {
				break;
			}
		}
		
		System.out.println(ans);
	}

}
*/
