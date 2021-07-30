//해당 답에 대해 생각한후 역으로도 생각
// 순차적으로 잘랐을때 혹은 역으로 자르면 어떻게 
// 숫자가 크면 끝 
public class Main {

	// 통나무 자르기 숫자가 크니까 이분탐색으로 빠르게 
	static long max =0;
	static long fp =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		long L = sc.nextLong();// 통나무 길이
		int K = sc.nextInt();// 통나무 자르는 위치 갯수 
		int C = sc.nextInt();// 자를수 있느 툇수 결국 1번 자를건데 
		
		long[] arr = new long[K+2];//자를 수 있는 위치가 0과 가장 긴 지점도 포함!!
		
		
		for(int i =1;i<K+1;i++) {
			arr[i] =sc.nextLong();
		}
		arr[K+1] = L;
		Arrays.sort(arr);
	
		binary(arr,1,L,K,C);
	
		
		System.out.println(max + " "+fp);
	}
	// 최대한 긴 부분 부터 자르기 시작, 
	private static void binary(long[] arr, long st, long L, int K, int C) {

		long l =0;
		long r =arr[K+1];
		
		int cnt =0;
		int f =1;
		
		long mid = (st+L)/2;
		
		for(int i =K;i>=0;i--) {
			l = arr[i];
			if(r-l<=mid) continue; // 최대 자를 수 있는 지점과 시작점을 비교해서  중간이 크면 쭉
			
			if(arr[i+1]-arr[i]>mid) {
				f =-1;// 길이가 길어서 못자름.
				break;
			}else {
				if(st==L) 	max = Math.max(max, r-arr[i+1]);//답이얌
				r = arr[i+1];	
				cnt++;
			}
			
		}// for
		
		if( st == L ) {
			max = Math.max(max, r);
			if(cnt==C) fp =r;
			else fp = arr[1];
			return;
		}
		
		if( cnt>C|| f==-1) binary(arr,mid+1,L,K,C);
		else binary(arr,st,mid,K,C );
		
	}
	
}
