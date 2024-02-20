package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수 판단 로직
 */
public class PrimeNumber {
    public static void main(String[] args) {

    }

    public static boolean isPrime(int number){
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findPrimesInRange(int start, int end) {
        boolean[] isPrime = new boolean[end + 1]; // 초기에는 모든 수를 소수로 간주
        List<Integer> primes = new ArrayList<>();

        // 초기화
        for (int i = 2; i <= end; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 알고리즘 적용
        for (int p = 2; p * p <= end; p++) {
            if (isPrime[p]) {
                // p가 소수인 경우 p의 배수들을 모두 소수가 아니라고 표시
                for (int i = p * p; i <= end; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // 소수를 리스트에 추가
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }


}
