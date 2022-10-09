import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        // x에 숫자 든 갯수 
        int[] check = new int[10];
        
    
        // x넣고 
        char[] ch = X.toCharArray();
        for(int i =0; i< ch.length;i++){
            check[ch[i]-'0']++;
        }        
        
        ch = Y.toCharArray();
        // 숫자 확인 할 갯수 
        int[] cnt = new int[10];

        for(int i =0; i<ch.length;i++){
            if(check[ch[i]-'0']>0){
                cnt[ch[i]-'0']++;
                check[ch[i]-'0']--;
            }
        }
        
        for(int i =9; i>=0;i--){
            while(cnt[i]>0){
                answer+=i;
                cnt[i]--;
            }
        }
        
        if(answer.length()==0) answer="-1";
        else if (answer.charAt(0)=='0') answer="0";
        return answer;
    }
    
    // 처음에는 큐로 넣고 나머지를 뺸다고 생각 그ㅓㅀ지만 
    public Queue queue(String temp){
        
        
        // Queu Stact
        //int[] num = new int[X.length()];
        //큐에 해당 내용 집어 넣기 
        //Queue<Integer> xQue = queue(X);
        //Queue<Integer> yQue = queue(Y);
        
        Queue<Integer> que = new ArrayDeque<Integer>();
        char[] ch  = temp.toCharArray();
        
        for(int i =0; i<ch.length;i++){
            que.add(Character.getNumericValue(ch[i]));
        }
        return que;
    }
}
