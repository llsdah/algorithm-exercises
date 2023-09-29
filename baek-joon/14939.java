
// 정답자분 정답 보면서 수정한ㄱㄴ데 .. 흠. 
public class Main {
	// 전구 불 끄기 
	// 4 3 2 1 로 돌면서 뺴면 안되띾? 10 * 4 400번이면 되럮같은데 
	static boolean[][] map = new boolean[10][10];
	static int cnt =(int)1e9;
	static int[] d = {0,0,1,-1};//방향 회전용
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
	
		for(int i =0; i < 10;i++) {
			String str = sc.next();
			char[] temp = str.toCharArray();
			for(int k=0; k<10;k++) {
				if(temp[k]=='O') map[i][k] =true;
			}
			
		}
		
		// 1줄 당 불을 키고 안키고!! 2^ 10 이다.
		
		for(int i=0;i<1024;i++) {
			int num = Integer.bitCount(i);// 비트 카운드?
			boolean[][] temp = new boolean[10][10];
			
			for(int k=0;k<10;k++) {
				temp[k] = map[k].clone(); // 깊은 복사 실시 
			}
			
			for(int k =0; k<10;k++) {
				if( (i&(1<<k))!=0) {
					temp[0][k]^=true; // 반대로 뒤집기
				
					for( int h=0;h<3;h++) {
						int X = d[h];
						int Y = d[3-h];// 대칭된거
						
						if(X<0||Y<0||Y>=10) continue; //넘어가면 
						temp[X][Y]^=true;// ㅈㄴ구 불 바꾸기 
					}
				
				}// if 문
			}// 전구 불빠구는 용고
			
			check(1,num,temp);
			
		}

		System.out.println();
		System.out.println(cnt);
	}

	private static void check(int col, int num, boolean[][] temp) {

		
		if(col==10) {
			boolean flag = false;
			for(int i=0; i<10;i++) {
				if(temp[9][i]) flag = true;// 10번째 니까 그 전부분만 확인 중 불 켜짐?
			}
			if(!flag) cnt = Math.min(num, cnt); // 다 꺼질 겨웅만
			return;
		}
		
		for(int i=0; i<10;i++) {
			if( temp [col-1][i]) {
				temp[col][i]^=true;
				num++;
				
				for(int k=0;k<3;k++) {
					int X =d[k]+col;// 해당 열
					int Y = d[3-k]+i;//헹
					if(X<0||Y<0||X>=10||Y>=10) continue; //넘어가면 
					temp[X][Y]^=true;// ㅈㄴ구 불 바꾸기 
				}
			}
		}
		
		check(col+1,num,temp);
		
	}
	
}

public class Main {
	// 전구 불 끄기 
	// 4 3 2 1 로 돌면서 뺴면 안되띾? 10 * 4 400번이면 되럮같은데 
	static int cnt =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
	
		char[][] arr = new char[10][10];
		for(int i =0; i < 10;i++) {
			String str = sc.next();
			char[] temp = str.toCharArray();
			arr[i] = temp;
		}
		System.out.println();
		//for(int i=0; i<10;i++) {	System.out.println(Arrays.toString(arr[i]));}
		
		for(int i= 4;i>0;i--) {
			// i 이면 끄기!!! 인데 다끄면?에이 이건 일단 나중에 
			check(arr,i);
			for(int t=0; t<10;t++) {	System.out.println(" i "+i+"  "+Arrays.toString(arr[t]));}
		}
		
		for(int i=0; i<10;i++) {	System.out.println(Arrays.toString(arr[i]));}
		System.out.println();
		System.out.println(cnt);
	}
	private static void check(char[][] arr, int num) {

		for(int i =0; i<10;i++) {
			for(int k =0; k<10;k++) {
				int temp =0; // 사방의 갯수 
				
				if(i-1>=0&&arr[i-1][k]=='O') temp++;// 상
				if(i+1<10&&arr[i+1][k]=='O')temp++;// 하
				if(k-1>=0&&arr[i][k-1]=='O')temp++;// 좌
				if(k+1<10&&arr[i][k+1]=='O')temp++;// 우
				
				if(temp == num) {
					System.out.println(" row : "+ i+" col : "+k);
					cnt++; // 해당 갯수랑 맞으면 
					arr[i][k]='#';
					if(i-1>=0&&arr[i-1][k]=='O') arr[i-1][k]='#';// 상
					if(i+1<10&&arr[i+1][k]=='O') arr[i+1][k]='#';// 하
					if(k-1>=0&&arr[i][k-1]=='O') arr[i][k-1]='#';// 좌
					if(k+1<10&&arr[i][k+1]=='O') arr[i][k+1]='#';// 우
				}// 같은 경우 변화하는 조건문 
				
			}
		}
		
	}
	
}

/*

*/
