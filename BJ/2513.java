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
		
		int[][] arr  = new int[n][2];
		// 왼쪽가는 경우 오늘쪽가는경우
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			int cnt =sc.nextInt();
			arr[i][0] = num; // 단지 위치 
			arr[i][1] = cnt; // 사람 수 			
		}
		
		// 정렬 
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		// 일단왼쪽에서 오른쪽 가는 경우
		int sum=0;
		
		int index =0;
		while(true) {
			int possi =total;// 탈 수 있는 가능 수 
			int left =0; // 이동거리
			for(int i=index; i<n;i++) {
				if(arr[i][0]>pos) break;// 학교 위치보다 크면 중단!
				if(possi==0) break;
				if(arr[i][1]>0) {
					if(possi>=arr[i][1]) {
						possi-=arr[i][1];
						arr[i][1]=0;
						left =Math.max(left, pos-arr[i][0]);
					}else {
						arr[i][1] -=possi;
						index=i;
						left =Math.max(left, pos-arr[i][0]);
						break;
					}
				}
			}
			if(left==0) break;
			sum+=(left*2);
		}
		
		index = n-1;
		//큰 쪽에서 오는 경우
		System.out.println("left : "+sum+" totol"+total);
		while(true) {
			int possi =total;// 탈 수 있는 가능 수 
			int right =0; // 이동거리
			for(int i=index; i>=0;i--) {
				if(arr[i][0]<pos) break;// 학교 위치보다 크면 중단!
				if(possi==0) break;
				System.out.println(i+" : "+Arrays.toString(arr[i])+possi);
				if(arr[i][1]>0) {
					if(possi>=arr[i][1]) {
						System.out.println(" possi가 더 큼 :"+i+" : "+Arrays.toString(arr[i])+possi);
						possi-=arr[i][1];
						arr[i][1]=0;
						right =Math.max(right,arr[i][0]-pos);
					}else {
						System.out.println(" possi가 작다 :"+i+" : "+Arrays.toString(arr[i])+possi);
						arr[i][1] -=possi;
						index=i;
						right =Math.max(right,arr[i][0]-pos);
						break;
					}
				}
			}
			if(right==0) break;
			System.out.println("right : "+right);
			sum+=(right*2);
		}
		

		System.out.println(sum);
	
	}
}

// 아래는 먼지 모르게 틀립.. 시간초과도 있음
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
