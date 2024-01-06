package zerobase.basicmathematics;

/**
 * 하노이의 탑 => 맨끝으로 이동하는 과정 출력
 * 항상 큰 원반위에 작은 원반이 있도록한다.
 * 부분적으로 쪼개서 한번봐보자
 * 반복 패턴이 보인다..!! 
 */

public class Practice10 {
    static StringBuffer sb;
    public static void main(String[] args) {
        solution(5);
        solution(3);
        solution(2);
        solution(4);
    }
    public static void solution(int n){
        sb = new StringBuffer();

        hanoi(n,1,2,3);
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int mid, int end) {
        if(n==1){
            sb.append(start+" "+end+""+"\n");
            return;
        }
        hanoi(n-1,start,end,mid);
        sb.append(start+" "+end+""+"\n");
        hanoi(n-1,mid,start,end);
    }
}
