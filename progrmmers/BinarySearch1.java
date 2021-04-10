package studyProgrammers;

import java.util.Arrays;

/*

입국심사 


문제 설명
n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 
각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.

처음에 모든 심사대는 비어있습니다. 
한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 
가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 
하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.

모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.

입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때,
모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
심사관은 1명 이상 100,000명 이하입니다.

입출력 예
n			times			return
6			[7, 10]			28

입출력 예 설명
가장 첫 두 사람은 바로 심사를 받으러 갑니다.

7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.

10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.

14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.

20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고
1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.

*/

public class BinarySearch1 {
	
	public static void main(String[] args) {

		int n= 6;
		int[] times = {7,10,8};
		
		long result = solution(n,times);
		System.out.println("result : " + result);
	}
	
    public static  long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);// 분류 한번하기 
        
        long left =0;
        // 가장 오래 걸릴 경우 
        long right = (long) n*times[times.length-1];
        
        while(left <= right) {
        	long mid =(left+right)/2;
        	System.out.println("mid : "+ mid);
        	long sum =0; 
        	
        	for(int i =0; i<times.length;i++) {
        		sum +=mid/times[i];
        		System.out.println("sum : "+ sum);
        		System.out.println();
        	}
        	// 해야되는 사람보다 적게 하면 시간을 늘려야댐 외쪽에서 늘려서 오면댐
        	if( sum < n ) {
        		left = mid +1;
        		
        	}else {
        		// 해야되는 사람보다 많이 하면 시간을 줄여야댐 오른쪽에서 줄려오면됨 
        		right = mid-1;
        		answer =mid;
        	}
        	
        	System.out.println("(left <= right "+ left +"right"+right );
        	
        }
        
        return answer;
    }


}


/*

static int[] person;
static int number ;
public static long solution(int n, int[] times) {
	long answer = 0;
	person = new int[times.length];
	number = n;
	
	// 새로운거 한개 만들기 
	for(int i =0; i<times.length;i++) {
		person[i]=times[i];
	}
	
	// 일단 정상 상환 사람 수만큼 들어 가있다. 
	number+= -times.length;
	// 한명씩 넣어보기 마지막 한명 전까지만 
	for(int i =1; i<number;i++) {
		check(i,times);
		
	}
	
	// 마지막 1명 
	answer =person[0]+ times[0];	
	
	for( int i =0; i < times.length;i++) {
		answer = Math.min(answer, times[i]+person[i]);
	}
	
	return answer;
}

private static void check(int count,int[] times) {
	int min= person[0];
	
	// 최소값 찾기 
	for(int i =0; i < person.length;i++) {
		
		min = Math.min(min, person[i]);
		
	}
	
	for(int i =0; i<person.length;i++) {
		
		if( person[i]==min) {
			person[i]= person[i]+times[i];
			return;
		}
	}
	
}
*/