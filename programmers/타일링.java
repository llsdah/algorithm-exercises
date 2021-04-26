public static int solution(int n) {
	        int answer = 0;
	        
	        // 가로 길이가 주어집니다. 
	        // 1 1개, 2면 2개, 3 3개 , 4 5개	        
	        
	        int[] arr = new int[n];
	        
	        arr[0]=1;
	        arr[1]=2;
	        
	        for(int i =2; i < n ;i++) {
	        	
	        	arr[i] =arr[i-1]+arr[i-2];
	        	arr[i] =  arr[i]%1000000007;
	        }
	        answer =  arr[n-1];
	        return answer;
}
