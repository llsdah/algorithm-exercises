// 우선순위로 바꾸었는데 .. 어디가 .ㅠㅠ
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();// 통나무 길이

		long[][] arr = new long[n][2];
		
		for(int i =0;i<n;i++) {
			long st = sc.nextLong(); // 시작점
			long end = sc.nextLong(); // 끝 정

			arr[i][0]= st;
			arr[i][1]= end;
		}
		
		Arrays.sort(arr, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[1]==o2[1]) return o1[0]-o2[0]>0 ? 1 : -1;
				return o1[1]-o2[1]>0 ? 1 : -1;
			}
		});
		
		PriorityQueue<Long> q = new PriorityQueue<>(Collections.reverseOrder());
		q.offer(arr[0][0]);// 시작점
		
		long end = arr[0][1];
		
		int max = 0;
		for(int i=1;i<n;i++) {
			
			while(!q.isEmpty()&&end<=q.peek()){
				q.poll();
			}
			if( q.isEmpty()|| end<=q.peek()) {
				end = arr[i][1];
			}
			q.offer(arr[i][0]);
			max = Math.max(max, q.size());
			
			
		}
		
		System.out.println(max);
		
	}
	
}

class Point implements Comparable<Point>{
	long st;
	long end;
	Point(long st, long end){
		this.st = st;
		this.end = end;
	}
	
	public int compareTo(Point o) {
		if( this.end==o.end) return this.st -o.end >0 ? 1:-1;
		return this.end -o.end >0 ? 1 :-1;
	}
	
}


// 틀림
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();// 통나무 길이

		long[][] arr = new long[n][2];
		
		for(int i =0;i<n;i++) {
			arr[i][0] = sc.nextLong(); // 시작점
			arr[i][1] = sc.nextLong(); // 끝 정
		}
		
		Arrays.sort(arr, new Comparator<long[]>() {
			
			public int  compare(long[] o1, long[] o2) {
				if(o1[1]==o2[1]) return o1[0] -o2[0]>0 ? 1 : -1;
				return o1[1] -o2[1] > 0 ? 1:-1;
			}
		}); // 끝자리 순서대로 정렬 
		
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		int max = 1; // 최대 갯 수 더하기 
		
		long end = arr[0][1];

		int pos =1;
		
		while(pos<n-1){			
			int cnt = 1; // 1개는 시작이니까 
			for(int i =pos; i < n;i++) {
				pos = i;
				if(end >arr[i][0]) {
					cnt++;
					max = Math.max(max, cnt);
				}else break;
				
			}
			end = arr[pos][1];
		}
		System.out.println(max);
		
	}
	
}
