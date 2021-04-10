package studyProgrammers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵 {

	

	public static void main(String[] args) {

		String s = "()()";
//		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		String s = "{{20,111},{111}}";

		int n = 78;
		int[][] land = { 
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1 } };

		
		//int[][] land = { {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1 } };

		int result = solution(land);
		System.out.println("result : " + result);
//		System.out.println("result : " + Arrays.toString(result));
	
	}
	
	// 0 은 false 
	
    public static int solution(int[][] maps) {
    	int answer =0;
    	
    	
    	Point start = new Point(0,0);
    	Point end = new Point(maps.length-1,maps[0].length-1);
    	
    	
    	Queue<Point> qu = new LinkedList<>();
    	qu.add(start);
    	
    	int[][] dist = new int[maps.length][maps[0].length];
    	dist[0][0]=1;
    	
    	// 동서 남 북
    	int[] dx = {1,-1,0,0};
    	int[] dy = {0,0,-1,1};
    	
    	int colx = maps.length;
    	int rowy = maps[0].length;
    	
    	
    	while(!qu.isEmpty()) {
    		
    		Point now = qu.poll();
    		System.out.println("꺼낸 것 : "+now.x +","+now.y);
    		
    		if( now.x == end.x&& now.y ==end.y) {
    			return dist[now.x][now.y];
    		}
    		
    		for( int i =0; i< dx.length;i++) {
    			
    			int nextX = now.x +dx[i];    			
    			int nextY = now.y +dy[i];
    			
    			if( (nextX <colx&&nextX >=0)&&(nextY <rowy && nextY>=0)&&
    					maps[nextX][nextY]==1) {
    				int preDist = dist[nextX][nextY];
    				int nowDist = dist[now.x][now.y]+1;
    				
    				if( preDist ==0 || (preDist !=0 && nowDist <preDist)) {
    					dist[nextX][nextY] = nowDist;
    					qu.add(new Point(nextX,nextY));
    					
    				}
    				
    				
    				dist[nextX][nextY] =nowDist;
    				
    				
    				
    			}
    		}
    	}
    	
    	
    	
        
        return -1;
    }

}


class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x =x;
		this.y =y;
	}


}