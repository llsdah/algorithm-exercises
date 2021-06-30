import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        
        int[] two = {2,1,2,3,2,4,2,5};
        int[] thr = {3,3,1,1,2,2,4,4,5,5};
        int pos =0;
        int[] answer = new int[3];
        
        for(int i=0;i<answers.length;i++){
            pos =i%one.length;
            if(answers[i]==one[pos]){
                answer[0]++;
            }
            pos =i%two.length;
            if(answers[i]==two[pos]){
                answer[1]++;
            }
            pos =i%thr.length;
            if(answers[i]==thr[pos]){ // 오타 수정 !!two -> thr
                answer[2]++;
            }
        }
        int max = Arrays.stream(answer).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<answer.length;i++){
            if(max ==answer[i]) sb.append((i+1)+",");
        }
        String[] arr = sb.toString().split(",");
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length;i++){
            ans[i] = Integer.parseInt(arr[i]);
        }
        
        return ans;
    }
}
