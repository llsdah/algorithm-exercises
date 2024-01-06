package zerobase.basicmathematics;

import java.util.HashSet;

public class Practice4 {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println("1"+set.add(1));
        System.out.println("2"+set.add(1));
    }

    public boolean solution(int num){
        boolean result = false;

        HashSet<Integer> set = new HashSet<>();
        while (set.add(num)){ // 반복되는경우 false
            int squarSum = 0;
            while(num>0){
                int remain = num%10;
                squarSum += remain * remain;
                num/=10;
            }

            if(squarSum==1){
                return true;
            }else{
                num = squarSum;
            }

        }

        return result;
    }
}
