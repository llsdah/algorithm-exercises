// 내껀데 .. 이건 아뇐다. 분명 다른 분과 비슷하게 구현한거 같은데.. 흠. 정렬 부분이 문제이가?
public class Main {

	// 풍선 문제에서 원하는 것이 무엇일까 문제가 이해가 안됨... 왜 300이가?
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt();// 총 참가팀 
		//풍선의 수와 A와 B의 거리 모든 풍선 다는데 최소한의 거리 
		int A= sc.nextInt();
		int B= sc.nextInt();
		int[][] arr =new int[n][3];
		for(int i=0;i<n;i++) {
			arr[i][0] =sc.nextInt();// 풍선수
			arr[i][1] =sc.nextInt();// A거리
			arr[i][2] =sc.nextInt();// B거리
		}
		for(int i=0;i<3;i++) {
			sc.next();
		}
		
		
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
			
				return Math.abs(o2[1]-o2[2])-Math.abs(o1[1]-o1[2]);
			}
			
		});
		
		int sum =0;
		for(int i=0; i<n;i++) {
			int num = arr[i][0];// 팀에게 달아 주야할 풍선수 
			int a = arr[i][1];//
			int b = arr[i][2];//
			System.out.println("sum : "+sum+" A : "+A+" B : "+B+" arr : "+Arrays.toString(arr[i]));
			if(a<b) { //a거리가 더 가까우면
				if(A<num) { //A에 보관된 풍선수 보다 팀에게 달아줘하할 풍선수가 많다.
					sum+= (A*a);// 풍선수와 해당 거리만큼 이동
					num-=A;
					A=0;
					sum+=(num*b);
					B-=num;
				}else { // A 다 가능하다. 
					A-=num;
					sum+=(num*a);
				}
				
			}else { //b가 더 가까우면.
				
				if(B<num) { //A에 보관된 풍선수 보다 팀에게 달아줘하할 풍선수가 많다.
					sum+= (B*b);// 풍선수와 해당 거리만큼 이동
					num-=B;
					B=0;
					sum+=(num*a);
					A-=num;
				}else {
					B-=num;
					sum+=(num*b);
				}
				
				
			}
			
			System.out.println("sum : "+sum+" A : "+A+" B : "+B+" arr : "+Arrays.toString(arr[i]));

			System.out.println();
		}
		
		System.out.println(sum);
		
		
	}
}
public class MainTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && n == 0)
				break;
			ArrayList<Team> teamList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				teamList.add(new Team(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			Collections.sort(teamList);

			System.out.println(" A : " + a + " B : " + b);
			int sum = 0;
			for (int i = 0; i < n; i++) {
				Team t = teamList.get(i);
				System.out.println("sum : " + sum + " A : " + a + " B : " + b + " arr : " + t.aDist+" : "+t.bDist+" : "+t.balloon);

				if (t.aDist < t.bDist) {// a가 더 가까움
					if (a - t.balloon < 0) { // a를 먼저 사용하고 b사용
						sum += a * t.aDist;
						t.balloon -= a;
						a = 0;
						sum += t.balloon * t.bDist;
						b -= t.balloon;
					} else { // a를 완전히 사용
						a -= t.balloon;
						sum += t.balloon * t.aDist;
					}
				} else { // b가 더 가까움
					if (b - t.balloon < 0) { // b를 먼저 사용하고 a사용
						sum += b * t.bDist;
						t.balloon -= b;
						b = 0;
						sum += t.balloon * t.aDist;
						a -= t.balloon;
					} else { // b를 완전히 사용
						b -= t.balloon;
						sum += t.balloon * t.bDist;
					}
				}
				System.out.println("sum : " + sum + " A : " + a + " B : " + b + " arr : " + t.aDist+" : "+t.bDist+" : "+t.balloon);
				System.out.println();
			}
			System.out.println(sum);
		}
	}
}

class Team implements Comparable<Team> {
	int aDist;
	int bDist;
	int balloon;

	public Team(int balloon, int aDist, int bDist) {
		this.aDist = aDist;
		this.bDist = bDist;
		this.balloon = balloon;
	}

//a와 b의 차이로 내림차순 정렬
	@Override
	public int compareTo(Team o) {
		return Math.abs(o.aDist - o.bDist) - Math.abs(this.aDist - this.bDist);
	}
}

