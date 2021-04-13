	public static void main(String[] args) {

		int N = 6;
//		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
		int[][] road = { {1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int k = 4;

		int result = solution(N, road, k);
		System.out.println("result : " + result);
		// System.out.println("result : " + Arrays.toString(result));
		// System.out.println("result : "+ Arrays.deepToString(result));
	}
	
	static int[][] times;
	static int[] map;
	
	public static int solution(int N, int[][] road, int K) {
		
		int answer =0;
		// 편리한 방법위한 길이 재기 
		
		times = new int[N+1][N+1];
		map = new int[N+1];
		
		Arrays.fill(map, K+100);
		
		
		for(int i =0; i< road.length;i++) {
			int start = road[i][0];
			int end = road[i][1];
			int time = road[i][2];
			
			int city1 = times[start][end];
			int city2 = times[end][start];
			
			times[start][end] =(city1 ==0) ?time : Math.min(city1, time);
			times[end][start] = (city2==0) ? time : Math.min(city2, time);
			
		}
		int[] arr = new int[N+1];
		Arrays.fill(arr, 1);
		
		funk(1, new int[N+1],0,arr);
		
		for(int i =1;i<map.length;i++) {
			if(map[i]<=K) {
				answer++;
			}
		}
		
		
		return answer+1;
		
	}

	private static void funk(int num, int[] data, int ans, int[] arr) {
		
		if(num ==data.length) {
			return;
		}
		
		if( num ==1) {
			data[1] =1;
			arr[1] =0;
			funk(num+1,data,ans,arr);
			return;
		}
		
		
		for( int i =2; i<arr.length;i++) {
			int time = times[data[num-1]][i]; //여기가 잘 이해가 안됨..
			
			if(arr[i]==0||time==0) {
				continue;
			}
			
			if( map[i]<ans+time) {
				continue;
			}
			
			data[num] =i;
			arr[i]=0;
			
			map[i]= ans + time;
			funk(num+1,data,ans+time,arr);
			arr[i]=1;
			data[num]=0;
			
			
		}
		
	}

}
/*

	나의 풀이.... 흠냐..
	
	static int total;
	static boolean[] check;

	public static int solution(int N, int[][] road, int K) {
		int answer = 0;
		total = K;

		check = new boolean[N];
		int pay = 0;
		int big =0;
		int small =0;
		for (int x = 0; x < road.length; x++) {
			big = Math.max(road[x][0], road[x][1]);
			small = Math.min(road[x][0], road[x][1]);
			
			if (small == 1) {

				if(road[x][2] == K ) {
					check[big - 1] = true;
					System.out.println(" road[x][2] == K  small : " +small+ " big : "+big+"  pay : "+pay);

					continue;
				} else	if (road[x][2] <= K) {
					check[big - 1] = true;
					pay = road[x][2];
					System.out.println(" road[x][2] < K small : " +small+ " big : "+big+"  pay : "+pay);

					count(pay,big,road);

				} // 작은지 확인 경우

			}

		}

		int count = 0;
		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				count++;
			}
		}
		answer = count;
		return answer;
	}

	
	// 들어간 비용, 현재 위치 , 전체 길 
	private static void count(int pay, int pos, int[][] road) {
		int big=0;
		int small=0;
		for (int x = 0; x < road.length; x++) {
			big = Math.max(road[x][0], road[x][1]);
			small = Math.min(road[x][0], road[x][1]);

			if (small == pos) {

				if(road[x][2]+pay == total) {
					check[big - 1] = true;
					System.out.println(" road[x][2] == K small : " +small+ " big : "+big+"  pay : "+pay);		
					continue;
				}else if (road[x][2]+pay < total ) {

					check[big - 1] = true;
					pay = road[x][2]+pay;
					System.out.println(" road[x][2] < K small : " +small+ " big : "+big+"  pay : "+pay);

					count(pay,big,road);

				}// 작은지 확인 경우

			}

		}
		
	}



*/



/*

	private static int solution(int N, int[][] road, int K) {
		int answer =0;
		//초기화 
		
		//편하게 색인하기 위해 1더하것
		edgeList = new ArrayList[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, K+100);
		
		for(int i =1;i<=N;i++) {
			edgeList[i] = new ArrayList<>();
		}
		
		for( int i =0; i< road.length;i++) {
			edgeList[road[i][0]].add(new Edge(road[i][1],road[i][2]));
			edgeList[road[i][1]].add(new Edge(road[i][0],road[i][2]));
		}
		
		distance[1] =0; // 1번 도시 는 항상 0 자기 자신 입니다. 
		
		//다익스트라
		dijkstra();
		
		//1번마을에서 K이하 비용인 도시 개수 구하기 
		for( int cost : distance) {
			if(cost <=K) {
				answer++;
			}
		}
		
		
		return answer;
	}

	private static ArrayList<Edge>[] edgeList; // 도시의 인접리스트 
	private static int[] distance;// 1번 도시와의 다른 도시간 최단 경로 
	
	private static class Edge implements Comparable<Edge>{
		int vertex;
		int weight;// 배달시간
		
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight =weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return weight -o.weight;
		}
		
	}
	
	private static void dijkstra() {
		PriorityQueue<Edge> que = new PriorityQueue<>();
		que.add(new Edge(1,0));
		while(!que.isEmpty()) {
			Edge edge =que.poll();
			int vertex = edge.vertex;
			int weight = edge.weight;
			if( distance[vertex]< weight) {
				continue;
			}
			// 해당 도시와 연결된 도시 탐생
			for(int i=0; i< edgeList[vertex].size();i++) {
				int vertex2 = edgeList[vertex].get(i).vertex;
				int weight2 = edgeList[vertex].get(i).weight+weight;
			
				//최단거리로 확인
				if( distance[vertex2] >weight2) {
					distance[vertex2] =weight2;
					que.add(new Edge(vertex2,weight2));
				}
			}
			
		}
		
	}




*/
