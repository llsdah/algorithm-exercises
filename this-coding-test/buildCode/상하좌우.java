
public class 상하좌우 {

	
	public static void main(String[] args) {
	
		int n =5;
		
		String str = "R R R U D D";
		int[][] arr = new int[5][5];
		
		String[] s = str.split(" ");
		
		// 방향백터 설정.
        int x = 1, y = 1;

        // L, R, U, D에 따른 이동 방향 
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < s.length; i++) {
            char plan = s[i].charAt(0);
            // 이동 후 좌표 구하기 
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시 
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행 
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);

		
		
		// 나의 풀이 
		int c =0;
		int r=0;
		for(int i=0; i <s.length;i++) {
			
			if(s[i].equals("R")&&!(r+1>=n)   ) {
				r++;
			} else if (s[i].equals("L")&&!(r-1<0)) {
				r--;
				
			}else if (s[i].equals("U")&&!(c-1<0)) {
				c--;
			}else if (s[i].equals("D")&&!(c+1>=n)) {
				c++;
			}
			
		}
		
		System.out.println(c+1);
		System.out.println(r+1);
	}
}
