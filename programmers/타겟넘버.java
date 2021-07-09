import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers,1,numbers[0],target)+
            dfs(numbers,1,-numbers[0],target);
        
        return answer;
    }
    public int dfs(int[] nums,int pos,int cnt,int target){   
        if(pos==nums.length){
            if(cnt==target) return 1;
            else return 0;
        }
        
        return dfs(nums,pos+1,cnt+nums[pos],target)+
            dfs(nums,pos+1,cnt-nums[pos],target);
    }
}
