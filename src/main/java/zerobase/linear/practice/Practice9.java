package zerobase.linear.practice;

import java.util.Hashtable;

/**
 * linearDS_14_2 practice4
 * 마라톤 참가
 * 참가자와 완주자
 * 단 1명의 미 완주자 발생
 * 동명이인의 가능성이 있다.
 * 이름은 알파벡 소문자
 *
 *
 */

public class Practice9 {

    public static void main(String[] args) {

        String[] part = {"leo","kiki","edan"};
        String[] complete = {"kiki","edan"};

        String name = solution(part,complete);
        System.out.println("name : "+ name);

        part = new String[]{"mi","jo","ni","vi","fi"};
        complete = new String[]{"jo","fi","mi","ni"};

        name = solution(part,complete);
        System.out.println("name : "+ name);

        part = new String[]{"mi","jo","mi","vi"};
        complete = new String[]{"jo","vi","mi"};

        name = solution(part,complete);
        System.out.println("name : "+ name);


    }

    private static String solution(String[] part, String[] complete) {
        String result = "";
        Hashtable<String,Integer> ht = new Hashtable<>();

        for(String item : part){
            if(ht.containsKey(item)){
                ht.put(item,ht.get(item)+1);
            }else{
                ht.put(item,1);
            }
        }

        for(String item : complete){
            ht.put(item,ht.get(item)-1);
        }

        for (String item : part){
            if(ht.get(item)>0){
                result = item;
                break;
            }
        }

        return result;
    }


}
