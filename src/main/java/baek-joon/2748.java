

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();// 
		long[] arr = new long[n+1];
		if(n==0)arr[0]=0;
		else if(n<=1) {
			arr[0]=0;
			arr[1]=1;
		}
		else {
			arr[0] =0;
			arr[1] =1;
			arr[2] =1;
		}
		for(int i =3; i <n+1;i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		
		System.out.println(arr[n]);
		
	}

}
