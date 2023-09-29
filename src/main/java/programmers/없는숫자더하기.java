import java.util.*;

class Solution {
	public int solution(int[] numbers) {
		int answer = 0;
		boolean[] nums = new boolean[10];
		for (int i = 0; i < numbers.length; i++) {
			nums[numbers[i]] = true;
		}
		for (int i = 0; i < 10; i++) {
			if (!nums[i])
				answer += i;
		}
		return answer;
	}
}
