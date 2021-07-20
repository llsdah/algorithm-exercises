
// 숫자 세기를 활용한 담ㅂ. map
import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        // 해당 원소의 등장 횟 수 저장
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.getOrDefault(a[i],-1)==-1) map.put(a[i],1);
            else map.put(a[i],map.get(a[i])+1);
        }
        
        for(int key : map.keySet()){
            if(map.get(key)*2<=answer) continue;// 답보다 작으면 할 이유가 없다.
            int num=0;
            for(int i=0; i<a.length-1;i++){// 2개씻 이동이다.
                if((a[i]==key||a[i+1]==key)&&(a[i])!=a[i+1]){
                    num+=2; //2개씩 추가
                    i++;
                }
                
            }
            answer = Math.max(answer,num);
            
        }
        
        return answer;
    }
}
