class Solution {
    int[] arr;
    int N;
    int cnt=0;
    public int solution(int n) {
        int answer = 0;
        N=n; //전체 수 
        arr = new int[n]; // 위치는 열  값은 행입니다. 
        
        nq(0);// 시작입니다.
        answer = cnt ;
        return answer;
    }
    public void nq(int num ){
        if( num==N) {
            cnt++;
            return;
        }
        for(int i=0; i<N;i++){ // 전체 행 입력하며 검색합니다. 
            arr[num]=i;//해당 위치에 들어 간다는 의미 
            if(check(num))  nq(num+1); // num 입력이 가능하면 다음으로 넘어감
        }
        
    }
    public boolean check(int num){
        for(int i=0; i<num;i++){
            if(arr[num]==arr[i]) return false;// 해당 것에 이미 방문 했으면. 
            else if(Math.abs(num-i)==Math.abs(arr[num]-arr[i])) return false;
            //대각선에 위치할 경우 
            
        }
        return true;
    }
}
