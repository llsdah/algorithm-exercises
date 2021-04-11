// 백준 문제 2908
public class 상수 {

	public static void main(String[] args) {
		
		
		
		
		int num1 = 843;
		int num2 = 734;
		
		int[] arr1 = new int[3];
		int[] arr2 = new int[3];
		
		int lenA =0;
		int lenB =0;
		do {
			arr1[lenA] =num1%10;
			num1/= 10;
			lenA++;
			
		}while(num1>0);

		int tranA =0;
		int mux = 1; //1_>10->100 
		
		
		
		for(int i =arr1.length-1;i>=0;i--) {
			tranA += arr1[i] *mux;
			mux*=10;
		}
		
		System.out.println(tranA);
		
	}
	
	//내코드
	private void alone() {
		int num1 = 843;
		int num2 = 734;
		
		String st1 = num1+"";
		String st2 = num2+"";
		
		int[] arr1 = new int[st1.length()];
		int[] arr2 = new int[st2.length()];
		
		int lenA =0;
		int lenB =0;
		do {
			arr1[lenA] =num1%10;
			num1/= 10;
			lenA++;
			
		}while(num1>0);

		do {
			arr2[lenB] =num2%10;
			num2/= 10;
			lenB++;
			
		}while(num2>0);
		
		
		int ch1 =0;
		int ch2 =0;
		
		for(int i =0; i<arr1.length;i++) {
			ch1+= arr1[i]*Math.pow(10, arr1.length-i-1);
		}
		for(int i =0; i<arr2.length;i++) {
			ch2+= arr2[i]*Math.pow(10, arr2.length-i-1);
		}
		
		System.out.println(ch1>ch2 ? ch1: ch2 );
	
	}
	
}
