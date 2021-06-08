import java.util.*;
// 중복 !! set 중복제거 갯수가 얼마 안됨 유효한 수 다 찾기 
class Solution {
    HashSet<String> set;
    String[] regex;// 정규 표현식 여부 
    String[] user; // 일치 하는것 띄어쓰기로 저장 
    boolean[] visit;
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        user = user_id;
        regex = new String[banned_id.length];
        for(int i=0;i<banned_id.length;i++){ // 정규식위한 변환 
            regex[i] =banned_id[i].replace("*",".");
        }
        visit= new boolean[user.length]; // 허용 여부 
        back(0,"");
        
        int answer = set.size();
        return answer;
    }
    public void back(int idx,String str){
        if(idx== regex.length){ // 갯수가 했으면
             String[] arr = str.split(" ");
            Arrays.sort(arr); // 정렬 왜? 모든 경우의 수 추출하니까 !!! 중복값 제거 위해서 
            String temp ="";
            for(int i=0; i<arr.length;i++){
                temp+=arr[i];
            }            
            set.add(temp);
            return;
        }
        for(int i=0; i<user.length;i++){
            if(!visit[i]&&user[i].matches(regex[idx])){
                visit[i]= true;
                back(idx+1,str+" "+user[i]);// 가능한것 다 복사 
                visit[i]=false;
            }
        }
    }
}
