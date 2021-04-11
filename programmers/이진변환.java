	public static int[] solution(String s) {

		int[] arr =new int[s.length()];
		
		// 0제거 저장, 길이를 2진법 x
		for(int i =0; i<s.length();i++) {
			arr[i] = Integer.valueOf(s.charAt(i)+"");
		}
		int sum = 0;
		int count =0;
		while ( arr.length!=1) {
			
			sum += (int) Arrays.stream(arr).filter( i -> i ==0 ).count();
			count++;
			arr = Arrays.stream(arr).filter( i -> i !=0 ).toArray();
			
			arr = binary(arr);
			
		}
		
		int[] answer = new int[2];
		answer[0] = count;
		answer[1] = sum;
		
		
		return answer;
	}

	private static int[] binary(int[] arr) {
		int leng = arr.length;
		Stack<Integer> st = new Stack<Integer>();
		
		while (leng>0) {
			
			st.push(leng%2); 
			leng = leng/2;
			
		}
		int[] temp = new int[st.size()];
		
		for( int i =0; i< temp.length ; i++) {
			
			temp[i] =st.pop();;
			
			
		}
		
		return temp;
	}
