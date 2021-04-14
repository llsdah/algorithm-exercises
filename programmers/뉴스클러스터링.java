package studyProgrammers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class A_Test {

	public static void main(String[] args) {

//		String str1 = "handshake";
//		String str2 = "shake hands";

//		String str1 = "FRANCE";
//		String str2 = "french";

		String str1 = "aa1+aa2";
		String str2 = "AAAA12";

		int result = solution(str1, str2);
		System.out.println("result : " + result);
		// System.out.println("result : " + Arrays.toString(result));
		// System.out.println("result : "+ Arrays.deepToString(result));
	}

	// 자카드 유사도
	
	static HashMap<String,Integer> map1 = new HashMap<String,Integer>();
	static HashMap<String,Integer> map2 = new HashMap<String,Integer>();
	public static int solution(String str1, String str2) {

		// 교집합 / 합집합 = , 공집합일 경우 1 로 정의
		// 교집합은 진짜 공통 합집합은 전체다 더한것
		// 특수문자 제회,
		// 65536 곱하고 소수점 버리고 정수부만 출력
		int answer = 1;
		int num = 65536;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// 구분하기 위한 것 한개 넣어놓음 
		map1.put(str1,1);
		map2.put(str2,1);

		String[] arr1 = arr(str1);
		String[] arr2 = arr(str2);
		
		
		// 문자열 분류 완료  교집합은 hachmap 카운트, 
		
		int sum =0;
		int min =0;

		//공통적인것.. 그런데 합치는 것?
		for( int i =0; i< arr1.length;i++) {
			
			if(map2.get(arr1[i])!=null &&map1.get(arr1[i])!=-1 ) {
					min += (Math.min(map2.get(arr1[i]), map1.get(arr1[i])));					
					map1.put(arr1[i],-1);
					
			}
			
		}
		map1.clear();
		map1.put(str1,1);
		arr1 = arr(str1);
		
		for( int i =0; i< arr1.length;i++) {
			
			if(map2.get(arr1[i])!=null && map1.get(arr1[i])!=-1 ) {
					
				System.out.println("Math.max(map2.get(arr1[i]), map1.get(arr1[i]) : "
						+ Math.max(map2.get(arr1[i]), map1.get(arr1[i])));
				sum += ( Math.max(map2.get(arr1[i]), map1.get(arr1[i])));					
					
					
					map1.put(arr1[i],-1);
			}else if(map1.get(arr1[i])!=-1) {
				sum+=map1.get(arr1[i]);				
			}
			
			
		}
		
		for( int i =0; i< arr2.length;i++) {
			
			if(map1.get(arr2[i])!=null) {
				continue;
			}
			
			sum += map2.get(arr2[i]);
			
			System.out.println("map2.get(arr2[i] : "+ map2.get(arr2[i]));
			
		}
		
		
		
		
		Arrays.sort(arr2);
		
		Arrays.sort(arr1);
		
		System.out.println("min : " + min);
		System.out.println("sum : " + sum);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		
		answer = (int)(((double)min/sum)*num);
		return answer;
	}

	private static String[] arr(String str1) {
		Queue<String> que = new LinkedList<String>();		
		for(int i =0; i < str1.length()-1;i++) {
      // 정규식으로 하고 싶은데..			
			System.out.println(str1.substring(i,i+2).contains("[0-9]"));
			if( str1.substring(i,i+2).contains("[-+.^:,=*#$%&0-9]") ) {
				i++;
				continue;
			}else if( str1.substring(i,i+2).contains(" ") ) {
				i++;
				continue;
			}
			
			
			
			que.add(str1.substring(i,i+2));
			
		}

		String[] arr = new String[que.size()];
		int idx =0;
		Iterator<String> it = que.iterator();
		
		while(it.hasNext()) {
			arr[idx] = it.next();
			
			if( map1.get(str1)!=null) {
				
				if(map1.get(arr[idx])!=null) {
					map1.put(arr[idx],map1.get(arr[idx])+1);
				}else {
					map1.put(arr[idx],1);
				}
			}else if( map2.get(str1)!=null) {
				
				if(map2.get(arr[idx])!=null) {
					map2.put(arr[idx],map2.get(arr[idx])+1);
				}else {
					map2.put(arr[idx],1);
				}
			}
			
			idx++;
		}
		
		return arr;
	}

}
