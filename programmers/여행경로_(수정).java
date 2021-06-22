
/* 답 1
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class A_Test {

	public static void main(String[] args) {


		String[][] a = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] result = solution(a);
		
		
		System.out.println("result : " + Arrays.toString(result));
	}
	static boolean[] visited;                    //방문한지 안한지를 체크하는 visited배열
    static ArrayList<String> answers;
 
    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];    
        answers = new ArrayList<String>();
        int count = 0;                                    //몇개의 공항을 들렸는지 알려주는 카운트
        dfs(count, "ICN", "ICN",tickets);                
        
        
        Collections.sort(answers);                        //답들 중 가장 알파벳순이 빠른 배열들로 정렬
        String[] answer = answers.get(0).split(" ");    //가장 빠른 배열을 뽑아서 String형 배열로 만듬
        return answer;
    }
    
    public static void dfs(int count, String present, String answer, String[][]ticktes) {
        if(count == ticktes.length) {            //모든 공항을 들렸다면
            answers.add(answer);                //answers에 추가
            return;
        }
        for(int i = 0; i < ticktes.length; i++) {
            if(!visited[i] && ticktes[i][0].equals(present)) {        //present와 같고 들리지 않은 공항을 찾고
                visited[i] = true;                                    //해당 공항을 들린걸로 만듬.
                dfs(count+1, ticktes[i][1],answer+" "+ticktes[i][1] , ticktes);    //카운트 +1 도착 공항을 present로 넣어주고 answer에 도착공항을 추가해준다.
                visited[i] = false;
            }
        }
        return;
    }

}
*/
/*
import java.util.*;

class Solution {
    ArrayList<City> graph = 
        new ArrayList<City>();
    boolean[] visit;  
    HashMap<String,Integer> map;
    String str ="ICN,";
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        String[] gogo = new String[2];
        gogo[0] = "ICN";
        gogo[1] = "ZZZ";
        map = new HashMap<>();
        for(int i =0; i<tickets.length;i++){
            map.put(tickets[i][0],1);
            map.put(tickets[i][1],1);
            if(tickets[i][0].equals("ICN")){
                gogo[1] = gogo[1].compareTo(tickets[i][1]) >0 ? tickets[i][1] : gogo[1];
            }
            
        } 
        
        int total = map.size();
        visit = new boolean[tickets.length];
        for(int i=0; i<tickets.length;i++){
            graph.add(new City(tickets[i][0],(tickets[i][1])));
        }
        
        Collections.sort(graph,(o1,o2)->
                        o1.getEnd().compareTo(o2.getEnd()));
       
        for(int i =0; i< graph.size();i++){
            City city = graph.get(i);
            if( city.getStart().equals(gogo[0])&&
               city.getEnd().equals(gogo[1])){
                visit[i]=true;
                break;
            }
        }
        
        bfs(gogo[0],gogo[1]);
        System.out.println(str);
        return answer;
    }
    // 1 이 미방문, 0이방만
    public void bfs(String begin,String stop){
        Queue<City> q = new LinkedList<>();
        q.offer(new City(begin,stop));
        map.put(begin,0);
        while(!q.isEmpty()){
            City ci = q.poll();
            String start = ci.getStart();     
            String end = ci.getEnd();
            str+=end+",";
            for(int i=0;i<graph.size();i++){
                City temp = graph.get(i);
                if(temp.getStart().equals(end)&&!visit[i]){
                    q.offer(new City(end,temp.getEnd()));
                    visit[i] =true;
                }
            }
        }
        
        
        
        
    }

    
}



class City {
    private String start;
    private String end;
    
    public City(String start,String end){
        this.start= start;
        this.end = end;
    }
    public String getStart(){
        return this.start;
    }
    public String getEnd(){
        return this.end;
    }
    
}

*/
