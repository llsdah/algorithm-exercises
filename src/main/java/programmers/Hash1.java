package studyProgrammers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/*
문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의
 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 
 return 하도록 solution 함수를 작성해주세요.
;
제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.

입출력 예
participant											completion								return
[leo, kiki, eden]									[eden, kiki]								leo

[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko

[mislav, stanko, mislav, ana]				[stanko, ana, mislav]				mislav

입출력 예 설명
예제 #1
leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
 */

public class Hash1 {

	public static void main(String[] args) {

		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };

		// System.out.println(solution(participant, completion));

		String asc = map(participant, completion);
		System.out.println(asc);
	}
	
	//정답 
	private static String map2(String[] participant, String[] completion) {
		Map<String, Integer> cache = new HashMap<>();
		for (int i = 0; i < participant.length; i++) {
			if (0 < cache.getOrDefault(participant[i], 0)) {
				cache.replace(participant[i], cache.get(participant[i]) + 1);
			} else {
				cache.put(participant[i], 1);
			}
		}
		for (int i = 0; i < completion.length; i++) {
			if (0 < cache.get(completion[i])) {
				cache.replace(completion[i], cache.get(completion[i]) - 1);
			}
		}
		for (Map.Entry<String, Integer> item : cache.entrySet()) {
			if (0 < item.getValue())
				return item.getKey();
		}
		return null;
	}

	// HashMap은 키값은 단 value는 아무 상관이 없다. 
	//getOrDefault(key, defaultValue) 찾는 키가 존재하면! 키의 값을 반환하고,
	//없으면 기본 값을 반환한다. 
	private static String map(String[] participant, String[] completion) {
		// TODO Auto-generated method stub
		Map<String, Integer> map1 = new HashMap<>();
		
		for(int i=0; i<participant.length;i++) {
			if(0<map1.getOrDefault(participant[i] ,0)) {
				map1.replace(participant[i], map1.get(participant[i]) + 1);
			} else {
				map1.put(participant[i],1);
			}
		}
		
		System.out.println(map1.values());
		for(int i=0; i<completion.length;i++) {
			if(0<map1.get(completion[i])) {
				map1.replace(completion[i], map1.get(completion[i])-1);
			}
		}
		
		for (Map.Entry<String, Integer> item :map1.entrySet()) {
			if(0<item.getValue()) {
				return item.getKey();
			}
		}
		
		
		return null;
	}
	//내가 푼것 
	public static String solution(String[] participant, String[] completion) {

		HashSet p = new HashSet();
		HashSet c = new HashSet();
		String name = "";
		String name2 = "";

		for (int i = 0; i < participant.length; i++) {
			if (!p.contains(participant[i])) {
				p.add(participant[i]);
			} else {
				name2 = participant[i];
			}
		}

		for (int i = 0; i < completion.length; i++) {

			c.add(completion[i]);
		}

		System.out.println(p);
		Iterator i = p.iterator();

		while (i.hasNext()) {
			Object nametem = i.next();

			if (!c.contains(nametem)) {
				name = name + nametem;
			}

		}

		String answer = name + name2;
		return answer;
	}

}