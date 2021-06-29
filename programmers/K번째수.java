import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i =0; i<commands.length;i++){
            int st = commands[i][0]-1;
            int end =commands[i][1]-1;
            int pos = commands[i][2]-1;
            
            int[] temp =new int[end-st+1];
            int num =0;
            for(int k=st; k<=end;k++){
                temp[num]=array[k];
                num++;
            }
            Arrays.sort(temp);
            answer[i] = temp[pos];
            
        }
        
        
        return answer;
    }
}
