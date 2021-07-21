
public class Main {

	// 자연수신
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// k 개의 자연수 가지가 n개의 수를 뽑아서 그 수를 붙여서 만들수 있는 가자 ㅇ큰수 
		// 수를 여러변 사용도 가능하지만 뽑은 수는 한번이상 사용
		// k<n
	
		// 너무 단순하게 생각 길이가 긴 부분 생각 못함. 가장 큰수 만들기 생각하면됩니다. 
		// 77 과 9 의 경우 977이 더 큰수 
		
		int k =sc.nextInt();
		String[] nums = new String[k];
		int n =sc.nextInt();
		for(int i=0; i<k;i++) {
			nums[i] = sc.next();
		}
		StringBuilder sb = new StringBuilder();
		// 정렬하기 더해서 가장 큰수로
		
		//Comparator<String> comp = (n1,n2)-> (n2+n1).compareTo(n1+n2);
		//Arrays.sort(arr, comp);
		
        Arrays.sort(nums, (o1,o2)-> (o2+o1).compareTo(o1+o2) );
        int index =0;
        int pos=Integer.valueOf(nums[0]); //이 숫자 붙이면됨 그냥 
        int length = nums[0].length();
        for(int i=1;i<k;i++) {
        	// 길이가 누가 긴지
        	if(length==nums[i].length()) {
        		// 길이가 같을때 누가 큰수인지 
        		if(pos<Integer.parseInt(nums[i])) {
        			pos = Integer.parseInt(nums[i]);
        			index =i;
        		}
        	}else if(length<nums[i].length()){
        		length = nums[i].length();
        		pos = Integer.parseInt(nums[i]);
        		index=i;
        	}
        }
        
        // 넘치는거 붙있떄는 길이가 제일 긴것 중에 가장 큰거 붙이면됨다. 근데 그 위치가 
        
		for(int i=0; i<k;i++) {
			if(i==index) { // 해당 위치에 왔을때 붙이면댐.
				while(n>k) {
		        	n--;
		        	sb.append(nums[i]);
		        }
			}
			sb.append(nums[i]);
		}
        
		
		System.out.println(sb.toString());
	}
}

		// 너무 단순하게 생각 길이가 긴 부분 생각 못함. 가장 큰수 만들기 생각하면됩니다. 
		// 77 과 9 의 경우 977이 더 큰수
public class Main {
	// 자연수신
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// k 개의 자연수 가지가 n개의 수를 뽑아서 그 수를 붙여서 만들수 있는 가자 ㅇ큰수 
		// 수를 여러변 사용도 가능하지만 뽑은 수는 한번이상 사용
		// k<n
		int k =sc.nextInt();
		int[] nums = new int[k];
		int n =sc.nextInt();
		for(int i=0; i<k;i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);// 숫자대로 정렬 
		StringBuilder sb = new StringBuilder();
		// 작으면 사용 못해 무조건 사용해야댐
		while(n>k) {
			sb.append(nums[k-1]);
			n--;
		}
		
		for(int i=k-1;i>=0;i--) {
			sb.append(nums[i]);
		}
		System.out.println(sb.toString());
	}
}
