package zerobase.linear.practice;

import java.util.*;

/**
 * 베스트앨범 출시 (2개씩 모와서 출시)
 *
 * 속한 노래가 많이 재생된 장르 먼저 수록
 * 장르 내 많이 재샌된 노래를 먼저 수록
 * 장르 내 재생 횟수가 같은 노래 중 고유번호가 낮은 노래 먼저 수록
 *
 */
public class Practice8 {
    public static void main(String[] args) {
        String[] genres={"classic","pop","classic","classic","pop"};
        int[] plays={500,600,150,800,2500};
        //answer = {4,1,3,0}
        solution(genres,plays);
    }

    private static void solution(String[] genres, int[] plays) {
        Hashtable<String, ArrayList<Practice8_song>> ht = new Hashtable<>();
        for(int i=0; i<genres.length;i++){
            if(ht.containsKey(genres[i])){
                ArrayList<Practice8_song> list = ht.get(genres[i]);
                int idx = -1;

                for(int k=0;k<list.size();k++){
                    // 현재와 비교,
                    if(plays[i] > list.get(k).play ||
                    plays[i]==list.get(k).play && i<list.get(k).no){
                        idx = k; // 입력될곳
                        break;
                    }
                }

                if( idx == -1){
                    list.add(new Practice8_song(i,plays[i])); // 맨뒤에 넣고
                }else{
                    list.add(idx, new Practice8_song(i,plays[i])); // 해당 위치에 넣는다.
                }

                ht.put(genres[i],list); // 그리고 리스트 다시 넣기

            }else{
                // 최초라면 그냥 넣기
                Practice8_song song = new Practice8_song(i,plays[i]);
                ht.put(genres[i],new ArrayList<>(Arrays.asList(song)));
            }

        }

        // 장르면 재생횟수
        Hashtable<String, Integer> htPlay = new Hashtable<>();
        for (String item :ht.keySet()){
            int sum = 0;
            ArrayList<Practice8_song> list = ht.get(item);
            for(int k=0;k<list.size();k++){
                sum += list.get(k).play;
            }
            htPlay.put(item,sum);
        }


        ArrayList<Map.Entry<String,Integer>> htPlaySort = new ArrayList<>(htPlay.entrySet());
        htPlaySort.sort((x1,x2) -> x2.getValue() - x1.getValue()); // 값이 큰 순서대로 정렬합니다.

        for(Map.Entry<String,Integer> item: htPlaySort){
            ArrayList<Practice8_song> songs = ht.get(item.getKey());
            for(int k=0;k<songs.size();k++){
                System.out.print(songs.get(k).no+" ");
                if(k==1){
                    break;
                }
            }
        }

        System.out.println(" ");

    }

}

class Practice8_song{
    int no;
    int play;
    Practice8_song(int no, int play){
        this.no = no;
        this.play = play;
    }
}













