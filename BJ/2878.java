import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	//모든 국회의원박탈.
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[m];
		for(int i=0;i<m;i++) {
			arr[i] =sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = Math.abs(n - Arrays.stream(arr).sum());
		
		if(cnt<=1||cnt==m) {		
			System.out.println(cnt);
		}else {
			int[] nums = new int[m];
			int pos =0;
			while(cnt>0) {
				nums[pos]++;
				cnt--;
				pos++;
				if(pos==m) pos=0;
			}
			long sum =0;
			for(int i=0; i<m;i++) {
				sum+=Math.pow(nums[i], 2);
			}
			System.out.println(sum);
		}
		
		
		
		
	}
}
