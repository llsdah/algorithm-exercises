public class 거스름돈 {

	public static void main(String[] args) {
		
		// 가장 작은 동전의 갯수로 거스름돈 주기 
		
		
		int[] arr = {500,100,50,10};
		
		int balance =1110;
		int count =0;
		for(int i =0;i<arr.length;i++) {
			
			count += balance/arr[i];
			
			//balance -= (arr[i] *(balance/arr[i]));
			balance = balance%arr[i];
			if(balance==0) {
				break;
			}
		}
		
		System.out.println("몇번? : "+count);
		
	}
}
