import java.util.*;
class Solution {
    	static int Cnt = (int)1e9;
	static int N;
	static int[] Weak;
	static int[] Dist;

	// 친구명수, 친구 위치, 방문 여부 (비트표현 ) 재취로 사용 
	public static void sol(int cnt, int idx, int visit) {
		if(cnt>Dist.length) return;
		if(cnt>=Cnt)return;
		
		for(int i =0; i<Weak.length;i++) {
			int next = (idx+i)%Weak.length; // 나머지 연산 통해서 인텍스 순환 ! 커지면 벗어닌까 . 
			int dif = Weak[next] - Weak[idx];
			if( next <idx) dif +=N;
			
			if(dif >Dist[Dist.length-1])break;
			
			visit |= 1 <<next; // 비트로 or 연산입니다. 
		}
		
		if( visit == (1<<Weak.length)-1) {
			Cnt = cnt;//Math.min(Cnt, cnt); 윗쪽에서 이미 해당 값을 없에서 이 부분 수정
			return;
		}
		
		for(int i=0; i<Weak.length;i++) {
			if((visit&(1<<i))!=0) continue;	
			sol(cnt+1,i,visit);
		}
		
	}
	
	public static long solution(int n, int[] weak, int[] dist) {
    	
    	long answer = 0;
        // 친구는 모조건 취약점에서 시작, 아작 가장 멀리 이동하는 것 자.
    	// 원형!반시계와 시계방향 체크 안해도됨 
    	// 완전 탐색!! 용량이 크지 않다
    	// 가장 멀리 갈수 있는 친구부터 시작 -> 옆에 체크 -> 갯수 체크 
    	
    	Arrays.sort(dist);
    	Arrays.sort(weak);
    	N=n;
    	Weak =weak;
    	Dist=dist;
    	
    	for(int i =0; i<weak.length;i++) {
    		sol(1,i,0);
    	}
    	
    	answer = Cnt;
        return answer;
    }
/* 내가 푼것 2탄.. 어디가 틀렸을까.흠..
import java.util.*;
class Solution {
    int ans = (int)1e9;
    int[] pp;//역순 정렬 할 것 친구들 .
    // 총 합, 보수지점, 친구 투입 수, 현재 보수해야되는 지점, 보수 여부 
    public void gogo(int n, int[] weak,int cnt,int index,boolean[] visit){
        
        if(cnt>=ans) return;
        if(visit[index]) return;
        
        visit[index] =true;// 현재 보수 해야되는 지점 방문 
        int next =0;
        for(int i =0; i<weak.length;i++){
            next = (index+i)%weak.length; // 다음 보수해야되는 지점
            if(visit[next]) continue; // 방문했으면 넘어감. 
            int dis = weak[next]-weak[index];// 거리는 다음지점 - 처음 시작점
            if(next<index) dis+=n;// 위치 역전시 값 더해주면됨. 
            if(pp[cnt-1]<dis) break; // 갈수 없는 거리라면 중단하면됨
            visit[next]=true; // 갈수 있으면 참으로 
        }
        index =next; // 중단 되면 다음 방문해야되는 곳. 계속했을떄는 종료될꺼임.
        int num = 0; // 다 방문했는지 수 세기 
        for(int i=0; i<visit.length;i++){
            if(visit[i]) num++;
        }
        if(num == visit.length) {
            ans = Math.min(cnt,ans);// 최소인지 비교
            return;
        }else{
            gogo(n,weak,cnt+1,index,visit);
        }
        
    }
    
    public int solution(int n, int[] weak, int[] dist) {
        // 우선 해당 부분의 시작으로 돌면서 체크 할 수 있는 것 생각
        // 인원수의 최대는 8명 입니다.// 역순으로 도렬야 됩니다. 
        Arrays.sort(weak); // 작은 순으로 
        Integer[] temp = Arrays.stream(dist).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());       
        pp = Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
        
        int answer = 0;
        for(int i=0; i<weak.length;i++){
            boolean[] visit = new boolean[weak.length]; // 부족한것 방문했는지
            gogo(n,weak,1,i,visit);            
        }
        answer= ans;
        return answer;
    }
}
	
*/
/* 내가 푼것. 어디가 틀릴까 훔... 
import java.util.*;
class Solution {
    
	static int min =(int)1e9;
	public static long solution(int n, int[] weak, int[] dist) {
    	// 외벽길이, 취약 지점으로 부터 거리 배열, 각 친구가 이동 할 수 있는 거리 
        // 원형 n미터 외벽, 주기적 1시간의 검사 , 친구가 1시간동안 이동거리가 다르다. 
        // 최소한의 친구 투입으ㅗ 내부 곰사 돕는다. 
        // 정북이 0, 시계방향으로의 거리, 친구는 앞뒤로 다 이동이 가능,   
    	// 친구 는 총 8명. 
    	long answer = 0;
    	
    	Arrays.sort(dist);
    	Arrays.sort(weak);
    	
    	for(int i =0; i<weak.length;i++) {
    		boolean[] visit = new boolean[weak.length];
    		sol(n,weak,dist,1,i,visit);
    		// 친구 수, 위치, 방문 가능 여부; 
    	}
    	
    	answer = min;
        return answer;
    }

	// 현재 사용된 친구수 즉(친구 dist거리 측정가능)  , 현 취기 
	private static void sol(int n, int[] weak, int[] dist, int cnt, int index, boolean[] visit) {
	
		if( cnt>min) return;
		if(cnt>dist.length) return;
		if(visit[index])sol(n,weak,dist,cnt,(index+1)%weak.length,visit); // 만약 전에 방문처리가되어 있었다면 그냥 넘어가지 
			
		visit[index] =true; // 현위치는  무조건 방문 
		for(int i=0; i<weak.length;i++) {
			
			int next = (index+i)%weak.length; // 다음위치, 넘어갈 경우에 대비해서
			if(visit[next]) continue;
			int dif = weak[next] -weak[index];
			if( next<index) dif+=n; // 넘어 간 경우는 좋길이 더해 주면댐
			if( dif > dist[dist.length-cnt]) break;
			visit[next]= true;
		}
		int count = 0;
		for(int i=0; i<visit.length;i++) {
			if(visit[i]) count ++;
		}
		if(count ==visit.length) {
			min =Math.min(min, cnt);
			return;
		};
		sol(n,weak,dist,cnt+1,(index+1)%weak.length,visit);
		
	}

}

*/
