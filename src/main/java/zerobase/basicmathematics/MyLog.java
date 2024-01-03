package zerobase.basicmathematics;
import java.util.*;
public class MyLog {
    public static void main(String[] args) {
        // 제곱 제곱근 지수
        System.out.println(Math.pow(2,3));
        System.out.println(Math.pow(2,-3));
        System.out.println(Math.pow(-2,-3));
        System.out.printf("%.0f\n", Math.pow(2,30));
        System.out.printf("%.0f\n", Math.sqrt(16));
        System.out.println(Math.abs(-11));
        System.out.println(Math.E);
        System.out.println(Math.log(4));

    }

    static double myPow(int a, double b){
        double result = 1;
        boolean checkMinus = false;
        if(b==0){
            return 1;
        }else if (b<0){
            b*=-1;
            checkMinus = true;
        }
        for (int i=0;i<b;i++){
            result += a;
        }
        return checkMinus ? 1/result : result;
    }
    // 바빌로니아
    static  double mySqrt(int a){
        double result = 1;
        for(int i=0;i<10;i++){
           result = (result * (a/result))/2;
        }
        return result;
    }

}
