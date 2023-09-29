import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
     
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        // 그냥 입력 
        for(int i =0;i<participant.length;i++ ){
            if(map.getOrDefault(participant[i],0)==0){
                map.put(participant[i],1);
            }else{
                map.put(participant[i],map.get(participant[i])+1);
            }
        }
        
        // 완주자 중에 참가자 명단에 없는 사람체크
        for(int i=0; i<completion.length;i++ ){
            if(map.getOrDefault(completion[i],0)==0){
                answer+=completion[i]+",";
            }else{
                map.put(completion[i],map.get(completion[i])-1);
            }
        }
        // 참가자 중에 완주 못한사람 체크 
        for(int i =0;i<participant.length;i++ ){
            if(map.get(participant[i])==1){
               if(!answer.contains(participant[i])){
                    answer+=    participant[i]+",";
               }
                
            }
        }
        
        answer = answer.substring(0,answer.length()-1);
        return answer;
    }
}
