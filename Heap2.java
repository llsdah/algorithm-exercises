package studyProgrammers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*


문제 설명
하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.

예를들어

- 0ms 시점에 3ms가 소요되는 A작업 요청
- 1ms 시점에 9ms가 소요되는 B작업 요청
- 2ms 시점에 6ms가 소요되는 C작업 요청
와 같은 요청이 들어왔습니다. 이를 그림으로 표현하면 아래와 같습니다.
Screen Shot 2018-09-13 at 6.34.58 PM.png

한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
Screen Shot 2018-09-13 at 6.38.52 PM.png

- A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
- B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
- C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.

하지만 A → C → B 순서대로 처리하면
Screen Shot 2018-09-13 at 6.41.42 PM.png

- A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
- C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
- B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.

각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)

제한 사항
jobs의 길이는 1 이상 500 이하입니다.
jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
입출력 예
jobs	return
[[0, 3], [1, 9], [2, 6]]	9
입출력 예 설명
문제에 주어진 예와 같습니다.

0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다.
1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다.
2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.


*/
public class Heap2 {

	public static void main(String[] args) {
		
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int a = solution(jobs);
		System.out.println(a);
		
	}
	
    public static int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        int time =0;
        int idx =0;
        
        Queue<int[]> q = new PriorityQueue<int[]>( (x,y) -> x[1] - y[1] );
        // 혹시 순서대로 배열울 안줄까봐 하는거 
        //Arrays.sort(jobs, (x,y) -> { return x[0]-y[0] ; }); 
        //System.out.println(Arrays.deepToString(jobs));
        
        Arrays.sort(jobs, (x,y) -> x[0]-y[0] ); 
        while(idx<len || !q.isEmpty()) {
        	
        	while (idx <len &&jobs[idx][0]<=time) {
        		q.offer(jobs[idx]);
        		System.out.println("index : "+ idx);
        		System.out.println("Q 넣기 : " +Arrays.toString(q.peek()) );
        		idx++;
        	
        	};
        	
        	if(q.isEmpty()) {
        		time =jobs[idx][0];
        		System.out.println("q가 비면 time : "+ time);
        	}else {
        		int[] job = q.poll();
        		System.out.println("job 배열 : " + Arrays.toString(job));
        		answer =answer + time -job[0]+job[1];
        		time = time+job[1];
        		System.out.println("time : "+ time);
			}
        	System.out.println();
        };
        return answer / len;
    }
}
/* 다른 사람 답 
 	public static int solution(int[][] jobs) {
		int answer = 0;
		int len = jobs.length;
		int time = 0;
		int idx = 0;
		Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		while (idx < len || !q.isEmpty()) {
			while (idx < len && jobs[idx][0] <= time)
				q.offer(jobs[idx++]);
			
			if (q.isEmpty())
				time = jobs[idx][0];
			else {
				int[] job = q.poll();
				answer += time - job[0] + job[1];
				time += job[1];
			}
		}
		
		return answer / len;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { {0, 3}, {1, 9}, {2, 6} }));
	}

 
 */


/*내가쓴거 
     public static int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        
        for(int i = 1;i<jobs.length;i++) {
        	test.offer(jobs[i][1] );
        };
        
        int substruct = 0;
        for(int i = 1;i<jobs.length;i++) {
        	substruct = substruct -jobs[i][0] ;
        };
        
        System.out.println("빼야될 값 : " + substruct);
        
        int sum = jobs[0][1];
        int count = 0;
        int[] leng = new int[jobs.length-1];
        
       
        while(!test.isEmpty()) {
        	sum += test.poll();
        	leng[count] = sum;
        	count++;
        };
        
        System.out.println("몇 뻔째 까찌? : "+ count);
        System.out.println("leng 배열 : "+Arrays.toString(leng));
        answer = jobs[0][1];
        for(int i =0; i<leng.length;i++) {
        	answer += leng[i];
        }
        
        answer = (answer+substruct)/jobs.length;
        System.out.println(" 값은 : " + answer);
        
        return answer;
    }
 */

