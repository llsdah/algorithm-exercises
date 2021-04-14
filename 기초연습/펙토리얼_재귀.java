public class 팩토리얼_재귀 {

	public static void main(String[] args) {
		
		
		int input = 0;
		Scanner scan = new Scanner(System.in);
		
		input = scan.nextInt();
		int ans =0;
		 
		
		ans = calFact(input);
		
		System.out.println(ans);
	}
	
	public static int calFact(int c) {
		
		if(c==1) {
			return 1;
		}
		
		return c* calFact(c-1);
	}
	
}
