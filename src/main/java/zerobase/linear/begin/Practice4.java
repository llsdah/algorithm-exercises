package zerobase.linear.begin;

import java.util.ArrayList;

/**
 * 배열의 peek 값 보모두 출력
 * peek 값이란 좌우보다 큰값.
 */
public class Practice4 {
    public static void main(String[] args) {

        int[] arr = {3,1,2,6,2,2,5,1,9,10,1,11};

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(i==0 && (arr[i]>arr[i+1]) ){
                list.add(arr[i]);
            }else if(i==arr.length-1 && arr[i]>arr[i-1]){
                list.add(arr[i]);
            }else{
                if(arr[i]>arr[i-1]&&arr[i]<arr[i-1]){
                    list.add(arr[i]);
                }
            }
        }

        System.out.println(list.toString());
    }
}
