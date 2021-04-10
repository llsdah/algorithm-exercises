package studyProgrammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 메뉴리뉴얼카카오2021 {

	public static void main(String[] args) {

		int m = 6;
		//String[] order = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		String[] order = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		//String[] order = {"XYZ", "XWY", "WXA"};
		int[] course = { 2, 3, 5 };

		String[] result = solution(order, course);
		System.out.println("result : " + Arrays.toString(result));
	}
	static HashMap<String,Integer> map = new HashMap<String, Integer>();
	static int[] max;
	static int[] nums;
	static String words;
	public static String[] solution(String[] orders, int[] course) {
		
		
		max =new int[course.length];
		
		char[] word;
		
		for( int i =0; i<orders.length;i++) {
			
			word = orders[i].toCharArray();
			Arrays.sort(word);
			boolean[] visited = new boolean[word.length];
			// n = word의 길이  r course[i]
			for( int k= 0 ; k< course.length  ;k++) {
				
				if( word.length >= course[k]) {
						combination(word,visited,0,word.length,course[k] );
						System.out.println("course[k] : " + course[k]+" word : "+orders[i]);
				}
			}
			
		}
		
		Set<String> st = map.keySet();
		Iterator<String> lt=st.iterator();
		Iterator<String> it = map.keySet().iterator();
		
		String menu="";
		for( int i =0; i<st.size();i++) {
			menu =lt.next();
			for( int k=0; k<course.length;k++) {
				
				if( menu.length()==course[k]) {
					max[k] = Math.max(map.get(menu), max[k]);
				}
				
			}			
		}
		
		String result = "";
		for( int i =0; i<st.size();i++) {
			menu =it.next();
			for( int k=0; k<max.length;k++) {
				
				if( menu.length()==course[k]&&map.get(menu)==max[k] &&max[k]>=2) {
					System.out.println("max[k]" +max[k]);
					System.out.println("menu : "+menu +"  map.get : "+map.get(menu));
					
					
					result+=menu+",";
				}
				
			}			
		}
		
		result =result.substring(0,result.length()-1);
		String[] answer = result.split(",");
		Arrays.sort(answer);
		return answer;
	}

	private static void combination(char[] word, boolean[] visited, int start, int n, int r) {

		if( r==0) {
			print(word,visited,n);
			return;
		}
		
		for( int i =start; i<n;i++) {
			visited[i] = true;
			combination(word,visited,i+1,n,r-1);
			visited[i]=false;
		}
		
	}

	
	private static void print(char[] word, boolean[] visited, int n) {
		String temp ="";
		int count=1;
		for(int i =0; i<n;i++) {
			if(visited[i]) {
				temp+=word[i]+"";
			}
		}
		
		System.out.println("temp : "+ temp );
		
		
		if( map.get(temp)!=null) {
		
			map.put(temp, map.get(temp)+1);
		}else {
			map.put(temp,count);
		}
		
	}

	
}


/* 카카오 나의 풀이 

		static List<Map<String,Integer>> foodMaps =new ArrayList<>();
		static int[] maxCnt = new int[10];
		public static String[] solution(String[] orders, int[] course) {
	        // 한손님의 단뭎메뉴 갯수는 최대 10개
	        for( int i =0; i< 11; i++) {
	        	foodMaps.add(new HashMap<String,Integer>());
	        }
	        
	        // 정렬이 필요하다 
	        for( String str:orders) {
	        	char[] arr = str.toCharArray();
	        	Arrays.sort(arr);
	        	comb(arr,0,new StringBuilder());
	        }
	    
	       List<String> list = new ArrayList<>();
	        for( int len : course) {
	        	
	        	for ( Map.Entry<String, Integer> entry : foodMaps.get(len).entrySet()) {
	        		
	        		// entry쌍이니가 getKey, getValue 둘다 있다. 
	        		if(entry.getValue() >= 2&& entry.getValue()==maxCnt[len]) {
	        			list.add(entry.getKey());
	        		}
	        		
	        	}
	        }
	        
	        //오름차순 정렬
	        Collections.sort(list);
	        
	        
	        
	        String[] answer = new String[list.size()];
	        for(int i=0; i< list.size();i++) {
	        	answer[i]= list.get(i);
	        }
	        return answer;
	    }
		
		// 
		private static void comb(char[] str, int pos, StringBuilder candi) {
			
			
			if( pos>= str.length) {
				int len = candi.length();
				// 길이가 2개 이상인 경우에만 저장하면됨.
				if( len>=2) {
					int cnt = foodMaps.get(len).getOrDefault(candi.toString(),0)+1;
					foodMaps.get(len).put(candi.toString(),cnt);
					maxCnt[len] = Math.max(maxCnt[len], cnt);
				}
				return;
			}
			
			// 선택하는 것 이다.
			comb(str,pos+1,candi.append(str[pos]));
			// 선택했다 그래서. 복원
			candi.setLength(candi.length()-1);
			//선택 안함. 
			comb(str,pos+1,candi);
			
			
		}



*/