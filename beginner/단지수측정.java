package AlgorismStudyUtube;

import java.util.Arrays;


//중요
public class 단지수측정 {
/*
 * 단지 수와 단지 세대수 출력
 * 상하좌우에 붙어있는 것이 세대 수,   
 * 
 * 00011
 * 00001
 * 10000
 * 11000
 * 11011
 * 
 */

	static int[][] map =
		{
				{0,0,0,1,1},
				{0,0,0,0,1},
				{1,0,0,0,0},
				{1,1,0,0,0},
				{1,1,0,1,1}
		};
	
	public static void main(String[] args) {

		map(map);
		
		System.out.println(Arrays.toString(household));
		System.out.println(count);
		
		
	}
	
	
	static int count = 0; // 단지 수 측정 
	static int[] household = new int[10];

	public static void map(int[][] map) {
	
		
		for(int y=0;y<map.length;y++) {
			
			for(int x =0;x<map[y].length;x++) {
				if(map[y][x]==1) {
					check(y,x,count);
					count++;
				}
				
			}
			
		}
		
	}

	private static void check(int y, int x, int index) {

		map[y][x]=0; // 재검색 방지
		household[index]++;
		
		if(x -1>=0 && map[y][x-1]==1) {
			check(y,x-1,index);
		}
		if(x +1<=map[0].length-1 && map[y][x+1]==1) {
			check(y,x+1,index);
		}
		if(y -1>=0 && map[y-1][x]==1) {
			check(y-1,x,index);
		}
		if(y +1<=map[0].length-1 && map[y+1][x]==1) {
			check(y+1,x,index);
		}
		
	}
	

}
