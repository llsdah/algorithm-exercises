package zerobase.linear.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NxN 행렬이 있는데 0원소가 있는 위치의 행열의 값을 전체 0으로 바꾸어라
 */
public class Practice2 {

    public static void main(String[] args) {

    }

    public static int[][] sol(int[][] arr){
        int[][] result = arr.clone();
        boolean frZero = false;
        boolean fcZero = false;

        List<int[]> list = new ArrayList<>();

        // 우선 0의 위치 를 찾는다.
        for(int row = 0; row < arr.length;row++){
            for(int col = 0; col < arr[0].length; col++){
                if(arr[row][col]==0){
                    if(row == 0) frZero =true;
                    if(col == 0) fcZero =true;
                    arr[row][0] = 0; // 기준 점 부분 변경
                    arr[0][col] = 0;
                }
            }
        }

        for(int row = 0; row < arr.length;row++){
            for(int col = 0; col < arr[0].length; col++){
                if(arr[row][0]==0 || arr[0][col]==0){
                    arr[row][col]=0;
                }
            }
        }

        if(frZero){
            for(int col = 0; col<arr[0].length;col++){
                arr[0][col]=0;
            }
        }
        if(fcZero){
            for(int row = 0; row<arr[0].length;row++){
                arr[row][0]=0;
            }
        }

        return result;
    }


    public static int[][] mySol(int[][] arr){
        int[][] result = arr.clone();
        List<int[]> list = new ArrayList<>();

        // 우선 0의 위치 를 찾는다.
        for(int row = 0; row < arr.length;row++){
            for(int col = 0; col < arr[0].length; col++){
                if(arr[row][col]==0){
                    int[] zero = new int[2];
                    zero[0] = row;
                    zero[1] = col;
                    list.add(zero);
                }
            }
        }

        for(int[] item : list){
            Arrays.fill(result[item[0]], 0);
            for(int i = 0;i<result.length;i++){
                result[i][item[1]] = 0;
            }
        }

        return result;
    }
}
