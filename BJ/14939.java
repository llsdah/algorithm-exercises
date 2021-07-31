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
