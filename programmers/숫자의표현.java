
	public static void main(String[] args) {

//		String s = "ULURRDLLU";
		String s = "LULLLLLLU";
//		String s = "LRLRL";
		int n = 15;

		int result = solution(n);
		System.out.println("result : " + result);

	}

	private static int solution(int n) {
		int answer = 0;
		
		int sum =0;
		for( int i =1; i <= n/2;i++) {
			
			sum=0;
			for(int k=i;k<=n/2+1;k++) {
				sum +=k;
				
				if( sum==n){
					System.out.println("i : "+i);
					answer++;			
					break;
				}else if( sum >n) {
					break;
				}
				
				
			}
			
		}
		
		answer++;
		return answer;
	}

//이건 가우스 연속수로.. 해봤는데 잘못구현한듯...
	public static int solution2(int n) {
		int answer = 0;
		
		if( n ==1) {
			return 1;
		}
		
		int sum =0;
		int cnt = 0;
		
		for(int i =1; i< n/2;i++) {
			sum = i+(i-1);
			if( n%i!=0) {
				
			}else if(  (n/i)%2==1 &&i > (n/i)/2 ){
				cnt++;
				continue;
			}
			
			if( n%sum!=0) {
				
			} else if( (n/i)%2==0&& i>(n/sum)-1 ) {
				cnt++;
				continue;
			}
		}
		
		if( n%2==1) {
			cnt+=2;
		}else {
			cnt++;
		}
		
		
		return answer;
	}
