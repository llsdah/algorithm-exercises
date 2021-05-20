		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();
		int num = scan.nextInt();
		Integer[] cost = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			cost[i] = scan.nextInt();
		}
		int total =0;
		for(int i =cost.length-1;i>=0;i--) {
				while(num>=cost[i]) {
					num = num -cost[i];
					total ++;
					System.out.println(num);
				}
				if( num <=0) {
					break;
				}
			
		}
		
		
		
		System.out.println(total);
