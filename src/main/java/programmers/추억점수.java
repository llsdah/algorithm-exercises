package programmers;

import java.util.*;

public class 추억점수 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String,Integer> map = new HashMap<>();

        for(int i = 0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }

        for(int i =0; i<photo.length;i++){
            for(String str : photo[i]){
                if(map.get(str) != null){
                    answer[i] +=  map.get(str);
                }
            }
        }

        return answer;
    }
}
