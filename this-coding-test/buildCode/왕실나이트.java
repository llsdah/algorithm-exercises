package 이코테.구현;

public class 왕실의나이트 {

	public static void main(String[] args) {

		String pos = "55";

		int width = 8; // -1

		int c = pos.charAt(0) - '0';
		int r = pos.charAt(1) - '0';

		// 방향 백터 
		int[] dx = {-2,-1,1,2,2,1,-1,-2};
		int[] dy = {-1,-2,-2,-1,1,2,2,1};
		
		int result =0;
		
		for(int i =0; i< width;i++) {
			
			int nextRow = r+dx[i];
			int nextCol = c+dy[i];
			
			if( nextRow >=1 && nextRow <=8 && nextCol >=1 && nextCol <=8) {
				result ++;
			}
			
		}
		
		System.out.println(result);
		
		// 나의 풀이 
		int cnt = 0;
		if (c - 2 > 0) {

			if (r + 1 <= width) {
				cnt++;
			}

			if (r - 1 > 0) {
				cnt++;
			}

		}
		if (c + 2 <= width) {
			if (r + 1 <= width) {
				cnt++;
			}

			if (r - 1 > 0) {
				cnt++;
			}

		}

		if (r - 2 > 0) {
			
			if (c + 1 <= width) {
				cnt++;
			}
			
			if (c - 1 > 0) {
				cnt++;
			}
			
		}
		if (r + 2 <= width) {
			if (c + 1 <= width) {
				cnt++;
			}
			
			if (c - 1 > 0) {
				cnt++;
			}
			
		}

		System.out.println(cnt);
		
		
	}
}
