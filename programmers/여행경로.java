여행경로
import java.util.*;
class Solution {
    boolean[] visit; // 확인용
    ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        int cnt = 0; // 다 돌았는지 확인용
        String start = "ICN"; 
        String city = "ICN";
        dfs(cnt, start, city, tickets);
        Collections.sort(list);// 까장 순서가 빠른게 앞으로와서 구분하도록 정렬  
        
        String[] answer = list.get(0).split(",");
        return answer;
    }
    public void dfs(int cnt, String st, String city, String[][] arr){
        if( cnt == arr.length){ //순회완료
            list.add(city);
            return;
        }
        for(int i =0; i<arr.length;i++){
            if(!visit[i]&&arr[i][0].equals(st)){
                // 방문 안했고, 시작점과 같다.
                visit[i] =true;// 방문
                dfs(cnt+1,arr[i][1],city+","+arr[i][1],arr);
                visit[i]=false;
            }
        }
        return;
    }
    
}
