import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();// 아파트 단지 수 
		int total = sc.nextInt(); //최대 인원
		int pos =sc.nextInt();//학교 위치
		
		int[] arr  = new int[10001];
		// 왼쪽가는 경우 오늘쪽가는경우
		int max =0;// 단지의 max 값
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			int cnt =sc.nextInt();
			arr[num]=cnt;
			max = Math.max(max, num);
		}
		
		int sum =0;
		//좌로 가는경우 우로가는경우 두가지 
		while(true) {
			int possi=total;
			int cnt =0;// 중심에서 거리
			int cur =0;
			for(int i=0;i<pos;i++) {
				
				if(arr[i]>0) {
					cur=Math.max(pos-i, cur); //어디서 태웠나
					if(arr[i]<=possi) {
						possi -=arr[i];
						arr[i]=0;
					}else {
						arr[i] -=possi;
						possi=0;
					}
				}
				
			}
			if(cur==0)break;
			sum +=(cur*2);
		}
		//우에서 반대로 시작
		while(true) {
			int possi=total;
			int cnt =0;// 중심에서 거리
			int cur =0;
			for(int i=max;i>pos;i--) {
				
				if(arr[i]>0) {
					cur=Math.max(i-pos, cur); //어디서 태웠나
					if(arr[i]<=possi) {
						possi -=arr[i];
						arr[i]=0;
					}else {
						arr[i] -=possi;
						possi=0;
					}
				}
				
			}
			
			if(cur==0)break;
			sum +=(cur*2);
		}
		
		System.out.println(sum);
	}
}
