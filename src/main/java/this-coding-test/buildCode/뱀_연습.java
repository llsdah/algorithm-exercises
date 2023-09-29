package 이코테.구현;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 뱀_연습 {

	public static int n;
	public static int k;
	public static int l;
	public static int[][] arr = new int[101][101];// 맵정보
	// 방향 전환에 대한 정보를 담는것
	public static ArrayList<D> info = new ArrayList<D>();

	// 처음에 오른쪽을 보고 있다. ( 동, 서 남, 북)??????
	public static int dx[] = { 0, 1, 0, -1 };
	public static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		n = 6;

		int[][] apple = { { 3, 4 }, { 2, 5 }, { 5, 3 } };
		for (int i = 0; i < apple.length; i++) {
			arr[apple[i][0]][apple[i][1]] = 2;// 사과가 있는 곳을 1로 표시
		}

		l = 3;// 방향 전환정보 갯수
		info.add(new D(3, 'D'));
		info.add(new D(15, 'L'));
		info.add(new D(17, 'D'));
		// 얘도 방향 전황에 대한 정보를 담았어 
		String[][] turn = { { "3", "D" }, { "15", "L" }, { "17", "D" } };

		//뱀의 시작 위치 방향 전환으로 x,y 값으로 비교합니다. 
		int x =1;
		int y =1;
		arr[x][y]=1;// 뱀이 존대하는 위치르 1로 표시
		int direction =0; // 동쪽 보는 것 
		int time=0; // 시간 정보 
		int index = 0; // 몇번째 방향 전환인지 
		
		// 뱀의 크기 위치 정보(꼬리ㅡ 머리) 순으로 입력
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(x,y)); // 시작 위치 입력
		
		while(true) {
			int nx = x+dx[direction];
			int ny = y+dy[direction];
			// q뱀 위치 1 입니다.
			if(1<=nx&&nx<=n&&1<=ny&& ny<=n&&arr[nx][ny]!=1) {
				// 사과가 없다면 이동 후에 꼬리 제거 
				if(arr[nx][ny]==0) {
					arr[nx][ny]=1;
					que.offer(new Pos(nx,ny));
					Pos prey =que.poll(); // 먼저 입력된거는 제거합니다.
					arr[prey.getX()][prey.getY()]=0;
				}
				// 사과가 존재 합니다. 
				if( arr[nx][ny]==2) {
					arr[nx][ny]=1;
					que.offer(new Pos(nx,ny));
				}
			}else { // 몸통이 다았다!!!! 비상
				time+=1;
				break;
			}
			
			x =nx;
			y =ny;
			time +=1;
			if(index <l && time ==info.get(index).getTime()) {
				// 회전을 합니가 
				direction = turn(direction, info.get(index).getDist());
				index++;
			}
			
			
			
		}
		
		

		// 맴 범위 안에 있고, 뱀의 몸토잉 없는 위치라면
		
		
	}

	private static int turn(int direction, char dist) {
		if(dist =='L') {
			direction = (direction==0)?3:direction-1;
		}else {
			direction = (direction+1)%4;
			
		}
		
		return direction;
	}
	
	
}

// 방향 전환에 대한 정보를 담았어요 
class D {
	private int time;
	private char dist;

	public D(int time, char dist) {
		this.time = time;
		this.dist = dist;
	}

	public int getTime() {
		return this.time;
	}

	public char getDist() {
		return this.dist;
	}

}


class Pos{
	private int x;
	private int y;
	public Pos(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}














