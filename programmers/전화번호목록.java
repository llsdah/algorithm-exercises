class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0; i<phone_book.length;i++){
            String str = phone_book[i];
            for(int k=0;k<phone_book.length;k++){
                if(i==k) continue;
                if(phone_book[k].startsWith(str)) return false;
                if(str.startsWith(phone_book[k])) return false;
            }
        } 
        
        return answer;
    }
}
