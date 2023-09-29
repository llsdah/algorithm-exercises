import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		// 사무실 하나 임대 , 빅뱅 위대 사무실의 번호도되도록이면 커야 한다고 생각
		// 지금 가지고있는 돈 전무를 가지고 방 번호를 만드ㅕ고 한다. 
		// 1층에 문방구에 ㅜㅅ자를 판대 
		// 각 숫자의 가격은 서로 다를 수 있지만. 현재 가지고 있는 돈을 이용해 만들 수 
		// 있는 갖ㅇ 큰 숫자를 만드려고 한다. 
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][2];
		for(int i=0; i<n;i++) {
			arr[i][0] = i;
			arr[i][1] = sc.nextInt();
		}
		int money = sc.nextInt(); // 최대 돈. 
		
		// 1. 돈이 가장 적게 드는 순으로 정렬 한다. 
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o2[0]-o1[0];
				return o1[1]-o2[1];
			}
		});
		// arr[0] 이 비용이 가장 작지만 가장 큰수 입니다. 
		
		char[] digit = new char[101];// 100자리 저도?
	
		int pos = 0; //위치에 값 저장요
		int temp =money;
		while(temp >=arr[0][1]) {
			digit[pos]= (char)(arr[0][0]+'0');
			pos++;
			temp -=arr[0][1];
		} // 가장 작은 수로 만들수 있는 최대의 자릿 수 

		int st = 0;// 해병의 시작위채
		for(int i =0 ; i<pos;i++) { // 초즈가 해당 위치 입니다.
			for(int k=n-1;k>=0;k--) { // 최대 부터 돌면서 해당 값 변경하기 
				if(arr[k][1]<= temp +arr[0][1]) {
					digit[i] = (char)(k+'0');
					temp +=(arr[0][1]-arr[k][1]);
					break;// 변경 했으면  중단
				}
				
			}
			
			if(digit[st]=='0') {;// 만약 시작이 0 이면 돌 돌려주고 다름 작은 것중에 큰값 찾기 
				st++;
				temp +=arr[0][1];
			}
			
		}
		
		
		if(st ==pos) System.out.println(0);
		else {
			String ans = "";
			for(int i =st;i<pos;i++) {
				ans+=digit[i];
			}
			System.out.println(ans);
		}
		
		
	}
	
}
