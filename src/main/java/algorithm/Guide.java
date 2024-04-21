package algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Guide {

    private void stream (){
        int[][] array = new int[4][4];

        // 배열을 [?][0] 인덱스로 정렬
        Arrays.sort(array, Comparator.comparingInt(arr -> arr[0]));
        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));

        // 스트림을 사용하여 첫 번째 열의 값이 1보다 작은 데이터 추출
        List<int[]> result = Arrays.stream(array)
                // 첫 번째 열의 값이 1보다 작은 행을 필터링
                .filter(row -> row[0] < 1)
                // 필터링된 결과를 리스트로 수집
                .collect(Collectors.toList());

        String temp = "123123";

    }

    public static void main(String[] args) {
        int cnt = (13+12)/12;
        System.out.println("nt : "+cnt);
    }
}
