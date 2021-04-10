package studyProgrammers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
문제 설명
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 
베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를
 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수
 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 
 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.

입출력 예
genres	plays	return
[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
입출력 예 설명
classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

고유 번호 3: 800회 재생
고유 번호 0: 500회 재생
고유 번호 2: 150회 재생
pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

고유 번호 4: 2,500회 재생
고유 번호 1: 600회 재생
따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 */

// 몇개의 장르가 있고? -> 장르의 출력순는 어떻게 되는지 .가 중요한 것이다. !
public class Hash4 {
	public static void main(String[] args) {

		String[] genres = { "classic", "pop", "asdasd", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 250 };
		String one = "classic";

		int[] number = number(genres, plays);

	}

	//// 몇개의 장르가 있고? -> 장르의 출력순는 어떻게 되는지 .가 중요한 것이다. !
	private static int[] number(String[] genres, int[] plays) {
		//값계산은 위한 수식
		HashMap<String, Integer> map = new HashMap<>();
		//key 순서 value play
		HashMap<Integer, Integer> play = new HashMap<>();
			
		// 어느것이 큰지 알아 봅니다.!
		for (int i = 0; i < genres.length; i++) {

			if (!map.containsKey(genres[i])) {
				map.put(genres[i], plays[i]);
			} else { // 포함하고 있으면
				map.replace(genres[i], map.get(genres[i]) + plays[i]);
			}
			
			play.put(i,plays[i]);
		}
		System.out.println(play.entrySet());

		// 키 값 저장한 변수 만듬. 굳이 이렇게 한하고 같은거 위에서 같은거 저장안하고 다른것만 저장 하는것으로 했어도 되었을거 같다.
		// str이 순서 관리 할 거이다.
		String[] str = new String[map.size()];
		Iterator it = map.entrySet().iterator();

		int mapSize = 0;
		while (it.hasNext()) {
			Map.Entry e = (Entry) it.next();
			str[mapSize] = (String) e.getKey();
			mapSize++;
		}

		String temp = "";
		// 버블 정렬. 바깥쪽 회차
		for (int i = 0; i < map.size(); i++) {
			// 안쪽은
			for (int h = 1; h < map.size(); h++) {
				if (map.get(str[h-1]) > map.get(str[h])) {
					temp = str[h-1];
					str[h-1] = str[h];
					str[h] = temp;
				}
			}
		}

		String[] order = new String[play.size()];
				
		Iterator itPlay = play.entrySet().iterator();

		mapSize = 0;
		while (itPlay.hasNext()) {
			Map.Entry e = (Entry) itPlay.next();
			order[mapSize] = (Integer) e.getKey()+"";
			mapSize++;
		}

		
		temp = "";
		// 버블 정렬. 바깥쪽 회차 순서체크 
		for (int i = 0; i < play.size(); i++) {
			// 안쪽은
			for (int h = 1; h < play.size() ; h++) {
				
				if (play.get(Integer.parseInt(order[h-1])) > play.get(Integer.parseInt(order[h]))) {
					temp = order[h-1] ; 
					order[h-1] = order[h];
					order[h] =temp;
				}
			}
		}
	
		for (int i = 0; i < order.length; i++) {
			System.out.print( order[i]+" ");
			
		}
		System.out.println();
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]+" ");
			
		}
		
		int check =0;
		int savePoint=0;
		String[] reStr =new String[str.length*2];
		//null 방지를 위한 값 입력
		for(int i=0;i<reStr.length;i++  ) {
			reStr[i]="";
		}
		
		
		// 곡의 순서 역순, 재생횟수 역순 => 곡 선택 
		for(int i=str.length-1;i>=0;i--) {
			for(int h=order.length-1;h>=0;h--) {
				if(genres[Integer.parseInt(order[h])].equals(str[i])) {			
					if(check<2) {
						check++;
						reStr[savePoint]= order[h];
						savePoint++;
					}
				}
			}// 곡의 순서 체크 
			check=0;
		}// 우선 순위 체크
		System.out.println();
		System.out.println(Arrays.deepToString(order));
		System.out.println();
		System.out.println(Arrays.deepToString(str));
		System.out.println();
		System.out.println(Arrays.toString(reStr));
		System.out.println(reStr.length);
		// null 값만 한번 없에 보자 
		
		check =0;
		savePoint=0;
		
		// 곡이 1개인것에 대비해 체크 후 새로운 변수에 입력
		// 빈 갯수 체크 
		for(int i=0;i<reStr.length;i++) {
			if(reStr[i].isEmpty()) {
				check++;
			}
		}
		
		int[] answer = new int[reStr.length-check];
		for(int i=0;i<answer.length;i++) {
			answer[i]=Integer.parseInt(reStr[i]);
		}
		
		return answer;
	}

}
