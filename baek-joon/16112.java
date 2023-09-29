import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int N =sc.nextInt();
		int K =sc.nextInt();
		
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);// 우선 0정렬 
		
		int cnt = 0;
		int ans =0;// 최대 경험치
		for(int i=0; i<N;i++) {
			if(cnt<K) {
				cnt++;
				ans-=arr[i];// 경험치 0사라집니다. 최대가 0아니니까
			}
			ans+=(arr[i]*cnt);
			// 활성화된 아케인 0스톤
		}
		
		System.out.println(ans);
	}
}
