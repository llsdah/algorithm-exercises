//흠냐 런타임 에러 뭐지 

class Solution {
    boolean[] check;
    public int solution(int n, int k) {
        int answer = 0;
        // 진수 변환 구하고
        String num = "";
        while(n>k){
            num=n%k+num;
            n = n/k;
        }
        num = n+num;
        
        // 0으로 split
        String[] arr = num.split("0");
        
        int max = 0;
        int[] numArr = new int[arr.length];
        // 해당 웃자만큼 check 배열 생성하고 
        for(int i=0; i<arr.length;i++){
            if(arr[i].equals("")) continue;
            numArr[i] = Integer.parseInt(arr[i]);
            if(max<numArr[i]) max = numArr[i];
        }
        
        
        check = new boolean[max+1];
        check[0] = true;
        check[1] = true;
        primeCheck(max);
        
        for(int i=0; i<numArr.length;i++){
            if(!check[numArr[i]]) answer++;    
        }
            
        return answer;
    }
    // 에라토스테네스의 체
        
    public void primeCheck(int n){
        if (n<=2) return;
        
        for(int i=2; i<Math.sqrt(n);i++){
            if(check[i]) continue;
            // i의 배수를 걸러주기 위한문
            for(int k = i*i; k<check.length;k=k+i){
                check[k] = true;
            }
        }
        
    }
    
}
