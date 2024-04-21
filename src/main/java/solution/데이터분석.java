package solution;
import java.util.*;
import java.util.stream.Collectors;

public class 데이터분석 {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String,Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);

        Arrays.sort(data, (a, b) -> Integer.compare(
                a[map.get(sort_by)], b[map.get(sort_by)]));

        // 스트림을 사용하여 첫 번째 열의 값이 1보다 작은 데이터 추출
        List<int[]> result = Arrays.stream(data)
                // 첫 번째 열의 값이 1보다 작은 행을 필터링
                .filter(row -> row[map.get(ext)] < val_ext)
                // 필터링된 결과를 리스트로 수집
                .collect(Collectors.toList());

        int[][] answer = new int[result.size()][result.get(0).length];

        for(int idx =0; idx<result.size();idx++){
            for(int i=0;i<answer[idx].length;i++){
                answer[idx][i] = result.get(idx)[i];
            }
        }
        return answer;
    }
}
