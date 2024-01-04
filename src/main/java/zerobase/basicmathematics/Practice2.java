package zerobase.basicmathematics;

import java.util.Arrays;

/**
 * 양의 정수로 주어진 arr 배열의
 * 주어진 수에 배열로 조합해 직전에 가장 큰수 다만 단 1번의 스왑
 */

public class Practice2 {
    public static void main(String[] args) {
        int[] arr ={3,2,1};
        solution(arr);

        arr = new int[]{1,9,4,7,6};

        solution(arr);

        arr = new int[]{1,1,2,3};
        solution(arr);

    }

    private static void solution(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }

        int index=-1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
        System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=arr.length-1;i>index;i--){
            if(arr[i]<arr[index]&&arr[i]!=arr[i-1]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
