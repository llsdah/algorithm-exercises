import java.util.*;

class Solution {
   	public static int solution(int[] people, int limit) {
		Arrays.sort(people);

		// 가장 몸무게가 작은 사람이랑 가장 많이 나가는 사람이랑 같이 탈 수 있나 비교
		// 같이 탈 수 없다면 점점 덜 무거운 사람들과 비교
		// 같이 탈 수 있다면 끝.
		int answer = 0;
		// 1. 현재 people 배열의 길이를 index로 둠
		int index = people.length - 1;
		// 2. people 배열 시작부터 하나씩 올라가면서
		// 3. 제일 몸무게 큰 사람이랑 작은 사람 비교 초과한다면
		// 따로 태워하니까 answer 하나 추가, 제일 몸무게 높은 사람도 한칸 늘리고,
		// 가장 몸무게 작은 사람도 한칸 늘림
		
		// 포인트 최대 두명밖에 못탑니다.!!!
		for (int i = 0; i <= index; i++, answer++)
			// 비교와 동시에 감소 즉! 큰 경우에만 다른 배에 대웁니다. 
			// 같은배에 태울떄까지 돌아 간다는 의미!
			while (index > i && people[i] + people[index--] > limit)
				answer++;

		return answer;
	}

}

//정답 2
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int pos =people.length-1;
        for(int i=0; i<=pos;i++){
            if(people[i]+people[pos]<=limit){
                answer++;
                pos--;
            }else{
                answer++;
                pos--;
                i--;
            }
        }
        return answer;
    }
}
