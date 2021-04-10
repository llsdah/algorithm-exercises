package studyProgrammers;

import java.util.Arrays;

public class PerfectSearch3 {

	public static void main(String[] args) {
		
		int brown = 24;
		int yellow = 24;
		
		int[] answer = solution(brown, yellow);
		
		
		System.out.println(Arrays.toString(answer));
		
		System.out.println((int)brown/5);
		
	}
	
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		
		//x가로 y세로
		int x=0;
		
		
		for( int i = 0; i <= (brown+yellow)/3+1; i++) {
			x = (brown-2*i+4)/2;
			
			if((x*i)==(brown+yellow)) {
				answer[0]=x;
				answer[1]=i;
				return answer;
			}
			
		}
		
		
		
		return answer;
	}
}