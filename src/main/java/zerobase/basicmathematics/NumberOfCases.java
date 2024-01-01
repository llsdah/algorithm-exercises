package zerobase.basicmathematics;
import java.util.*;
public class NumberOfCases {

    public static void main(String[] args) {

        // 합의법칙
        System.out.println("");
        int[] dice1 = {1,2,3,4,5,6};
        int[] dice2 = {1,2,3,4,5,6};

        int nA = 0;
        int nB = 0;
        int nAandB = 0;
        for(int item1 : dice1){
            for(int item2 : dice2){
                if( (item1+item2) % 3 == 0 ){
                    nA ++;
                }
                if( (item1+item2) % 4 == 0 ){
                    nB ++;
                }
                if( (item1+item2) % 12 == 0 ){
                    nAandB ++;
                }

            }
        }
        System.out.println("result rule of sum : " + (nA+nB+nAandB));
        HashSet<ArrayList> allCase = new HashSet<>();
        for(int item1 : dice1){
            for(int item2 : dice2){
                if( (item1+item2) % 3 == 0 || (item1+item2) % 4 == 0 ){
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(item1,item2));
                    allCase.add(list);
                }
            }
        }

        System.out.println("resutl rule of sum hashSet : "+allCase.size());

        // 곱의 법칙

        nA = 0;
        nB = 0;
        for(int item1 : dice1){
            if( (item1) % 3 == 0 ){
                nA ++;
            }
        }
        for(int item2 : dice2){
            if( (item2) % 4 == 0 ){
                nB ++;
            }
        }

        System.out.println("result : "+(nA*nB));

        int numA = 10;
        int numB = 6;

        ArrayList<Integer> listA = getDivisor(numA);
        ArrayList<Integer> listB = getDivisor(numB);

        System.out.println("listA : "+listA);
        System.out.println("listB : "+listB);
        System.out.println("최대공약수 : "+getGCD(numA,numB));
        System.out.println("최소공배수 : "+getLCM(numA,numB));
        System.out.println("");
        System.out.println("");

    }
    
    // 약수 구하기
    public static ArrayList<Integer> getDivisor(int num){
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1;i<(int)num/2;i++){
            if(num % i == 0){
                result.add(i);
            }
        }
        return result;
    }

    // 최대 공약수 Greatest Common Denominator
    public static int getGCD(int numA, int numB){
        int gcd = -1;
        ArrayList<Integer> divisorA = getDivisor(numA);
        ArrayList<Integer> divisorB = getDivisor(numB);
        for(int itemA:divisorA){
            for(int itemB:divisorB){
                if(itemA==itemB && itemA>gcd){
                    gcd = itemA;
                }
            }
        }

        return gcd;
    }
    // 최소 공배수 Lowest Common Multiple
    public static int getLCM(int numA, int numB){
        int lcm = -1;

        int gcd = getGCD(numA,numB);
        if(gcd!=-1){
            lcm = numA * numB / gcd;
        }
        return lcm;

    }

}
