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
