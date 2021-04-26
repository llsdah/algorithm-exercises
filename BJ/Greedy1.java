	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		
		
		int b = scan.nextInt();
		
		int[] arr = new int[b];
		
		for(int i =0; i<b;i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum =0;
		int addSum=0;
		for(int i =0; i< arr.length;i++) {
			
			sum+= arr[i];
			addSum+=sum;
			
		}
		System.out.println(addSum);
	}
