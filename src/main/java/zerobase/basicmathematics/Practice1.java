package zerobase.basicmathematics;

import java.util.ArrayList;

/**
 * 파스칼의 삼각형
 */
public class Practice1 {

    public static void main(String[] args) {

        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }

    private static ArrayList<ArrayList<Integer>> solution(int num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=0;i<num;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int k=0; k < i+1;k++){
                if(k==0||k==i){
                    list.add(1);
                }else {
                    int x = result.get(i - 1).get(k - 1);
                    int y = result.get(i - 1).get(k);
                    list.add(x + y);
                }
            }
            result.add(list);
        }
        System.out.println("");
        return result;
    }

}
