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

}

/*  수정 반열 
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 3 2 2 2 
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int row1 =0; row1 < arr1.length;row1++){
           for(int col1 =0; col1 < arr1[0].length;col1++){
               for(int col2 =0; col2<arr2[0].length;col2++){
                   answer[row1][col2]+= (arr1[row1][col1]*arr2[col1][col2]);
               }
           }
        }
        
        return answer;
    }
}

*/







