package zerobase.linear;

/**
 * 2차원 배열을 시계방향의 90 회전
 */

public class Practice7 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };
        System.out.println(arr.length);
        System.out.println(arr[0].length);

        // [행] [열]
        int[][] arr90 = new int[arr[0].length][arr.length];
        pringln(arr);
        System.out.println();
        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr[0].length;c++){
                int row = arr.length-1-r; // 첫번쨰 행이 마지막열로 가기 위한것
                arr90[c][row] = arr[r][c];
            }
        }
        pringln(arr90);
    }

    public static void pringln(int[][] arr){

        for(int[] r:arr){
            for(int c:r){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}
