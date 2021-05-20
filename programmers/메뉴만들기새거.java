import java.util.*;
class Solution {
    int max;
    public String[] solution(String[] orders, int[] course) {
        String arr = "";
        for(int i=0; i<course.length;i++){
            int cnt = course[i];
            HashMap<String,Integer> map = new HashMap<>();
            max =0;
            for(int k=0; k<orders.length;k++){
                char[] words = orders[k].toCharArray();
                boolean[] visit = new boolean[words.length];
                comb(words,visit,0,words.length,cnt,map);
            }
            // map의 최고 값 추출 
            arr += menu(map);
            
        }
        String[] answer = arr.split(",");
        Arrays.sort(answer);
        
        return answer;
    }
    public void comb(char[] words, boolean[] visit, int start,int n,int r,HashMap<String,Integer> map){
        if(r==0){
            print(words,visit,n,map);
            return;
        }
        for(int i =start;i<n;i++){
            visit[i]=true;
            comb(words,visit,i+1,n,r-1,map);
            visit[i]=false;
        }
    }
    
    public void print(char[] words,boolean[] visit,int n ,HashMap<String,Integer> map){
        String temp = "";
        for(int i =0; i< n ;i++){
            if(visit[i]){
                temp+=words[i];
            }
        }
        char[] arr = temp.toCharArray();
        Arrays.sort(arr);
        String word = new String(arr);
        if( map.getOrDefault(word,0)==0){
            map.put(word,1);
        }else{
            map.put(word,map.get(word)+1);
            max = Math.max(max, map.get(word));
        }
        
    }
    
    public String menu(HashMap<String,Integer> map){
        String temp ="";
        Iterator<String> it = map.keySet().iterator();
        
        while(it.hasNext()){
            String word = it.next();
            
            if( max == map.get(word)){
                temp+= word+",";
            }
            
        }
        return temp;
    }
    
}
