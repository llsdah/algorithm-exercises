package zerobase.basicmathematics;

/**
 * 회문 펠린드롬 : 앞뒤방향으로 같은 순서의문자 구성 문자열
 */
public class Practice7 {
    public static void main(String[] args) {
        String[] str = {"assa","summuus","xabba","xabbay","comcom","comwwmoc","comwwtmoc"};
        for(String s :str){
            System.out.println(solution(s));
        }
    }
    public static int solution(String str){
        int result = 0;
        result = palindrome(0,str.length()-1,str.toCharArray(),0);
        return result;
    }

    private static int palindrome(int left, int right , char[] charArray, int delCnt) {
        while(left<right){
            if(charArray[left]!=charArray[right]){
                if(delCnt==0){
                    if(palindrome(left+1,right,charArray,1)==0||
                    palindrome(left,right-1,charArray,1)==0){
                        return 1;
                    }else {
                        return 2;
                    }
                }else {
                    return 2;
                }
            }else{
                left++;
                right--;
            }
        }
        return 0;
    }
}
