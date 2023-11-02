package programmers;
import java.util.*;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length;i++){
            char[] charWord = keymap[i].toCharArray();
            for(int k=0; k<charWord.length;k++){
                if(map.get(charWord[k])==null){
                    map.put(charWord[k],k+1);
                }else{
                    int min = Math.min(map.get(charWord[k]),k+1);
                    map.put(charWord[k],min);
                }
            }

        }

        for(Character character : map.keySet()){
            System.out.println(character+":"+map.get(character));
        }

        for(int i=0; i<targets.length;i++){
            char[] word = targets[i].toCharArray();
            for(int k=0; k<word.length;k++){
                int num = 0;
                if(map.get(word[k]) == null){
                    answer[i]=0;
                    break;
                }else{
                    num = map.get(word[k]);
                }
                answer[i]+=num;
            }
            if(answer[i]==0) answer[i]=-1;
        }

        return answer;
    }
}
