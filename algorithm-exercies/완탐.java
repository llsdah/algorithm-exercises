package AlgorismStudy1;

import java.util.Arrays;

// 재귀
public class Perm {

	public static void main(String[] args) {
		int N =4;
		int[] nums = {1,2,3,4};
		System.out.println("순열 큰 두자리수 "+solve1(nums,N,0,0,0));
		System.out.println("조합 큰 두수 합  "+solve2(nums,N,0,0,0));
		
		
	}
	// 가장큰 두자리 수 구하기 
	private static int solve2(int[] nums, int N, int pos, int cnt, int val) {
		if(cnt==2)return val; // 선택된 숫자 cnt, 선택된 숫자의 더한 값 val
		if(pos==N) return -1;
		int ret =0;
		
		ret= Math.max(ret, solve2(nums, N,pos+1,cnt+1,val+nums[pos]));// 선택하고
		ret= Math.max(ret, solve2(nums, N,pos+1,cnt,val));// 선택 안하고
		return ret;
	}
	private static int solve1(int[] nums, int N, int cnt, int used, int val) {
		if(cnt==2)return val; // 선택된 숫자 cnt, 선택된 숫자의 더한 값 val
		
		int ret =0;
		for( int i=0; i<N;i++) {
			if( (used & 1 <<i)!=0) continue;
			// 원소 추가 즉 0001 이면 1번 원소 사용, 인덱의 0 = 1번 원소 일치하니 무조건 0이 아님
			ret = Math.max(ret, 
					solve1(nums,N,cnt+1,used | 1<<i,val*10+nums[i]));
			
		}
		
		return ret;
	}

}
