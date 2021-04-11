public class 달팽이출력 {

	public static void main(String[] args) {

		int n = 6;
		int[][] arr = new int[n][n];

		// 방향좌표 입니다. 
		int x =0;
		int y=0;
		int num =1;
		
		// 몇번 이동할지
		int f=n;
		
		
		// 방향 전환이 방생하는 경우의 수 2n-1
		for (int i = 0; i < 2 * n - 1; i++) {

			// 방향 정의
			switch (i % 4) {

			case 0:
				
				for( int k=0; k<f;k++) {
					arr[y][x] =num;
					x++;
					num++;
				}
				x--;// 마지막까지 가지나 
				y++;
				
				f--;
				break; // 오틀쪽

			case 1:
				for( int k=0; k<f;k++) {
					arr[y][x] =num;
					y++;
					num++;
				}
				
				y--;// 마지막까지 가지나 
				x--;
				
				break; // 아래 
			case 2:
				for( int k=0; k<f;k++) {
					arr[y][x] =num;
					x--;
					num++;
				}
				
				x++;// 마지막까지 가지나 
				y--;
				
				f--;
			
				break; //왼쪽

			case 3:
				for( int k=0; k<f;k++) {
					arr[y][x] =num;
					y--;
					num++;
				}
				x++;// 마지막까지 가지나 
				y++;
				
			
				break;// 위쪽

			}

		}
		
		
		for( int i=0; i<n;i++) {
			for(int k =0; k<n ; k++) {
				System.out.printf("%3d",arr[i][k]);
			}
			System.out.println();
		}

	}

}
