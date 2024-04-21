package solution;

import java.util.*;

public class 개인정보수집유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> result = new ArrayList<>();

        Map<String,Integer> mapTerms = new HashMap<>();
        for(String item : terms){
            String[] arr = item.split(" ");
            mapTerms.put(arr[0], Integer.parseInt(arr[1]));
        }

        for(int i = 0; i<privacies.length;i++){
            String[] arr = privacies[i].split(" ");
            String[] newDate = monthDay(arr[0],mapTerms.get(arr[1]));

            if(!compareToday(today,newDate)){
                result.add(i+1);
            }

        }

        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    private String[] monthDay(String std, int terms){

        String[] result = new String[3];

        String years = std.substring(0,4);
        String mons = std.substring(5,7);
        String days = std.substring(8);

        int year = Integer.parseInt(years);
        int mon = Integer.parseInt(mons);
        int day = Integer.parseInt(days);

        if( mon+terms > 12){

            int cnt = (mon+terms-1)/12;
            year+=cnt;
            mon = (mon+terms)-(12*cnt);

        }else{
            mon = mon+terms;
        }

        if(days.equals("01")){
            day = 28;
            if(mon == 1){
                mon = 12;
                year--;
            }else{
                mon--;
            }
        }else{
            day--;
        }

        result[0] = ""+year;
        result[1] = mon < 10 ? "0"+mon : ""+ mon;
        result[2] = day < 10 ? "0"+day : ""+ day;

        return result;
    }

    public boolean compareToday(String today, String[] std){

        String years = today.substring(0,4);
        String mons = today.substring(5,7);
        String days = today.substring(8);

        if(Integer.parseInt(years)>Integer.parseInt(std[0])){
            return false;
        }

        if(Integer.parseInt(years)==Integer.parseInt(std[0]) &&
                Integer.parseInt(mons)>Integer.parseInt(std[1])){
            return false;
        }

        if(
                Integer.parseInt(years)==Integer.parseInt(std[0]) &&
                        Integer.parseInt(mons)==Integer.parseInt(std[1]) &&
                        Integer.parseInt(days)>Integer.parseInt(std[2])){
            return false;
        }

        return true;
    }
}
