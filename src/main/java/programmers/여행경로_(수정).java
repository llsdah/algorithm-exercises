import java.util.*; // 시간초과 
class Solution {
    int[] visit;
    public String[] solution(String[][] tickets) {
        visit = new int[tickets.length];
        StringBuilder sb = new StringBuilder();
        String start = "ICN";
        // 우선 정렬 
        Arrays.sort(tickets, new Comparator<String[]>(){
           public int compare(String[] o1, String[] o2){
               if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
               return o1[0].compareTo(o2[0]);
           }
        });
        sb.append(start+",");
        
        while(true){
            for(int i=0; i<tickets.length;i++){
                if(visit[i]==1) continue;
                if(tickets[i][0].equals(start)){
                    start = tickets[i][1];
                    sb.append(tickets[i][1]+",");
                    visit[i]= 1;
                    break;
                }
            }    
            long num = Arrays.stream(visit).filter(i -> i == 1 ).count();
            if(num ==visit.length) break;
        }
        
        String[] answer = sb.toString().split(",");
        
        return answer;
    }
}

// 이건 모든 항공권 사용을 위해 .. 순서가 꼬인 항공권의 경우 안된다 그렇기에 정답 1 면 dfs로 사용해야된다.
import java.util.*; // 시간 초과 
class Solution {
    	public String[] solution(String[][] tickets) {
		Arrays.sort(tickets, (o1,o2)-> o1[1].compareTo(o2[1]));
		int[] check = new int[tickets.length];// 0 이면 방문 안한거 1이면 방문 한것 . 
		int num = 0;
		String str = "ICN";
		StringBuilder sb = new StringBuilder(str);
		while(num != check.length ) {
			
			for(int i =0; i <tickets.length;i++) {
				if(check[i]==0&&tickets[i][0].equals(str)) {
					sb.append(","+tickets[i][1]);
					str = tickets[i][1];
					check[i]=1;
					break;
				}
			}
			num = (int)Arrays.stream(check).filter(k -> k ==1).count();	
		}
		String[] answer = sb.toString().split(",");
		
		return answer;
	}
}

/* 답 1
import java.util.*;

class Solution {
    boolean[] visit; //방문체크
    ArrayList<String> ans=new ArrayList<String>(); // 답
    public String[] solution(String[][] tickets) {
        
        visit = new boolean[tickets.length];
        int cnt =0;// 전체 순회인지 확인
        String start = "ICN";// 시작도시
        String  city = new String(start);// 방문도시
        dfs(cnt,start,city,tickets);
        Collections.sort(ans);// 순서 정렬 빠른순 
        String[] answer = ans.get(0).split(",");
        return answer;
    }
    public void dfs(int cnt,String start,String city,String[][] tickets){
        if(cnt == tickets.length){
            ans.add(city); //전체 다 돌고면 
            return;
        }
        for(int i =0; i<tickets.length;i++){
            if(!visit[i]&&tickets[i][0].equals(start)){
                // 시작점과 같고 방문 안했으면, 
                visit[i] =true;
                dfs(cnt+1,tickets[i][1],city+","+tickets[i][1],tickets);
                visit[i]=false;
            }
        }
        return;
    }
}*/
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
