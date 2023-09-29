class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int lcm = arr[0];
        for(int i=1; i<arr.length;i++){
            lcm = LCM (lcm,arr[i]);
        }
        answer =lcm;
        return answer;
    }
    public int LCM(int lcm ,int num){
        return lcm*num/GCD(lcm,num);
    }
    public int GCD(int max, int min){
        while(min!=0){
            int remain = max%min;
            max =min;
            min = remain;
        }
        return max;
    }
}
