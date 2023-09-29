public class 더하기사이클 {

	public static void main(String[] args) {
		
		int n = 26; 
		int cnt = 0;
		
		int start = n;
		int sum =0;
		do{
		
		sum = (start%10)+(start/10);
		start = 	(start%10)*10 +sum%10;

		cnt++;
		System.out.println(start);
		}while(start!=n);

		System.out.println(cnt);
	}
	
}
