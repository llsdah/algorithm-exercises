package studyProgrammers;

import java.io.FileReader;
import java.nio.channels.NonWritableChannelException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

/*
 
 문제 설명
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0				[]						[]							[7,4,5,6]
1~2			[]						[7]						[4,5,6]
3				[7]					[4]						[5,6]
4				[7]					[4,5]						[6]
5				[7,4]					[5]						[6]
6~7			[7,4,5]				[6]						[]
8				[7,4,5,6]			[]							[]
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 
다리가 견딜 수 있는 무게 weight, 
트럭별 무게 truck_weights가 주어집니다. 
이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.

입출력 예
bridge_length	weight	truck_weights									return
2						10			[7,4,5,6]											8
100					100		[10]													101
100					100		[10,10,10,10,10,10,10,10,10,10]		110
 
 
 */

public class StackQueue3 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight =10;
		int[] truck_weights = {7,4,5,6};
		
		int ans = solution(bridge_length,weight,truck_weights);
	
	}

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> truck =new LinkedList<Integer>();
        
        for(int i=0; i<truck_weights.length;i++) {
        	truck.add(truck_weights[i]);    	
        };
        
        int[] arrCount = new int[bridge_length*truck_weights.length+1];
        int temp =0; // 현재 출력될 무게 저장용
        int count =0; // 몇번째 값 출력했는지 
        int sum = 0; // 올라가는 무게 저장용도 함계
        int number =0; // 몇번쨰 넣어야 되는지.
        
        int overlap =0; //갯수 계산
        int sub =0; // 중복 부분 제거
       
        
       
      
        boolean check = false;
        //트럭이 있는지
        while(truck.peek()!=null) {
        	// 1번쨰
        	
        	sum=truck.poll();
        	count++;
        	overlap++;
            System.out.println("sum :"+sum);
        	// 이게 끝나면 배열에 넣기 
        	 while(!check) {
        		 
        		 if(truck.peek()!=null) {
        			 temp = truck.peek()+sum;
        		 }else {
        			 for(int i=number;i<bridge_length*count;i++) {
     	             	arrCount[i] =sum;
     	             	number=i+1;
     	             	System.out.println("number : "+number);
        			 };
        			 System.out.println("overlap : "+ overlap);
        	         sub+=(overlap-1);
        	         check=true;
        			 break;
        		 };
        		 
        		 System.out.println("temp :"+ temp);
        		 if ( weight >= temp ) {
        			sum+=truck.poll();
        			count++;
        			overlap++;
        			System.out.println("count :"+ count);
        		 }else if (weight < temp) {
        			 System.out.println("break");
        			 
        			 for(int i=number;i<bridge_length*count;i++) {
        	             	arrCount[i] =sum;
        	             	number=i+1;
        	             	System.out.println("number : "+number);
        	             	
        	         };
        	         System.out.println("overlap : "+ overlap);
        	         
        	         sub+=(overlap-1);
        	         check=true;
        			 break;
        		 };
        		 
        	 };
        	 
        	 System.out.println();
        	 check=false;
        	 sum=0;
        	 overlap=0;
        };
        System.out.println("sub : "+sub);
        System.out.println(Arrays.toString(arrCount));
        System.out.println(Arrays.stream(arrCount).filter(i-> i!=0).count());
        //처음 초 더하고 중복된 초 빼기;
        answer = (int) (1+Arrays.stream(arrCount).filter(i-> i!=0).count()-sub);
        System.out.println(answer);
        return answer;
    }
}



/*
 

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0, i = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int j = 0; j < bridge_length; j++) {
            q.offer(0);
        }
        
        while (!q.isEmpty()) {
            int popped = q.poll();
         
            sum -= popped;
            if (i < truck_weights.length) {
                if (sum + truck_weights[i] <= weight) {
                    q.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    i++;
                } else {
                    q.offer(0);
                }
            }
            answer++;
        }
        
        return answer;
    }
}

 
//---------------------------------------
 
 import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer, i, total;
        answer = i = 0;
        Queue<Integer> onbridge = new LinkedList<Integer>(); //다리위에 있는 트럭
        int[] count = new int[truck_weights.length]; //몇초동안 지났는가

        //1초
        answer++;
        count[i]++;
        onbridge.add(i);
        total = truck_weights[i]; //다리 위 트럭의 무게 총합

        //2초부터
        while(!onbridge.isEmpty()) {
            int temp_peek = onbridge.peek();
            //다리를 다 지난 트럭 삭제
            while(count[temp_peek] == bridge_length) {
                onbridge.poll();
                total -= truck_weights[temp_peek];
                if(!onbridge.isEmpty()) temp_peek = onbridge.peek();
                else break;
            }

            //다음 트럭 무게 확인
            //참고로 while로 돌렸다가 오답. 한번에 한대씩!
            if(i < truck_weights.length - 1 && total + truck_weights[i + 1] <= weight) {
                i++;
                onbridge.add(i);
                total += truck_weights[i];
            }

            //count 늘려주기. if를 걸어주지 않으면, 마지막에 비었을 때 peek()이 실행되면서 NullPointException을 던져버린다. 주의
            if(!onbridge.isEmpty()) {
                temp_peek = onbridge.peek();
                for(int j = temp_peek; j <= i; j++) count[j]++;
            }

            answer++;
        }
        return answer;
    }
}
 

 */