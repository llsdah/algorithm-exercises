package programmers;
import java.util.*;

public class 달리기 {

    public String[] solution(String[] players, String[] callings) {

        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i < players.length;i++) {
            map.put(players[i],i);
        }

        for(int i=0;i < callings.length;i++){

            int number = map.get(callings[i]);

            String replace = players[number-1];
            players[number] = replace;
            players[number-1] = callings[i];

            map.put(players[number],number);
            map.put(players[number-1],number-1);
        }

        return players;
    }
}
