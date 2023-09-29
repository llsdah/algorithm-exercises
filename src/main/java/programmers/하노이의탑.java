import java.util.*;
class Solution {
    // 세개의 기둥과 원판
    // 원하는건 이동 방향과 순서에 따른 출력입니다.
    ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        // 재귀 
        if(n==1) { // 한개면 그냥 마지막에 가서 끝. 
            int[][] temp ={{1,3}};
            return temp;
        }
        // 나머지는 순서
        // 1. 출발지의 n-1개 원판 경유지로 이동
        // 2. 출발지의 한개남은 것을 도착지로 이동
        // 3. 경유지의 n-1개의 원판을 도착지로 이동
        
        // 총 갯수 시작 도착 , 경유
        solve(n,1,3,2);
        
        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size();i++){
            int[] temp = list.get(i);
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }
        
        return answer;
    }
    public void solve(int n, int start, int end, int via){
        int[] move ={start,end};
        if(n==1){
            list.add(move);
        }else {
            solve(n-1,start, via,end);
            list.add(move);
            solve(n-1,via,end,start);
        }
    }
    
}
