package zerobase.linear.practice;

/**
 * 수정된 배열 되돌리기
 */
public class Practice1 {

    public static void main(String[] args) {

    }

    // oldSol에 나온값을 원상 복구
    public static int[] newSol(int[] arr){
        int[] arrNew = new int[arr.length];
        int idx = 0;

        for(int i =0; i< arr.length;i++){
            for(int k = 0; k<arr.length;k++){
                if(arrNew[idx]==0){
                    break;
                }
                idx = (idx+1)%arr.length;
            }
            arrNew[idx] = arr[i];
            idx = (idx +arr[i])%arr.length;
        }

        return arrNew;
    }
    // 기존 배열 변경
    public static int[] oldSol(int[] arr){
        int[]arrNew = new int[arr.length];

        int idx = 0;
        int cnt = 0;
        int val = arr[idx];
        while(cnt < arr.length){
            while(val == 0){
                idx = (idx + 1) % arr.length;
                val = arr[idx];
            }

            arrNew[cnt++] = val;
            arr[idx] = 0;
            idx = (val + idx) % arr.length; // 더한것이 인덱스입니다.
            val = arr[idx];
        }
        return arrNew;
    }
}
