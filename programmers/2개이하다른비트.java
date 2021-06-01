class Solution {
    int max = 0;
    public long[] solution(long[] numbers) {
        int leng = numbers.length;
        long[] answer = new long[leng];
        for(int i =0; i< leng;i++){
            max =0;
            char[] st = bi(numbers[i]);
            answer[i] = cnt(st,numbers[i]+1);
        }
        return answer;
    }
    public long cnt(char[] st, long num){
        boolean flag = true;
        while(flag){
            int cnt =0;
            char[] arr = bi(num);
            for(int i=0; i <max+1;i++){
                if(st[i]!=arr[i]){
                    cnt++;
                }
                if(cnt>=3) break;
            }
            if( cnt<=2){
                flag = false;
                return num;
            }
            num++;
        }
        return num; 
    }
    
    public char[] bi(long num){
        StringBuilder sb = new StringBuilder();
        while(num > 0 ){
            sb.append(num%2);
            num=num/2;
        }
        max = Math.max(max,sb.toString().length());
        String str = sb.toString()+"0000000000000000000000000"; 
        return str.toCharArray();
    }
}
