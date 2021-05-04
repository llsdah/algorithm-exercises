package 이코테.구현;

import java.util.Scanner;

public class 개임개발_풀이 {

	static int n,m,x,y,direction;
	
	static int[][] d = new int[50][50]; // 방문한 위치를 저장하기 위한 맴을 생성하여 0으로 초기화
	static int[][] arr = new int[50][50]; // 맵전체 정보
	
	//북동남서 방향 정의
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	// 왼쪽 회전
	public static void turn_left() {
		direction +=-1;
		if(direction==-1) direction =3;
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        
        // 현재 캐릭터의 X 좌표, Y 좌표, 방향을 입력받기
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        d[x][y] = 1; // 현재 좌표 방문 처리

        
        for(int i =0; i<n;i++) {
        	for(int k =0; k<n;k++) {
        		arr[i][k]= sc.nextInt();
        	}
        }
		
        // 시물레이션 시작
        int cnt =1;
        int turn_time =0;
        
        while(true) {
        	//왼쪽으로 회전
        	turn_left();
        	int nx = x+dx[direction];
        	int ny = y+dy[direction];
        	
        	
        	if(d[nx][ny]==0&&arr[nx][ny]==0) {
        		d[nx][ny]=1;
        		x =nx;
        		y= ny;
        		cnt+=1;
        		turn_time =0;
        		continue;
        	}else {
        		turn_time+=1;
        	}
        	
        	if( turn_time==4) {
        		nx = x-dx[direction];
        		ny = y-dy[direction];
        		if(arr[nx][ny]==0) {
        			x=nx;
        			y=ny;
        		} else {
        			break;
        		}
        		turn_time=0;
        		
        	}
        	
        	
        
        } //while
        
        System.out.println(cnt);
        
	}
}














