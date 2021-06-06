import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	static HashMap<Integer,Boolean> check;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt(); // 콘센트 수 
		int m = sc.nextInt(); // 꽂을 거 수 
		
		int[] concent = new int[n];// 콘센트
		int[] arr = new int[m];// 순서 저장
		
		HashMap<Integer,Integer> map = new HashMap<>(); 
		map.put(-1,9999);
		// 해당 번호가 몇번 나왔는지 
		for(int i =0; i<m;i++) {
			int num = sc.nextInt();
			arr[i] =num; 
			if(map.getOrDefault(num, 0)==0) {
				map.put(num, 1);
			}else {
				map.put(num,map.get(num)+1);
			}
		}
		check = new HashMap<>();
		// 시작은 그냥 꼽기
		for(int i =0; i< n;i++) {
			int num = arr[i];
			concent[i] = num;
			check.put(num,true);
			map.put(num,map.get(num)-1);
		}
		
		int cnt =0; //뺸수 체크
		for(int i=n;i<m;i++) {
			int num = arr[i]; // 꼽아야될것 
			if(check.getOrDefault(num, false)==true) {
				// 기존에 꼽혀 있으니까 그대로 유지
				map.put(num,map.get(num)-1);
				continue; 
			};
			// 콘센트에서 뺄떄 false 변경 주의 !
			// 최소값 이 꽂힌 콘센트 위치 찾기
			int pos = pos(concent,map);
			
			// 기존 콘센트 뺴기 전에 flase 변경
			check.put(concent[pos], false);
			cnt++; //뺴고
			concent[pos] = num; // 해당 위치에 꽃기
			check.put(concent[pos], true);// 표시
			map.put(concent[pos],map.get(concent[pos])-1);
			
		}
		System.out.println(cnt);
	}
	// 최소값 콘센트 번호 찾기 
	private static int pos(int[] concent, HashMap<Integer, Integer> map) {
		int number =-1; // 기존에 최대 값을 저장되어 있던것
		// 콘센트 넘버 // 콘센트 넘버 몇번째 꺼 
		// 최소값 콘센트 번호 찾기 
		
		
		// 최소값 이 꽂힌 콘센트 위치 찾기 
		int pos = -1;
		for(int i=0; i<concent.length;i++) {
			if(map.get(number)>map.get(concent[i])) {
				number = concent[i];
				pos =i;
			}
		}
		
		return pos;
	}
}
