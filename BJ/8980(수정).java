package backJun;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static int num =0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int city = sc.nextInt(); // 마지막 시티 .
		int cargo = sc.nextInt(); // 최대 값
		
		int n = sc.nextInt();
		int[][] arr = new int[n][3];
		
		for(int i =0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
			arr[i][2] =sc.nextInt();
		}
		int total =0; // 운반 수 
		int now =0; // 현재 담는 수 
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=1; i<=city;i++) {
			map.put(i, 0);
		}
		
		// 정렬하기 마을 순서, 마을 순서 오름 차준 
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				
				return o1[0]-o2[0];
			}
			
		});
		System.out.println();
		for(int i =0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
		// 맥스로 계속 더하기 
		// 맵에 각 마을 담기  배송 담기 
		for(int i=0;i<n;i++) {
			if(map.get(arr[i][0])!=0) { // 현재 마을에서 내릴 물건이 0이 아니면
				now += - map.get(arr[i][0]); // 물건 내리고 
				total += map.get(arr[i][0]);// 운송 수량 하핳 
				System.out.println("totalc "+total+" 변경 값 "+now +" 배열 "+Arrays.toString(arr[i]));
				map.put(arr[i][0],0);// 다 내렸으니 현재 0 으로 한다. 
			}
			int max =cargo - now  ; // 몇개 까지 실을 수 있나 .  최대 수량 - 현재 실은 수량
			max = Math.min(max, arr[i][2]);
			if( max !=0) { // 아직 실을 수 있다.
				now += max; // 실었으니 최대 값 더하기 
				System.out.println(i+"<-I "+now);
				map.put(arr[i][1],map.get(arr[i][1])+max);// 마을로 배송할 운반 수량 
			}
			// 0 이면 지나가기 
		
		}
		
		System.out.println();
		System.out.println(cargo +" toatl "+total);
		
		total += map.get(city);// 마지막장소에 얼마나 갔을까.
		System.out.println(total);
		
	}
}




/*


*/
