	public static int[][] solution(int[][] arr1, int[][] arr2) {
		// 행 * 열 = 행 * 열   
		int[][] answer = new int[arr1.length][arr2[0].length];
		
		
		for(int x=0; x<answer.length;x++) {
			
			for( int y =0; y<answer[0].length;y++) {
				
				answer[x][y]= muti(arr1[x],arr2,y);
				
			}
			
		}
		
		
		return answer;
	}

	private static int muti(int[] arr1, int[][] arr2, int y) {
		int multi=0;
		
		
		for(int i =0; i<arr1.length;i++) {
			
			multi+=(arr1[i]*arr2[i][y]);
			
		}
		
		
		return multi;
	}
