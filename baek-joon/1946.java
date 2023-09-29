
// 인덱스 활용한 답.. 훌륭하네..
public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int per = scan.nextInt();
			int[] arr = new int[per+1]; // 1부터 시작

			for (int k = 0; k < per; k++) {
				arr[scan.nextInt()]=scan.nextInt();
			}
			int cnt =1; // 1등은 무조건
			int sec  = arr[1];
			for(int k=2;k<=per;k++) {
				if(sec >=arr[k]) {
					sec = arr[k];
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}

	}

}


/* 2번 답 조금 줄인것 
public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int per = scan.nextInt();
			int[][] arr = new int[per][2];

			for (int k = 0; k < per; k++) {
				arr[k][0] = scan.nextInt(); //서류
				arr[k][1] = scan.nextInt();//면접 
			}
			
			Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[1], o2[1]));
			int cnt = 1;
			int st = arr[0][0]; // 첫번쨰 기준
			// 기준
			for (int h = 1; h < arr.length; h++) {
				if (arr[h][0] < st) {
					st = arr[h][0];
					cnt++;
				}

			}

			System.out.println(cnt);
		}

	}

}


*/




/* 1번답

public class Main {
	static int cnt ;
	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n =scan.nextInt();
		int[] ans = new int[n];
		for(int i =0; i<n;i++) {
			int per = scan.nextInt();
			int[][] arr = new int[per][2];
			cnt =per;
			for(int k=0; k<per;k++) {
				arr[k][0] = scan.nextInt();
				arr[k][1] = scan.nextInt();
			}
			int temp = rank(arr);
			ans[i]=temp;
		}
		for(int i=0; i< ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		
		
	}
	public static int rank(int[][] arr ) {
		Arrays.sort(arr, (o1,o2)->Integer.compare(o1[1], o2[1]));

		// 기준
		for(int i =1; i< arr.length;i++) {
			for(int k=0; k<i;k++) {
				if(arr[i][0]>arr[k][0]) {
					//System.out.println("arr[i][0]>arr[k][0]"+arr[i][0]+"  "+arr[k][0]);
					cnt--;
					break;
				}
			}
			
		}
		
		return cnt;
	}
}



*/
