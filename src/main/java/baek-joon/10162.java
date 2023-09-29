public class Main {
	static int cnt;

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();
		int[] arr = { 300, 60, 10 };
		int[] cnt = new int[3];
		for (int i = 0; i < 3; i++) {
			if (n / arr[i] == 0) {
				continue;
			}
			int num = n / arr[i];
			n = n % arr[i];
			cnt[i] = num;
		}
		if(n>0) {
			System.out.println(-1);
		}else {
			for(int i=0; i<3;i++) {
				System.out.print(cnt[i]+" ");
			}
		}
		
	}
}
