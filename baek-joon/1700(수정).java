public class Belady {

	static int N;// 콘센트
	static int K; // 꽂을꺼
	static int[] seq; // 순서 담기
	static List<Integer> inUse = new ArrayList<>(); // 현재 사용중인거

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		N = sc.nextInt(); // 콘센트 수
		K = sc.nextInt(); // 꽂을 거 수
		seq = new int[K]; // 순서
		for (int i = 0; i < K; i++) {
			seq[i] = sc.nextInt();
		}

		int ans = optimal();
		System.out.println(ans);
	}

	private static int optimal() {
		int cnt = 0; // 교체 수
		for (int i = 0; i < K; i++) {
			int cur = seq[i];
			if (inUse.contains(cur))
				continue; // 포함하고 있으면 넘어가
			if (inUse.size() == N) { // 콘센트에 꽉찼다면
				int pos = -1;// 변경할 꺼 위치 indext
				List<Integer> list = new ArrayList<>();
				for (int k = i + 1; k < K; k++) { // i번쨰꺼는 넣어야되기에
					// 다음꺼부터 기존에 있는 것들 중(사용하고 있는 것) 가장 나중에 사용하는거 찾기
					int next = seq[k];
					if (list.size() == N)
						break; // 찾았다.
					if (!inUse.contains(next))
						continue; // 포함하고 있지 않으면 넣어야되는거 다음 패스
					if (!list.contains(next))
						list.add(next);
					// 사용하고 있는데, 여기 리스트도 없으면 넣기
				}
				if (list.size() == N) { // 꽉차서 돌아온거면
					int last = list.get(list.size() - 1);// 가장 마지막에 사용된거 뽑아서 제거
					pos = inUse.indexOf(last);
				} else { // 꽉 안차면 사용 안하는게 있다는 의미이므로 그거 찾기
					for (int h = 0; h < N; h++) {
						if (list.contains(inUse.get(h)))
							continue; // 사용중 넘어가기
						pos = h;
						break;
					}
				}
				inUse.remove(pos);// 뺴기
				cnt++;// 뻇으니까 1개 증가
			}
			inUse.add(cur);
		}

		return cnt;
	}
}

/*
 2 10 
 2 3 2 3 1 3 7 2 5 2
 
 */



/*
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
*/
