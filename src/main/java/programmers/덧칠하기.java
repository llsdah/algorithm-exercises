package programmers;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start = section[0];
        int index = 0;

        for(int i=1; i < section.length; i++){
            int end = section[i];
            if(end-start >= m ){
                answer++;
                start=end;
                index=i;
            }
        }

        if(section.length-index >= 1 ){
            answer++;
        }

        return answer;
    }
}
