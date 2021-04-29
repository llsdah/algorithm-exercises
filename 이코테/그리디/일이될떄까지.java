package 이코테.Greedy;

public class 일이될때까지 {

	public static void main(String[] args) {
		
		long 시작 = System.nanoTime();

		
		// 나누는 작업이 더 수를 빠르게 줄일 수 있다. 
		
		
		
		
		
		int num = 25; // 주어진수 
		int div = 3; // 나누려는 수 
		int count = 0;
	
		// 예시 
		
		while(true) {
			int target = (num/div)*div;
			
			count += (num-target);
			num= target;
			
			if( num <div) {
				break;
			}
			count++;
			num/=div;
			
		}
		count+=(num-1);
		System.out.println(count);
		// 내가푼 푼이 2
		/*
		while( num != 1) {
			
			if(num%div!=0) {
				num--;
				count++;
			}else {
				num= num/div;
				count++;
				
			}
			
		}
		
		//1
		while(num!=1) {
			
			if( num>=div) {
				num = num%div +num/div;
				count++;
			}else {
				num--;
				count++;
			}
			
		}
	*/
		System.out.println(count);
		
		long 종료 = System.nanoTime();
		
		System.out.println("시잔 : " + (종료 - 시작));
	}
}
