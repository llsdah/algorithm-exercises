package studyProgrammers;

import java.util.Arrays;

public class A_Test {

	public static void main(String[] args) {

		String begin = "abab";
		String tar = "cog";
//		String[] ar = { "hot", "dot", "dog", "lot", "log", "cog" };
//		String[] ar = { "hot", "dot", "dog", "lot", "log"};
//		String[] ar = { "hot", "dot", "dog", "lot", "log"};

		int result = solution(begin);
		System.out.println("result : " + result);
	}

	static int cut;
	static int min =1000;
	private static int solution(String s) {
		//제일 앞에서 부터 문자열을 잘라서 일치해된다.  중간에 띄우기 없다.
		
		// 최대 자를 수 있는 수 
		cut = s.length()/2;
		System.out.println(s);
		System.out.println(s.length());
		System.out.println();
	
		if(s.length()==1) {
			return 1;
		}
		for(int i =1; i<=cut;i++) {
			
			sut(s,i);
			
		}
		
		
		
		int answer = min;
		return answer;
	}
	private static void sut(String s, int st) {
		int nums = s.length()%st >= 1 ? s.length()/st+1 :
			s.length()/st;
		String[] arr = new String[nums];
		int pos =0;
		
		for(int i =0; i<s.length();i++) {
			
			if( s.length()-1 <i+st) {
				arr[pos] = s.substring(i);
				break;
			}
			
			arr[pos] = s.substring(i,i+st);
			i = i+st-1;
			pos++;
			
		}
		
		System.out.println(" arr : "+Arrays.toString(arr));
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<arr.length;i++) {
			int count =1;
			
			for(int k=i; k<arr.length;k++) {
				if(i==k) {
					continue;
				}
				if(arr[i].equals(arr[k])) {
					count++;
				}else {
					break;
				}
		
			}
			
			if(count<2) {
				sb.append(arr[i]);
			}else {
				sb.append(count+arr[i]);
				i= i+count-1;
			}
		
		}
		
		
		System.out.println(sb.toString());
		System.out.println();
		min =Math.min(min, sb.length());
		
			
	}

}
/*




*/
