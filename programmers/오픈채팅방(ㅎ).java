import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<>();
        for(int i=0; i<record.length;i++){
            String[] arr = record[i].split(" ");
            if(arr[0].equals("Leave")){
                continue;
            }else{
                map.put(arr[1],arr[2]);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i =0; i<record.length;i++){
            String[] arr = record[i].split(" ");
            if(arr[0].equals("Leave")){
                ans.append(map.get(arr[1])+"님이 나갔습니다."+",");
                continue;
            }else if(arr[0].equals("Enter")){
                ans.append(map.get(arr[1])+"님이 들어왔습니다."+",");
            }
        }
        String[] answer = ans.toString().split(",");
        return answer;
    }
}
