package studyProgrammers;

import java.util.Arrays;
import java.util.Stack;

/*

 문제 설명
초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

제한사항
prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.

입출력 예
prices				return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]

입출력 예 설명
1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.

 
 */

//stack으로 입력 후 하나씩 끝에서 부터 하나씩 뽑아 내서 비교하는데 ! 큰것만 1씩 더해 주면되겠지?

// 효율성 테스트 시간 초과... ㅠㅠ
public class StackQueue1 {
	public static void main(String[] args) {

		int[] prices = new int[] {1, 2, 3, 2, 3};
		int[] def = solution(prices);
	}
	 // 시작이후 부터 몇초간 가격이 떨어지지 않나요?
	// 바로 다음에 가격이 떨어 질 경우에 1초 동안 유지한것으로 판단 한다.  
	//3번째에서 4번째 이동시 가격이 떨어졌지만 1초 유지
    public static int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
        Stack<Integer> pricesNumber = new Stack<Integer>();
        // 가격 넣기 
        for(int i=0;i<prices.length;i++) {
           	pricesNumber.push(prices[i]);
        }
        // 몇초유지
        int count =0;
        // Stack 값 임시 저장
        int temp=0;
        //System.out.println("pricesNumber SIze : " + pricesNumber.size());
        // pricesNumber.size()?
       
        //반복횟수 
        for(int i=0; i <prices.length ;i++) {
        	
        	temp = pricesNumber.pop();
        	//System.out.printf("몇 번쨰 : %d, 출력값 : %d\n",i,temp);
        	
        	//자신의 순서 이후만 비교 
        	for(int h=0; h<prices.length ;h++) {
        		// 작아지면 1올리기
        		if( (prices.length-1-i)<=h&&temp<=prices[h]) {
        			count++;
        		} else if ((prices.length-1-i)<=h&&temp>prices[h]){ // 자신 순서 이후에 값이 작아지는 순간 그만하는 대신 초는 증가.
        			count++;
        			break;
        		}
        	}
        	// Stack이 역순이라 역순으로 초를 입력한다.
        	// 자기 자신의대한 촉값은 뺀다.
        	answer[(prices.length-1-i)]=count-1;
        	count=0;
        }
    
    	System.out.println(Arrays.toString(answer));
    	return answer;
    }
}























