package studyProgrammers;

import java.util.ArrayList;
import java.util.Arrays;

/*
 
 모의고사
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.
 
 
 */

public class PerfectSearch1 {
	
	public static void main(String[] args) {
		int[] answer = {1,3,2,4,2};
		int[] aaa = solution(answer);
		System.out.println(Arrays.toString(aaa));
	
	}
  
	public static int[] solution(int[] answers) {
      int[] one = {1, 2, 3, 4, 5};
      int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
      int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
      
      int x, y, z, count;
      x = y = z = count = 0;

      for( int i=0;i<answers.length;i++) {
    	  if(answers[i]==one[i%5]) x++;
    	  if(answers[i]==two[i%8]) y++;
    	  if(answers[i]==three[i%10]) z++;
      		  
      };
      
      int[] answer = {x,y,z};
      Arrays.sort(answer);
      
      ArrayList<Integer> temp = new ArrayList<>();
      
      if(x==answer[2]) temp.add(1);
      if(y==answer[2]) temp.add(2);
      if(z==answer[2]) temp.add(3);
      
      int[] ans = new int[temp.size()];
      for(int num : temp ) {
    	  ans[count] =temp.get(count);
    	  count++;
      }
      
      return ans;
        
        
        
   }

}


/*
         int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int x, y, z, count;
        x = y = z = count = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5]) x++;
            if(answers[i] == two[i%8]) y++;
            if(answers[i] == three[i%10]) z++;
        }

        int[] ans = {x, y, z};
        Arrays.sort(ans); //오름차순 정렬. 최대값

        ArrayList<Integer> temp = new ArrayList<>();

        if(x == ans[2]) temp.add(1);
        if(y == ans[2]) temp.add(2);
        if(z == ans[2]) temp.add(3);

        //배열 생성
        int[] answer = new int[temp.size()];
        for(int num : temp) {
            answer[count] = temp.get(count);
            count++;
        }
        return answer;
    }
}

//다른 사람의 풀이
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2])); //최대값찾기
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray(); //리스트를 배열로 변경
    }
}
[출처] [자바] 프로그래머스_모의고사|작성자 으니
 
 
 
 */
