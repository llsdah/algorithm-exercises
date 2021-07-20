
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	
	// 큐를 두개 나눈다 더하기랑 뺴기랑 따로 따로 넣는다. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 탭 해야댈 수 
		int[] cnt = new int[1002];
		int[] cur = new int[n];
		int[] st = new int[n];
		for(int i=0; i<n;i++) {
			cur[i]=sc.nextInt();
		}
		for(int i=0; i<n;i++) {
			st[i]=sc.nextInt();
		}

		for(int i=0; i<n;i++) {
			cnt[i]= st[i]-cur[i];
		}
		
		
		System.out.println(Arrays.toString(cnt));
		
		
		boolean flag = cnt[0]>=0 ? true :false;

		int ans=0;
		int pos= 0;
		int right =0;
		
		while(true) {
			System.out.println("ans : "+ ans +" pos : "+ pos +" rignt : "+ right );
			if(pos==n) break;
			
			int num = cnt[right];
			boolean check = num>=0 ?  true : false;				
			
			if(cnt[pos]==0) {
				System.out.println("cnt[pos]==0");
				pos++;
				right++;
				flag = cnt[pos]>=0? true :false;
			}else if(flag!= check||right==n||cnt[right]==0) {
				if(flag) {
					for(int i=pos;i<right;i++) {
						cnt[i]--;
					}
				}else {
					for(int i=pos;i<right;i++) {
						cnt[i]++;
					}
				}
				System.out.println("flag!= check||right==n||cnt[right]==0 "+flag+" "+Arrays.toString(cnt));
				right =pos;
				flag = cnt[pos] >=0 ? true:false;
				ans++;
			
			}else if(check ==flag) {
				System.out.println("check =flag");
				right++;
			}
			
			
		}
		
		
		System.out.println(ans);
	}
}
