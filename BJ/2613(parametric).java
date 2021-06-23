import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		//parametric Search  이분 탐색활요해 결정 문제 해겨 ㄹ
		int cnt =sc.nextInt(); // 구슬 수 
		int group = sc.nextInt(); // 그룹수 
		int[] bead = new int[cnt]; // 구슬 그룹 
		for(int i=0; i < cnt;i++) {
			bead[i] =sc.nextInt(); //marble
		}
		// 그룹의 합이 최소가 되도록 합니다. 
		
		int left =1; // 최소값
		int right = 100*cnt; // 최대 값
		int ans = (int)1e9; //최소합 출력용
		
		int[] answers =new int[301];// 최대 갯수만큼 있다. 가장정
		int ansSize = 1; // 최소 갯수 출력용 
		
		// 구슬 합의 범위 구슬 갯수 300 , 구슬 값 100 이하 최대합 30000이하 . 
		while(left<=right) {
			int mid = (left+right)/2;
			int sum =0;
			int cntGroup = 1;
			boolean flag = false;
			for( int i=0; i <cnt;i++) {
				if(bead[i]>mid) {
					left=mid+1;
					flag = true;
					break;
				}
				sum+=bead[i];
				if( sum>mid) {
					cntGroup++;
					sum=bead[i];
				}
				
			} //for
			if(cntGroup>group||flag) {
				left = mid+1;
			}else {
				right=(mid-1);
				
				if(mid<ans)ans=mid;
				
			}
		}// while

		System.out.println("ans : "+ans); // 최소합 출력
		int num =0;
		int sum =0;
		for(int i =0;i<cnt;i++) {
			sum+=bead[i];
			num++;
			if(sum>ans) {
				sum= bead[i];
				answers[ansSize]=num-1;
				ansSize++;
				num=1;
			}
		}
		
		answers[ansSize] =num;
		int diff = (group-ansSize);
		for(int i=1; i<=ansSize;i++) {
			if(answers[i]==1) System.out.print(answers[i]+" ");
			else {
				while(answers[i]>=2&&diff>=1) {
					System.out.print("1 ");
					answers[i]--;
					diff--;
				}
				System.out.print(answers[i]+ " ");
			}
		}
		
		
	}
}

