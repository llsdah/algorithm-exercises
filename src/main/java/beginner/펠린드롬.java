public class 팰린드롬 {
	public static void main(String[] args) {
		// 가운데를 기준으로 대칭
		
		String n = "1243321";
		
		int len = n.length();
		boolean flag = true;
		
		// 중간 까지 
		for( int i =0; i<len/2 ;i++) {
			
			
			if( n.charAt(i)!= n.charAt(len-i-1)) {
				flag =false;
			}
			
		}
		
		System.out.println(flag);
		
	}
}
