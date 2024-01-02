package zerobase.basicmathematics;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyPermutation {

    public static void main(String[] args) {

        // 펙토리얼
        int n = 5;
        int result = 1;
        int num = IntStream.range(2,6).reduce(1, (x,y)-> (x*y));
        System.out.println("fatorial : "+ num);

        // 순열
        int range = 3;
        for(int i = n; i>= n - range + 1; i--){
            result *= i;
        }

        // 중복순열
        result = 1;
        for(int i = 0; i < range; i++){
            result *= n;
        }
        result = 1;
        // 원순열
        for(int i = 1; i<range;i++){
            result *= i;
        }

        // 순열
        int[] numArr = {1,2,3,4};
        n = 4;
        // 순열 스왑
        System.out.println("스왑==========");
        int depth = 0; // 체크용도
        // 숫자 배열, 체크용, 숫자 총 몇자리, 만들 자릿수 
        swap_permutation(numArr, depth, n, range);

        System.out.println("스왑 + 방문 ==========");
        depth = 0; // 체크용도
        n=4;
        boolean[] visited = new boolean[n];
        int[] out = new int[range];
        // 숫자 배열, 체크용, 숫자 총 몇자리, 만들 자릿수
        visit_permutation(numArr, depth, n, range, visited, out);
        System.out.println("방문 ==========");

    }

    /**
     * 방문체크
     */
    private static void visit_permutation(int[] numArr, int depth, int n, int range, boolean[] visited, int[] out) {

        if(depth==range){
            System.out.println(Arrays.toString(out));
            return;
        }

        for(int i = 0; i<n ; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] =  numArr[i];
                visit_permutation(numArr,depth+1,n,range,visited,out);
                visited[i] = false;
            }
        }

    }
    /**
     * 방문체크 순영
     */


    /**
     * 순열 swap 방법
     */
    private static void swap_permutation(int[] numArr, int depth, int n, int range) {
        
        if(depth == range){
            for(int i =0; i<range;i++){
                System.out.print(numArr[i]+" ");
            }
            System.out.println();
            return;
        }
        
        for(int i = depth; i<n;i++){
            swap(numArr,depth,i);
            swap_permutation(numArr,depth+1,n,range);
            swap(numArr,depth,i);

        }
        
    }

    private static void swap(int[] numArr, int depth, int i) {
        int temp = numArr[depth];
        numArr[depth] = numArr[i];
        numArr[i]  = temp;
    }
    /**
     * 순연 swap 끝
     */
}
