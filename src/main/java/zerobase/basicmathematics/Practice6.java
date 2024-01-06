package zerobase.basicmathematics;

/**
 * 카타랑의 수 , 점회식 제워서 편하게
 */
public class Practice6 {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(4));
        System.out.println(solution(3));
    }
    public static int solution(int n){
        int result=0;
        if(n<=1){
            return 1;
        }
        for(int i =0;i<n;i++){
            result +=solution(i)*solution(n-1-i);
        }
        return result;
    }
}
