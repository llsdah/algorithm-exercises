class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        //3 3 = 3 같으면 그 갯숫 만큼 입니다. 
        // 3 2 = 4 
        // 5 4 = 
        if(w==h) return w;
        // 그림 그려서 생각 해보자 
        int gcd= gcd ( w,h);
        // 대각선의 최대공약수 까지 나눈수 있다 
        // 직선의 갯수는 최소한의 거리입니다. 
        
        answer = w*h-(w/gcd+h/gcd-1)*gcd;
        return answer;
    }
    public int gcd(int w,int h){
        if(w%h==0){
            return h;
        }else {
            return gcd(h,w%h);
        }
    }
}
