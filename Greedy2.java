package studyProgrammers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*

조이스틱

문제 설명
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동

예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.

따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 
조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
입출력 예
name	return
JEROEN	56
JAN	23

*/


public class Greedy2 {

	public static void main(String[] args) {
		
		String name = "JEROEN";
		
		int answer =solution(name);
		
		System.out.println(answer);
		
		
	}
	

    public static int solution(String name) {
        int answer = 0;
        int count1=0;	
        int count2=0;	
        
        
        Queue<Integer> que = new LinkedList<Integer>();
        Stack<Integer>	stk = new Stack<Integer>();
        
        
        for(int i=0; i<name.length();i++) {
        	if(i>=1) {
        	  	que.offer(name.charAt(i)-'A');
            	stk.add(name.charAt(i)-'A');  		
        	};
      
        	answer += name.charAt(i)-'A' >=  'Z'-name.charAt(i)+1 ? 'Z'-name.charAt(i)+1 : name.charAt(i)-'A';
        	System.out.printf("%s-'A' =  '%d' ,실제 값 =  '%d' \n",name.charAt(i),name.charAt(i)-'A' >=  'Z'-name.charAt(i) ? 
        			'Z'-name.charAt(i) : name.charAt(i)-'A' ,name.charAt(i)-'A' );
        }
        
        int temp1=0;
        int temp2=0;
        
        int number1=0;
        int number2=0;
        
        for(int i=0;i<name.length()-1;i++) {
        	temp1 =que.poll();
        	System.out.println("temp1 : "+temp1);
        	if(temp1==0) {
        		count1++;
        		
        	}else if (count1>=1) {
        		number1+=(count1+1);
        	
        	}else {
        		number1++;
        	}
        	
        	temp2 =stk.pop();
        	System.out.println("temp2 : "+temp2);
        	
        	if(temp2==0) {
        		count2++;
        		
        	}else if (count2>=1) {
        		number2+=(count2+1);
        	
        	}else {
        		number2++;
        	}
        		
        }
        
        System.out.println("number2 : "+number2 +" number1 : "+number1);
        answer += (number1>=number2 ? number2 : number1);
                
        return answer;

    }
}
