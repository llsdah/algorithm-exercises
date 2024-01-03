package zerobase.basicmathematics;

import java.util.*;
public class MyRecurrence {

    public static void main(String[] args) {

    }

    /**
     * 재귀 함수 예시
     */

    public static int recursional1(int n){

        if(n == 1){
            return 1;
        }
        return n + recursional1(n-1);
    }

    public static int recursional2(int n){
        if(n<3){
            return 1;
        }
        return recursional2(n-1) + recursional2(n-2);
    }

    // 최대 공약수 예시
    public static int gcd(int a, int b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }

}
