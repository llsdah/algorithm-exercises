public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		String str = sc.next();
		
		char[] arr =str.toCharArray();
		
		char st = 'A';
		int time=0;
		for(int i=0; i<arr.length;i++) {
			char temp =arr[i];
			int cnt = Math.abs(temp-st);
			time+=Math.min(cnt, 26-cnt);
			st = temp;
		}
		
		System.out.println(time);
	}
}
