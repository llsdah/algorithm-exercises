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
    	// 외벽길이, 취약 지점으로 부터 거리 배열, 각 친구가 이동 할 수 있는 거리 
        // 원형 n미터 외벽, 주기적 1시간의 검사 , 친구가 1시간동안 이동거리가 다르다. 
        // 최소한의 친구 투입으ㅗ 내부 곰사 돕는다. 
        // 정북이 0, 시계방향으로의 거리, 친구는 앞뒤로 다 이동이 가능,   
    	// 친구 는 총 8명. 
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
}
