package studyProgrammers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*

n개의 음이 아닌 정수가 있습니다. 
이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 
다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

사용할 수 있는 숫자가 담긴 배열 numbers, 
타겟 넘버 target이 매개변수로 주어질 때 숫자를 
적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 
return 하도록 solution 함수를 작성해주세요.

제한사항

주어지는 숫자의 개수는 2개 이상 20개 이하입니다.

각 숫자는 1 이상 50 이하인 자연수입니다.

타겟 넘버는 1 이상 1000 이하인 자연수입니다.

입출력 예
numbers				target		return
[1, 1, 1, 1, 1]		3				5


*/

public class DFS_BFS1 {
	public static void main(String[] args) {

		int[] numbers = {1,1,1,1,1};
		
		int target = 3;
		
		int result = solution(numbers,target);
		
		System.out.println("result : "+result);
		
	}
	
	
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers,0,0,target);
        
        
        return answer;
    }


	private static int dfs(int[] numbers, int node, int sum, int target) {

		
		if(node ==numbers.length) {
			return sum ==target ? 1:0;	
		}
		
		
		return dfs(numbers, node+1,sum+numbers[node],target)
				+dfs(numbers,node+1,sum-numbers[node],target);
	}
    
    
}


/*


	// 진짜 현재 답만 나오는 방법
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        Integer[] arrTarget  =new Integer[numbers.length];
        
        int count =0;
        
        for( int i=0; i<arrTarget.length;i++) {
        	arrTarget[i] = numbers[i];
        	
        }
        
       Arrays.sort(arrTarget,Comparator.reverseOrder());
        
       //Collections.sort(arrTarget, (o1,o2) -> o1-o2);
        
        for( int i =0;i<arrTarget.length;i++) {
        	
        	if(target>=0) {
        		System.out.println("조건 충촉시 "+target+"과 arr"+arrTarget[i]);
        		target = target-arrTarget[i];
        		continue;
        	}
    		System.out.println("조건 미중촉 "+target+"과 arr : "+arrTarget[i]);

        	target = target+arrTarget[i];
        	count++;
        }
        
        if(target==0) {
        	
        	System.out.println("정답입니다.");
        }else {
        	System.out.println("target + "+ target);
        }
        System.out.println("cont : "+count);
        
        
        answer = fact(numbers.length)/(fact(numbers.length-count)*fact(count));
        
        System.out.println("anserw : "+answer);
        return answer;
    }
    
    private static int fact(int n) {
    	if(n<=1) {
    		return n;
    	}else {
    		return fact(n-1)*n;
    	}
    }






*/