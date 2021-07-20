// 다름 답. 
import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] cnt = new int[a.length+1];// 해당 숫자가 등장하는 갯수 세기 위한 것.
        for(int i =0; i<a.length;i++){
            cnt[a[i]]++;// 해당 숫자 등장시 증가.
        }
        for(int i =0; i<cnt.length;i++){
            if(cnt[i]<=answer||cnt[i]==0) continue;//작으면 필요없음.
            int num =0;//숫자 사용된 횟수 
            for(int k=0; k<a.length-1;k++){
                if(a[k]==a[k+1])continue;// 인정 두개의 값이 동일 하면 계속 조건..
                if(a[k]!=i&&a[k+1]!=i) continue;//인접원소를 가져야댐
                num++;
                k++;// 다음숫자로 넘어갑니다. 
            }
            answer = Math.max(answer,num);// 가장많이 사용 
        }
        
        answer*=2;//여기 중용 왜? 공통원소를 가지고 있으면 주면 인접값을 하나씩 더 가져도되니까.!
        return answer;
    }
}

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
