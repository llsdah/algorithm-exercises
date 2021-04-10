package studyProgrammers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*


소수 찾기
문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 
solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

입출력 예
numbers			return
[1,7]					3
[0,1,1]				2

입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.


*/


public class PerfertSearch2 {
	
	public static void main(String[] args) {
		
	String numbers = "011";
	int answer = solution(numbers);	
		
	System.out.println("answer : " + answer );
    }

	private static int solution(String numbers) {
		
		char[] list = numbers.toCharArray();
		int[] intArr = new int[list.length];
		
		for(int i =0; i<list.length; i++) {
			intArr[i] = Integer.valueOf( String.valueOf(list[i]) );
		}
		
		Set<Integer> primeCount = new HashSet<Integer>();
		
		for(int i =1; i <= list.length;i++) {
			prime(list,0,i,primeCount);
		}
		
		return primeCount.size();
	}//solution

	private static void prime(char[] list, int r, int n, Set<Integer> primeCount) {
		// 순열 nPr
		
		if(n==r) {
			//같으면 1개?
			number(list, n,primeCount);
			return;
		
		}else {
		
			for(int i=r;i<list.length;i++) {
				swap(list,i,r);
				prime(list,r+1,n,primeCount);
				swap(list,i,r);
			}
			
		}
		
		
	}//prime

	private static void number(char[] list, int n, Set<Integer> primeCount) {
		// 나온것을 배열에 저장하기 
		StringBuilder save = new StringBuilder();
		for(int i =0;i<n;i++) {
			save.append(list[i]);
		}
		primeCheck(primeCount,save);
		
		
	}//number

	private static void primeCheck(Set<Integer> primeCount, StringBuilder save) {
		// 소수 체크 
		int number = Integer.valueOf(String.valueOf(save));
		boolean check = true;
		
		if( number <=1 ) {
			return;
		}
		
		for ( int i=2; i <=Math.sqrt(number);i++) {
			if( number%i ==0) {
				check=false;
				return;
			}
		}
		
		if(check) {
			primeCount.add(number);
		}
		
		
	}// primeCheck

	private static void swap(char[] list, int i, int r) {
		// 순서 바꾸면서 저장하기 
		
		char temp =list[i];
		list[i] = list[r];
		list[r] = temp;
		
	}//swap
	
}

/*
import java.util.*;
class Solution {
    static ArrayList<Integer> perm_nums; //순열을 통해 나올 수 있는 수
    static String str_num;
    static int answer;
    public int solution(String numbers) {
        answer = 0;
        perm_nums = new ArrayList<>();
        str_num = numbers;

        //한자리부터 numbers.length()자리까지 순열
        for(int i = 1; i <= numbers.length(); i++) {
            boolean[] check = new boolean[numbers.length()];
            String temp_ans = "";
            permutation(numbers.length(), i, temp_ans, check);
        }

        //소수 확인
        for(int i : perm_nums) {
            if(i != 0 && i != 1) check(i);
        }

        return answer;
    }

    //순열 함수
    static void permutation(int n, int r, String temp_ans, boolean[] check) {
        if(temp_ans.length() == r) {
            int temp = Integer.parseInt(temp_ans); //정수 변환
            if(!perm_nums.contains(temp)) perm_nums.add(temp);
            return; //void함수 종료
        }
        else {
            for(int i = 0; i < n; i++) {
                if(!check[i]) {
                    temp_ans += Character.toString(str_num.charAt(i));
                    check[i] = true;
                    permutation(n, r, temp_ans, check); //재귀호출. i번째 수는 사용불가
                    check[i] = false; //다시 돌리기.뒤에 다시 붙을 수도 있기 때문에
                    temp_ans = temp_ans.substring(0, temp_ans.length() - 1); //마지막 글자 지우기
                }
            }
        }
    }

    static void check(int x) {
        boolean chk = true;
        for(int i = 2; i < x; i++) {
            if(x%i == 0) chk = false;
        }
        if(chk) answer++;
    }
}
*/
