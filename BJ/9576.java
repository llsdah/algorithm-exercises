
// 절반만 정답니다. 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int y = sc.nextInt();
		// 책이 권 있다.
		// 학부생  m 명 , 번호 2개 정렬 인데 ;
		
		for(int i =0; i<y;i++) {
			int n = sc.nextInt(); // 책 번호
			int m = sc.nextInt(); // 사람 번호 
			int[][] arr = new int[m][2];
			for(int k=0; k<m;k++) {
				arr[k][0]= sc.nextInt();
				arr[k][1]= sc.nextInt();
			}
			
			int num = book(n,m,arr);
			System.out.println(num);
		}
	
	}

	private static int book(int n, int m, int[][] arr) {

		
		// 끝에서 부터 정렬 하고 같은거는 앞으로 정렬 
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		int cnt = 0;// 학생수 카운트 
		boolean[] book = new boolean[n+1];// 책
		book[0]=true;
		for(int i =0; i<m;i++) {
			if(!book[arr[i][0]]) {
				book[arr[i][0]]=true;
				cnt++;
			}else {
				for(int k=arr[i][0];k<=arr[i][1];k++) {
					if(!book[k]) {
						book[k]=true;
						cnt++;
						break;
					}
				}
			}
			
			
		}
		
		return cnt;
	}
	
}
