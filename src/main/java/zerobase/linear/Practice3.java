package zerobase.linear;

import java.util.Arrays;

/**
 * 순서를 반대로
 */
public class Practice3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,8,9};

        for(int i=0; i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        System.out.println("data : "+ Arrays.toString(arr));
    }
}
