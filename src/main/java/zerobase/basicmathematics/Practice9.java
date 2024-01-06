package zerobase.basicmathematics;

/**
 * 좋은 수
 * 짝수 인덱스 위치에 짝수
 * 홍수 인덱스 위치에 소수 (2,3,5,7)
 *
 * n 이라는 자리수가 주어졌을떄의 총 갯수
 * 생각 한번 !
 * 4자리 일경우 5*4*5*4 반복!
 * 천의 자리에 올수 있는것 : 작수 5개
 * 백의 자리에 올수 있는것 : 소수 4개
 * 십의 자리에 올수 있는것 : 짝수 5개
 * 일의 자리에 올수 있는것 : 소수 4개
 *
 */


public class Practice9 {
    final static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {

    }
    public static int solution(int n){
        int result = 0;
        // 5일때와 4일떄의 반복 ,
        result = (int) ((recursion(5, (n+1)/2)*recursion(4,n/2)) % mod);
        return result;
    }
    public static long recursion(long x, long repeat){
        if(repeat==0){
            return 1;
        }
        long p = recursion(x,repeat/2);
        return (p*p * ( repeat%2 > 0 ? x : 1) ) % mod;
    }
}

/**
 x y p return
 5 5 5*5*1 5*5*1*5*5*1*5 =

 5 2 5 5*5*1
 5 1 1 1*1*5
 5 0 0 1


 */
