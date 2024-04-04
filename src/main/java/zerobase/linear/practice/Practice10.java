package zerobase.linear.practice;

import java.util.*;
import java.util.stream.Stream;

/**
 * linearDS_14_2 practice 5
 *
 * 부자가된 어피치 스트레스 받으면 시작점과 끝점에 있는 보석을 다산다
 * 단, 진열대의 다른 보석의 종류 1개씩은 꼭 포함되어 있어야한다.
 * 진열대에는 보석이 순차대로 진열중이다.
 * 구매하는 보석의 갯수가 최소가 되도록 시작점과 끝점을 정하라
 * 구매 보석 갯수가 동일한 것이 나온다면 시작점이 작은 것을 반환하다.
 *
 * 예 ) ㄱ ㄴ ㄷ ㄹ ㅁ ㄱ
 * 1 ~ 6번처럼 진열된  보석이 있다면 1~5와 2~6이 가능하다.
 * 단, 시작점이 작은것은 반환해야되기에 1,5를 반환한다.
 *
 *
 */
public class Practice10 {
    public static void main(String[] args) {
        String[] gems = {"D","R","R","D","D","E","S","D"};
        int[] result = solution(gems);
        System.out.println(Arrays.toString(result));

        gems = new String[]{"A","B","c","A","C"};
        result = solution(gems);
        System.out.println(Arrays.toString(result));

        gems = new String[]{"Z","Y","N","Y","B"};
        result = solution(gems);
        System.out.println(Arrays.toString(result));

    }

    private static int[] solution(String[] gems) {
        int[] answer = new int[2];

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();//전체 값 입력

        HashSet<String> set = new HashSet<>();
        Stream.of(gems).forEach(x ->set.add(x));
        int n = set.size();

        if( n == 1){
            result.add(new ArrayList<>(Arrays.asList(1,1)));
            answer = new int[]{1,1};
            return answer;
        }

        Hashtable<String,Integer> ht = new Hashtable<>();
        boolean isConfifate = false;// 테이블의 사이즈와 개별 잼의 수 일치여부

        int left = 0;
        int right = 0;
        ht.put(gems[0],1);// 1번 값 입력완료

        while(true){
            if(isConfifate == false){
                right += 1;

                if(right >= gems.length){
                    break; // 길이 초과
                }

                // 값이 없으면 넣고, 있으면 추가
                if(ht.containsKey(gems[right])==false){
                    ht.put(gems[right],1);
                }else{
                    ht.put(gems[right],ht.get(gems[right])+1);
                }
                
                // 테이블과 잼의 수가 일치하면 이제 전체 보석 수집 완료
                if(ht.size()==n) {
                    isConfifate = true;
                    // 0,0 부터 시작이라 1더해줌
                    result.add(new ArrayList<>(Arrays.asList(left+1,right+1)));
                }
            }else{
                left += 1;//먼저 증가시키고 즉, 직전것이 없어짐
                int cnt = ht.get(gems[left-1])-1; //잼 갯수 체크
                
                if(cnt == 0){
                    ht.remove(gems[left-1]);
                    isConfifate = false; // 잼부족
                }else{
                    ht.put(gems[left-1],cnt);
                    result.add(new ArrayList<>(Arrays.asList(left+1,right+1)));
                }
            }
        }

        int minIdx = 0;
        int minNum = Integer.MAX_VALUE;

        for(int i=0; i< result.size();i++){
            ArrayList<Integer> cur = result.get(i);
            left = cur.get(0);
            right = cur.get(1);
            if(right-left<minNum){
                minNum = right - left;
                minIdx = i;
            }
        }

        answer[0] = result.get(minIdx).get(0);
        answer[1] = result.get(minIdx).get(1);
        return answer;
    }

}
