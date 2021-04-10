package studyProgrammers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 이중우선순위큐
문제 설명
이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어	수신 탑(높이)

I 숫자		큐에 주어진 숫자를 삽입합니다.
D 1		큐에서 최댓값을 삭제합니다.
D -1		큐에서 최솟값을 삭제합니다.

이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 
모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 
[최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

제한사항
operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
operations의 원소는 큐가 수행할 연산을 나타냅니다.

원소는 “명령어 데이터” 형식으로 주어집니다.
- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.


입출력 예
operations							return
["I 16","D 1"]						[0,0]
["I 7","I 5","I -5","D -1"]		[7,5]


입출력 예 설명
16을 삽입 후 최댓값을 삭제합니다. 비어있으므로 [0,0]을 반환합니다.
7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다.

출처

 */


public class Heap3 {
	
	public static void main(String[] args) {
		//String[] operations = {"I 7","I 5","I -5","D -1"};
		//[I 16,D 1]
		
		//	["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
		//기댓값 〉	[0, 0]
		
		//String[] operations = {"I 16","D 1"};
		
		//String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		
		//[I 4, I 3, I 2, I 1, D 1, D 1, D -1, D -1, I 5, I 6]
		String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
		
		int[] aaa = solution(operations);
		System.out.println(Arrays.toString(aaa));
    
	}
	public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        // 삽입 할게 몇개지?
        int count =0;
        
        Queue<Integer> number = new PriorityQueue<Integer>();
        Queue<Integer> reNumber = new PriorityQueue<Integer>((x,y) -> y-x);
        
        for(int i=0; i<operations.length;i++) {
        	  
        	if( (operations[i].charAt(0)+"").equals("I") ) {
        	
        		int temp = Integer.valueOf(operations[i].substring(1).trim());
        		number.offer(temp);
        		reNumber.offer(temp);
        		count++;
        		System.out.println("값 입력 : "+temp);
        		
        	}else if (operations[i].equals("D -1")) {
				while(!number.isEmpty()) {
					number.poll();
					count--;
					System.out.println("최소값 삭제");
					break;
				};
        	}else if(operations[i].equals("D 1")) {
        		while(!reNumber.isEmpty()) {
					reNumber.poll();
					count--;
					System.out.println("최대값 삭제");
				break;
        		};
        	};
        	
            if (count==0) {
        		while(!number.isEmpty()) {
					number.poll();
				};
				while(!reNumber.isEmpty()) {
					reNumber.poll();
				};
			};
        
        	System.out.println(" i 번호 : "+ i);
        }; //for문
        
        
        
        
        if( reNumber.isEmpty() || number.isEmpty() || (count <=0) ) {
        	answer[0] =0;
        	answer[1] =0;
        }else {
        	//[최댓값, 최솟값]
        	answer[0] = reNumber.poll();
        	answer[1] = number.poll();	
        };
        
        return answer;
    }
}
