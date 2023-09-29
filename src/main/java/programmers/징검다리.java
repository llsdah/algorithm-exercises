import java.util.*;
class Solution {	// 내가 찾을 최대값이 즉 너무 큰 숫자이며 범위가 넓으니 일단 
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
     
        int st = 1;
        int end= distance;
        int mid = 0; // 내가 찾을 값이다. 
        
        while( st<=end) {
        	int cnt = 0;
        	int prev =0; // 어디서 부터 시작 해야되는지의 값 
        	mid = (st+end)/2;
        	for(int i = 0;i<rocks.length;i++) {
        		if(rocks[i]-prev<mid) // 내가 찾을 값보다 더 찾은 값이 존재 한다면.  
        			cnt++;// 돌하나 제거 합니다. 
        		else // 내가 찾는 값보다 크거나 값다 !
        			prev = rocks[i];// 돌을 이동시킵니다. 
        	}
        	
        	// 마지막 돌과 내 지점 사이의 거리 확인
        	if( distance - prev<mid) cnt++;
        	if(cnt<=n) { // 주어진 돌 삭제 갯수보다 작으면 돌을 없애서 
        		// 최솟값 을 만들 수 있다. 
        		answer = mid > answer ? mid : answer;
        		st = mid+1;
        	}else end = mid-1;// 돌을 덜 삭제 해야되므로 찾는 최대 값을 줄이자 .
        	
        }
        
        
        return answer;
    }
}

/* 처음에 정렬을 통해 계속 접근하는 방식 ... 시간 초과 . 
 public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int[] arr = new int[rocks.length+2];
        for(int i =1;i<=rocks.length;i++){
            arr[i] = rocks[i-1];
        }
        arr[arr.length-1] = distance;
        System.out.println(Arrays.toString(arr));
        int[] cnt = new int[arr.length-1];
        for(int i=0; i<cnt.length;i++){
            cnt[i] = arr[i+1]-arr[i];
        }
        System.out.println(Arrays.toString(cnt));
        
        
        return answer;
    }
*/
