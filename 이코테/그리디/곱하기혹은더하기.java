
public class 곱하기혹은더하기 {

	public static void main(String[] args) {

		long 시작 = System.nanoTime();

		// 가장큰수 무로건 왼쪽 부터 연산
		// 정수 데이터 21억까지 가능랃 

		String nums = "567";
		
		long result = nums.charAt(0)-'0';
		for(int i =1; i<nums.length();i++) {
			int num =nums.charAt(i)-'0';
			// 두수중 하나라도 0이거나 1이면 더하는 것이 좋다. 
			if(num <=1 || result<=1) {
				result +=num;
			}else {
				result *=num;
			}
		}
		
		
		
		
		// 나의 답 ( 1일 경우 생가을 못했다. ) ...
		char[] arr = nums.toCharArray();
		int sum = (int)(arr[0]-'0');
		for (int i = 1; i<arr.length; i++) {

			if(i==1&&(int)(arr[0]-'0')==0) {
				sum+=(int)(arr[i]-'0');
				continue;
			}
			if( arr[i]==0){
				sum+=(int)(arr[i]-'0');
			}else {
				sum*=(int)(arr[i]-'0');
			}
			
		}

		long 종료 = System.nanoTime();

		System.out.println(sum);
		System.out.println("시잔 : " + (종료 - 시작));
	}
}
