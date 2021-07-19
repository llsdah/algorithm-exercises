


//
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(arr[0]);
		
		int cnt = 0; // 갯수 생각
		int pos =1;
		while(!q.isEmpty()) {
			int pre = Math.abs(arr[pos]-q.peek());
			int next = Math.abs(arr[pos+1]-arr[pos]);
			
			if(pre > next) { // 차이 나서 작은거  기준 넣고 뺴기 
				q.offer(Math.min(arr[pos+1], arr[pos]) );
				pos++;
			}else {
				int temp = q.poll();
				q.offer(  Math.min(temp,arr[pos]));
			}
			pos+=2;
			
			
		}
		
	
	}

}
