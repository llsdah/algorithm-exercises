import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 탭 해야댈 수 
		int[] tree =new int[n];
		for(int i=0;i<n;i++) {
			tree[i]=sc.nextInt()%3;// 최대가 3이니까.
		}
		int sum=0;
		int odd =0;
		for(int i=0;i<n;i++) {
			sum+=tree[i];
			if(tree[i]%2==1) odd++;
		}
		
		if(sum%3==0&&odd<=sum/3 ) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
		
		// 물뿌리개 +1 ? +2
		
		
		
	}
}
// 수학 식 재정의
public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 탭 해야댈 수 
		int[] tree =new int[n];
		for(int i=0;i<n;i++) {
			tree[i]=sc.nextInt()%3;// 최대가 3이니까.
		}
		System.out.println(Arrays.toString(tree));
		boolean flag =false;
		if(n==1&&(tree[0]==1||tree[0]==2||tree[0]==3)) {
			flag=true;
		}else if(n==2) {
			if((tree[0]==1&&tree[1]==2)||(tree[0]==2&&tree[1]==1)) {
				flag=true;
			}
		}
		
		long one = Arrays.stream(tree).filter(i->i==1).count();
		long two = Arrays.stream(tree).filter(i->i==2).count();
		
		if( n%2==0&&one==two) {
			flag =true;			
		}else if(n%2==1&&(one==n||two==n)) {
			flag=true;
		}
		
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
		
		// 물뿌리개 +1 ? +2
		
		
		
	}
}
