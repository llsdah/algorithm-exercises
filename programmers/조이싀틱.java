class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();
        
        // 상하 이동 체크 중간은 N
        int ud =0;
        for(int i =0; i<arr.length;i++){
            if(arr[i]=='N'){
                ud+=13;
            }else if(arr[i]<'N'){
                ud+=(arr[i]-'A');
            }else {
                ud+=('N'-arr[i]+13);
            }
        }
        // 좌우이동의 최소값 찾기
        int move = arr.length-1;// 최소이동은
        for(int i =0; i <arr.length;i++){
            if(arr[i]!='A'){
                int next =i+1;
                while(next<arr.length&&arr[next]=='A'){
                    next++;
                }
                int temp = i*2+arr.length-next;
                move = Math.min(move,temp);
            }
        }
        
        answer = ud+move;
        return answer;
    }
}
