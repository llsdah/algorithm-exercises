import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 가로 길이가 길대 총합과 이차원 배열 곱이 같다. 
        // 외곽에만있네.. 가로 *2 + (세로-2)*2; 
        // brown 길이 = (가로+세로-2)*2;
        int sum = brown+yellow;
        
        for(int i=3;i<=5000;i++){ //가로 
            for(int k=1;k<=i;k++){ //세로
                int mul = i*k;
                if (mul!=sum) continue;
                else {
                    int cal = (i+k-2)*2;
                    if (cal==brown){
                        answer[0]=i;
                        answer[1]=k;
                        return answer;
                    }
                    continue;
                }
            }
        }
        
        
        return answer;
    }
}
