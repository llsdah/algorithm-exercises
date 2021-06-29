// 1번 5번 .. 흠..
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        // ArraysList 로 값을 입력하고. 리스트의 정렬을 하면되지
        ArrayList<Num> list = new ArrayList<>();
        for(int i=0; i<operations.length;i++){
            String[] arr=operations[i].split(" ");
            if(arr[0].equals("I")){
                list.add(new Num(Integer.valueOf(arr[1])));
                continue;
            }
            if(list.size()==0) continue;
            else if(operations[i].equals("D 1")){
                list.remove(list.size()-1);
            } else {
                list.remove(0);
            }
            Collections.sort(list);
        }
        if(list.size()==0){
            return answer;
        }
        
        answer[0] = list.get(list.size()-1).num;
        answer[1]  = list.get(0).num;
        
        return answer;
    }
}
class Num implements Comparable<Num>{
    int num;
    Num(int num){
        this.num=num;
    }
    
    public int compareTo(Num o){
        return this.num-o.num;
    }
}
