
	static int[][] temp;
	static int island;
	static int min =9999999;
	public static int solution(int n, int[][] costs) {
		int answer = 0;
		island=n;
		temp = costs;
		// 조합으로 n-1개를 선택합니다. 그 후에 그 숫자를 더하고, 모든 boolean값이 true인지 체크합니다.
		// 만약 true면 저장 계속 갑니다. 
		
		boolean[] visit = new boolean[costs.length];
		int[] arr = new int[costs.length];
		
		for(int i =0;i <arr.length;i++) {
			arr[i] = costs[i][2];
		}
		
		if( arr.length<n) {
			combination(arr,visit,0,arr.length,n-1);			
		}else {
			combination(arr,visit,0,arr.length,n-1);
			combination(arr,visit,0,arr.length,n);
		}

		
		answer = min;
		return answer;
	}

	private static void combination(int[] arr, boolean[] visit, int start, int n, int r) {

		if(r==0) {
			print(arr,visit,n);
			return;
		}
		
		for(int i =start; i<n;i++) {
			visit[i]=true;
			combination(arr,visit,i+1,n,r-1);
			visit[i]=false;
		}
		
	}

	private static void print(int[] arr, boolean[] visit, int n) {

		boolean[] check = new boolean[island];
		int sum = 0;
		for(int i =0; i<n;i++) {
			if(visit[i]) {
				System.out.print(arr[i]+" ");
				check[temp[i][0]] =true;
				check[temp[i][1]] =true;
				sum+=arr[i];
			}
		}
		System.out.println();
	
		for(int i =0;i<check.length;i++) {
			if(check[i]==false) {
				return;
			}
		}
		min = Math.min(min, sum);
		
	}
