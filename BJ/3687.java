



// 반복할 필요없이 값을 dp로 저장후 출력하자 
public class Main {

	static HashMap<Integer, String> min = new HashMap<>();
	static HashMap<Integer, String> max = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();// 원판 갯수 

		min.put(2, "1");
		min.put(5, "2");
		min.put(4, "4");
		min.put(6, "0"); // 단 시작이 6이면 6 ;
		min.put(3, "7");
		min.put(7, "8");

		
		// 갯수를 넣으면 숫자가 나오게 
		long[][] arr = new long[n][2];
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			arr[i][0] = min(num);
			arr[i][1] =max(num);
		}
		
		// 최
		
	}
	private static long max(int num) {
		StringBuilder sb = new StringBuilder();
		if(num%2==1) {
			num-=3;
			sb.append(7);
			
		}
		
		while(num>0) {
			num-=2;
			sb.append(1);
		}
		return Long.valueOf(sb.toString());
	}
	
	private static long min(int num) {
		if(num==6) return 6;
		
		
		return 0;
	}
}


/*


	
*/
