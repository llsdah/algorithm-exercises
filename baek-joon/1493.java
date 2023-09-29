

//알듯 말듯 ..모르는 문제 
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		// 1원당 열량이 가장 높은 피짜
		// 토핑은 0~ 2 개까찌만. 
		Integer[] sq = new Integer[3];
		sq[0] = sc.nextInt();
		sq[1] = sc.nextInt();
		sq[2] = sc.nextInt();
		Arrays.sort(sq, Collections.reverseOrder());
		// 역순 정렬. 
		int n = sc.nextInt();
		int[][] arr = new int[3][2]; // 한변의 길이 , 갯수 
		for(int i =0; i<n;i++) {
			arr[i][0] = (int) Math.pow(2, sc.nextInt());
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o2[0]-o1[0];
			}
		});
		
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		int pos =1;
		for(int i =0;i<n;i++) {
			if(arr[i][0]>sq[pos]) continue;
			int cnt = 0; // 몇개 들어 갈 수 있냐면
			
			
		}
		
		
	}

}
