package zerobase.linear.hashtable;

import java.util.Hashtable;

/**
 * 두수더해 다켓 수 나오게 하는 방법
 *
 */

public class Practice1 {

    public static void main(String[] args) {

    }
    public static int[] sol(int[] arr, int tar){
        int[] result = new int[2];
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        // 인덱스 두개를 가져 옵니다.
        for(int i=0;i<arr.length;i++){
            if(ht.containsKey(arr[i])){
                result[0] = ht.get(arr[i]);
                result[1] = i;
                return result;
            }
            ht.put(tar - arr[i],i);
        }
        return null;
    }
}
