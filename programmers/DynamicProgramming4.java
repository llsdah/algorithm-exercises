package studyProgrammers;


/*

도둑질

각 집들은 서로 인접한 집들과 방범장치가 연결되어 있기 때문에 인접한 
두 집을 털면 경보가 울립니다.

각 집에 있는 돈이 담긴 배열 money가 주어질 때, 도둑이 훔칠 수 있는 돈의 
최댓값을 return 하도록 solution 함수를 작성하세요.

제한사항

이 마을에 있는 집은 3개 이상 1,000,000개 이하입니다.

money 배열의 각 원소는 0 이상 1,000 이하인 정수입니다.

입출력 예

money						return

[1, 2, 3, 1]				4




*/

public class DynamicProgramming4 {
	
	public static void main(String[] args) {
		
		int[] money = {1,1000,0,1000,100};
		
		
		int result = solution(money);
		
		System.out.println("result : "+result);
		
	}
	
	public static int solution(int[] money) {
        int answer = 0;
        int[] dp1 =new int[1000000];
        int[] dp2 =new int[1000001];
        
        int length = money.length;
        
        dp1[0] = money[0];
        dp1[1]	=Math.max(money[0], money[1]); 
        
        for(int i=2;i<length;i++) {
        	dp1[i]= Math.max(dp1[i-2]+money[i],dp1[i-1]);
        }
        
        //마지막것을 훔치는 경우 
        dp2[1] =money[1];
        
        for(int i = 2; i<money.length;i++) {
        	dp2[i] =Math.max(dp2[i-2]+money[i],dp2[i-1]);	
        }
 
        answer = Math.max(dp1[length-2], dp2[length-1]);
        System.out.println(answer);
        return answer;
    }

}

/*

    public static int solution(int[] money) {
        int answer = 0;
        int max = 0;
        int fir = 0;
        int sec = 0;
       
        for(int i = 0; i<money.length;i++) {
        	fir =money[i];
        	
        	for( int k = 0;k<money.length;k++) {
        		
        		// 같은 번호면 계속해 
        		if(i==k) {
        			continue;
        		}
        		
        		// i 가 첫번쨰 일 경우 마지막 거안됨
        		if(i==0&&k==money.length-1) {
        			continue;	
        		}
        		
        		// 첫번째를 기준으로 인접 번호 
        		if( i-1==k || i+1==k) {
        			continue;
        		}
 
        		max = max > (fir+sec) ? max : fir+sec;
        	}
        	
        }
        
        answer =max ;	
        	
        return answer;
    }



*/