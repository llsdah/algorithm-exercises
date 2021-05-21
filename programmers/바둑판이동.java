import java.util.*;

class Solution {
    int leng =0;
    public int solution(String dirs) {
        int answer = 0;
        int[][] arr = new int[11][11];
        HashMap<String,Integer> map = new HashMap<>();
        // 시작 끝 
        int col = 5 ;
        int row = 5 ;
        char[] dir = dirs.toCharArray();
        
        for(int i =0;i<dir.length;i++){
            String temp =col+""+row;
            char ch = dir[i];
            if(ch == 'R' ){
               if(col>=10)continue;
                col++;
                check(map,temp,col,row);
            }else if (ch=='U'){
                if(row<=0)continue;
                row--;
                check(map,temp,col,row);
            }else if ( ch=='L'){
                if(col<=0)continue;
                col--;
                check(map,temp,col,row);
            }else if ( ch=='D'){
                if(row>=10)continue;
                row++;
                check(map,temp,col,row);
            }
            
        }
        answer =leng;
        return answer;
    }
    public void check(HashMap<String,Integer> map , String temp,int col,int row){
        if(map.getOrDefault(temp+col+""+row, 0)==0){
            map.put(temp+col+""+row,1);
            map.put(col+""+row+temp,1);
            leng++;
        }
        
    }
}
