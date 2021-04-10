package studyProgrammers;

import java.util.Arrays;

/*

여행경로
문제 설명
주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 
항상 "ICN" 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 
방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

입출력 예
tickets	
return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	
["ICN", "JFK", "HND", "IAD"]


[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	
["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

입출력 예 설명
예제 #1
["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.

예제 #2
["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 
["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.

 */
public class DFS_BFS4 {

	public static void main(String[] args) {
		
		
	//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
	//String[] result = solution(tickets);

	String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}} ;
	String[] result = solution(tickets);
		
	System.out.println(Arrays.toString(result));
	
	}
	
	
	static boolean[] check;
	static int count;
	static String place;
	static String[] answer;
	public static String[] solution(String[][] tickets) {
	    // 행 수만큼 체크 간지 안간지 
		check = new boolean[tickets.length];
		place ="ICN";
		count = 0;		
		answer= new String[tickets.length+1];
		
		answer[count]= place;
		count++;
		
		
		for( int i =0;i< tickets.length;i++ ) {
			place=placeCount(place,tickets);
		}  
		
	    return answer;
	}
	
	// 장소의 갯 수 파악 
	private static String placeCount(String place, String[][] tickets) {

		String test ="";
		// 어딜 방문할지 방문 했으면 true 값으면 변경할 것 
		int number = -1;
		for( int k =0; k < tickets.length;k++) {
			// 해당 번호를 찾은 경우 
			if( tickets[k][0].equals(place)&&!check[k]) {
				// 없으면 첫번쨰꺼 
				if(test.equals("")) {
					test = tickets[k][1];
					number = k ;
				} 
				// 여러개 있는 중에 가장 앞에서 
				if(test.compareTo(tickets[k][1]) >= 0 ) {
					test = tickets[k][1];
					number = k ;
				}
			}
		}// 무엇을 갈지 반환 그리고, 이게 몇번쨰 꺼인지도 반환해야되는데!
		
		check[number]= true;
		answer[count]= test;
		count++;
		
		return test;
	}// 섬 찾기 
	
}
