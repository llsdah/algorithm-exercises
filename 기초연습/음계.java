public class 음계 {

	public static void distincion(int input[]) {
		
		boolean flag = true;
		boolean flag2 = true;
		
		if(input[0]!= 1) {
			flag =false;
		}
		
		for( int i =1;i<input.length-1;i++) {
			if(input[i]-input[i+1]!=-1) {
				flag =false;
				break;
			}
		}
		
		if(input[0]!= 8) {
			flag2 =false;
		}
		
		for( int i =1;i<input.length-1;i++) {
			if(input[i]-input[i+1]!=-1) {
				flag2 =false;
				break;
			}
		}
		
		if(flag) {
			System.out.println("오름차순");
		}else if(flag2) {
			
			System.out.println("내려순");
		}else {
			System.out.println("아무것도 아닙 ");
			
		}
		
		
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int input[] = new int[8];
		
		for( int i =0; i<input.length;i++) {
			input[i]= scan.nextInt();
		}
		
		distincion(input);
		
	}

}
/*
		String num = "54321";
		int test = 0;

		boolean[] ck = new boolean[2];
		for (int i = 0; i < num.length() - 1; i++) {
			int temp = (int)num.charAt(i) - '0';

			if (!ck[0] && (temp + 1) == ((int) num.charAt(i + 1) - '0')) {

				test = 1;
				ck[1] = true;
			} else if (!ck[1] && (temp - 1) == ((int) num.charAt(i + 1) - '0')) {
				test = 2;
				ck[0] = true;
			} else {
				test = 3;
				break;
			}

		}



*/
