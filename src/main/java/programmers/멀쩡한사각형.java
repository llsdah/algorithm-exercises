class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        //3 3 = 3 같으면 그 갯숫 만큼 입니다. 
        // 3 2 = 4 
        // 5 4 = 
        // 범위 값 확인 필수 !!! 
        long wid = Long.valueOf(w);
        long hei = Long.valueOf(h);
        
        if(wid==hei) return wid*hei-wid;
        // 그림 그려서 생각 해보자
        long gcd= gcd ( wid,hei);
        // 대각선의 최대공약수 까지 나눈수 있다 
        // 직선의 갯수는 최소한의 거리입니다. 
        
        answer = wid*hei-wid-hei+gcd;
        return answer;
    }
    public long gcd(long w,long h){
        if(w%h==0){
            return h;
        }else {
            return gcd(h,w%h);
        }
    }
}
/*
class Solution {
    public long solution(long w, long h) {
        long answer = 0;
        
        for(int i=0; i<w; i++) {
            answer += h*i/w ;
        }
        
        return answer * 2;
    }
}
*/
