class Solution
{
    public int solution(int n, int a, int b)
    {
 		int answer = 0;
		while ( a!=b) {
			
            a = a%2==1 ? (a/2)+1 :a/2;
            b = b%2==1 ? (b/2)+1 :b/2;
            answer++;    
		}
		

		return answer;
    }
}

/* 기존 답 흠 천천히 한번더 해보자 . 
class Solution
{
    public int solution(int n, int a, int b)
    {
 		int answer = 1;
        if( a%2==1) a++;
		if( b%2==1) b++;
		while ( Math.abs(a-b)>1) {
			
			answer++;
            if( a%2==1) a++;
			if( b%2==1) b++;
            a=a/2;
            b=b/2;
                
                
		}
		

		return answer;
    }
}
*/
