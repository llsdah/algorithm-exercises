package zerobase;

import java.util.*;

public class TestCode {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        //minimizeDifference(arr);
        //minimizeDifference1(arr);
        int length = arr.length;
        List<Integer> array = new ArrayList<>();
        for(int ar : arr){
            array.add(ar);
        }
        int t = 10;
        int checkDist = 2;

        boolean result = check(checkDist, array, t);
        System.out.println("Result: " + result);

        for(int i =7;i>0;i--){
            System.out.println("i"+i+"bool:"+check(i,array,1));
        }
    }

    public static boolean check(int checkDist, List<Integer> a, int t) {
        long downCnt = 0;
        List<Integer> checkA = new ArrayList<>(a);

        // 앞에서 뒤 쪽으로 확인
        for (int i = 0; i < checkA.size() - 1; i++) {
            if (downCnt > t) {
                break;
            }

            int here = checkA.get(i);
            int there = checkA.get(i + 1);

            // there을 줄여야 될 때
            if (here + checkDist < there) {
                downCnt += (there - here - checkDist);
                checkA.set(i + 1, there - (there - here - checkDist));
            }
        }

        // 뒤에서 앞 쪽으로 확인
        for (int i = checkA.size() - 1; i >= 1; i--) {
            if (downCnt > t) {
                break;
            }

            int here = checkA.get(i);
            int there = checkA.get(i - 1);

            // there을 줄여야 될 때
            if (here + checkDist < there) {
                downCnt += (there - here - checkDist);
                checkA.set(i - 1, there - (there - here - checkDist));
            }
        }

        return downCnt <= t;
    }
}
