	static StringBuilder sb = new StringBuilder();
	public static String solution(int n, int t, int m, int p) {

		// 진법 나누기 + 말해야하는 숫자 갯수 . String, 명수 순서
		String answer = "";

		int total = t * m;

		while (total > 0) {

			bina(total,n);
			total--;
		}

		System.out.println(sb.toString());
		char[] arr  = sb.toString().toCharArray();
		char[] rearr = new char[arr.length+1];
		rearr[0]='0';
		for( int i =0;i<arr.length;i++) {
			rearr[arr.length-i] =arr[i];
		}
		System.out.println(Arrays.toString(rearr));
		for(int i =p-1;i<rearr.length;i=i+m) {
			answer += rearr[i];
			
			if(answer.length()>=t) {
				break;
			}
		}
		
		
		return answer;
	}
	
	// 배열 저장하는 것이비나 . 
	private static void bina(int total, int n) {
		
		while (total>0) {
			char temp = ' ';
			if(total % n == 10) {
				temp = 'A';
			} else if(total % n == 11) {
				temp = 'B';
			} else if(total % n == 12) {
				temp = 'C';
			} else if(total % n == 13) {
				temp = 'D';
			} else if(total % n == 14) {
				temp = 'E';
			}else if(total % n == 15){
				temp ='F';
			}else if(total % n == 16){
				temp ='0';
			}else {
				temp = (char) (total % n+'0');
			}
			
			sb.append(temp);
			total = total / n;
		}

	}
