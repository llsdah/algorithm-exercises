public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n =sc.nextInt();
		long[][] arr = new long[n][2]; // +! 번째 마을의 위치 , 사람 수 
		long st =(int)1e9;
		long end =0;
		long ans = 0;
		
		for(int i=0; i<n;i++) {
			arr[i][0] =sc.nextLong();
			arr[i][1] =sc.nextLong();
			st = Math.min(st, arr[i][0]);
			end = Math.max(end, arr[i][0]);
			ans += ((arr[i][0]-1) *arr[i][1]); // 우선 0번 위치에 있다고 생각합니ㅏㄷ.
			
		}
		
		// 각 사람 까지의 거리의 합. 몇배가 되냐의 의미네 이분 탐생으로 할까?
		long mid =0;
		while(st<=end) {
			mid = (st+end)/2;
			long temp =0;
			for(int i=0;i<n;i++) {
				temp+= (  Math.abs((arr[i][0]-mid)) *arr[i][1]);
			}
			System.out.println(":"+ans+":"+mid+":"+temp);
			if( ans >temp) {
				st = mid+1;
				ans = temp;
			}else {
				end =mid-1;
			}
		}
		
		System.out.println(mid-1+" : "+ans);
		
	}
}
