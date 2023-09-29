package studyProgrammers;

import java.util.ArrayList;
import java.util.Arrays;

public class A_Test {

	public static void main(String[] args) {

		String begin = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String tar = "cog";
//		String[] ar = { "hot", "dot", "dog", "lot", "log", "cog" };
//		String[] ar = { "hot", "dot", "dog", "lot", "log"};
//		String[] ar = { "hot", "dot", "dog", "lot", "log"};

		int n = 5;
		String[][] tttt= {{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
		              {"600","apeach","music","2"}};
		int result = solution(tttt);
		System.out.println("result : " + result);
		//System.out.println(Arrays.toString(result));
	}

	public static int solution(String[][] relation) {
		int answer = 0;
		int total = relation[0].length;
		
		for(int i =1; i<=total;i++) {
			
		}
		
		
		
		return answer;
	}

}















