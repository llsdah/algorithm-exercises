public class 색칠_재귀 {

	static int size = 5;
	static int color = 2;
	static int[][] map = { 
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 0 },
			{ 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0 }, };

	public static void main(String[] args) {

		System.out.println(Arrays.deepToString(map));
		color(0, 0);
		System.out.println(Arrays.deepToString(map));

	}

	public static void color(int x, int y) {

		if (map[x][y] != 1) {
			map[x][y] = color;
		}

		if (x - 1 >= 0 && map[x - 1][y] != color && map[x - 1][y] != 1) {
			color(x - 1, y);
		}
		
		if( x+1<=size-1 &&map[x+1][y]!=color && map[x+1][y]!=1) {
			color(x+1,y);
		}

		if( y+1<=size-1&&map[x][y+1]!=color&&map[x][y+1]!=1) {
			color(x,y+1);
		}
		
		if( y-1>=0&&map[x][y-1]!=color&&map[x][y-1]!=1) {
			color(x,y-1);
		}
		
		
		
		
	}

}
