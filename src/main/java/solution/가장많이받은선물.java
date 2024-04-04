package solution;

import java.util.*;

public class 가장많이받은선물 {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 선물 지수 : 준거 - 받은거
        List<String> idx = Arrays.asList(friends);

        Map<Integer,Integer> cnt = new HashMap<>();
        Map<Integer,int[]> map = new HashMap<>();

        for(String friend : friends){
            cnt.put(idx.indexOf(friend),0);
            map.put(idx.indexOf(friend),new int[idx.size()]);
        }

        for(String f : gifts){
            String[] arr = f.split(" ");
            int send = idx.indexOf(arr[0]);
            int receive = idx.indexOf(arr[1]);

            // 선물 지수 증가
            cnt.put(send,cnt.get(send)+1);
            cnt.put(receive,cnt.get(receive)-1);

            // 샌더가 리시버에서 선물 줌
            int[] sendEx = map.get(send);
            sendEx[receive] ++;
            map.put(send, sendEx);
        }
        for(Integer i : cnt.keySet()){
            System.out.println(i+":"+cnt.get(i));

        }
        System.out.println();

        int[] result = new int[idx.size()];

        for(int friend : map.keySet()){
            int[] send = map.get(friend);

            for(int i=0; i<send.length;i++){
                if(friend == i) continue;// 나 자신
                int[] re = map.get(i);

                if(send[i] > re[friend] ){
                    result[friend]++;
                }else if (send[i] == re[friend]
                        && cnt.get(friend) > cnt.get(i) ){
                    result[friend]++;
                }
            }
        }

        answer = Arrays.stream(result).max().orElse(Integer.MIN_VALUE);

        return answer;
    }
}
