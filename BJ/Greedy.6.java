public class Main {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		String word = scan.next();
		
		char[] arr = word.toCharArray();
		
		int one =0;
		int zero=0;
		char num = arr[0];
		
		if(arr[0]=='0') {
			zero++;
		}else {
			one++;
		}
		for(int i =1; i< arr.length;i++) {
			
			
			if(num!=arr[i]) {
				if(arr[i]=='0') {
					zero++;
				}else {
					one++;
				}
				num=arr[i];
			}
			
		}
		int answer = zero >one ? one :zero;
		System.out.println(answer);
	}
}
