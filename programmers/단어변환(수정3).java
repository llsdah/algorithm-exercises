

/* 기본 풀이 
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = (int)1e9;
        if(!equal(target,words)){
            return 0;
        };
        
        Queue<Word> q = new LinkedList<Word>();
        q.offer(new Word(begin,0));
        
        while(!q.isEmpty()){
            Word word = q.poll();
            String str = word.getWord();
            int cnt = word.getCnt();
            if(str.equals(target)){
                answer = Math.min(answer,cnt);
                break;
            }
            
            for(int i =0; i<words.length;i++){
                if( one(str,words[i])){
                    q.offer(new Word(words[i],cnt+1));
                }
            }
            
        }
        
        
        return answer;
    }
    public boolean one(String str1, String str2){
        int cnt =0;
        for(int i=0; i<str1.length();i++){
            if( str1.charAt(i)!=str2.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1){
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean equal(String target,String[] words){
        int cnt = 0;// 해당 단어 포함 여부 체크 
        for(int i=0; i<words.length;i++){
            if(words[i].equals(target)){
                break;
            }else{
                cnt ++;
            }
        }
        
        if(cnt==words.length){
            return false;
        } 
        
        return true;
    }
}

class Word{
    private String word;
    private int cnt;
    
    public Word(String word, int cnt){
        this.word= word;
        this.cnt = cnt;
    }
    public String getWord(){
        return this.word;
    }
    public int getCnt(){
        return this.cnt;
    }
}



*/
