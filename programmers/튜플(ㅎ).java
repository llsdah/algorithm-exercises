import java.util.*;

class Solution {
    boolean[] check;
    int count =0;
    int col;
    int row;
    public int solution(String[][] relation) {
        int answer = 0;// 20행, 8열
        col = relation[0].length;
        row = relation.length;
        check = new boolean[col];
        boolean[] visit = new boolean[col];
        int[] num = new int[col];
        for(int i =0; i < col;i++){num[i]=i;} // 숫자 넣기 // 인덱스 
        for(int i = 0; i <col;i++){
            comb(num,visit,0,col,i,relation);
        }
        answer = count;
        return answer;
    }
    public void comb(int[] num,boolean[] visit,int start,int n,int r,String[][] relation){
        if(r==0){
            print(num,visit,n,relation);
            return;
        }
        for(int i =start;i<n;i++){
            visit[i]=true;
            comb(num,visit,i+1,n,r-1,relation);
            visit[i]=false;
        }
    }
    public void print(int[] num,boolean[] visit,int n,String[][] relation){
        String str ="";
        for(int i=0; i< n;i++){
            if(visit[i]){
                if(check[num[i]])return;

                str+=num[i];
            }
        }
        int leng = str.length();
        equ(str,leng,relation);
        
    }
    public void equ(String str,int leng,String[][] relation){
        HashMap<String,Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        boolean flag = false;
        for(int i =0;i<row;i++){
            String temp ="";
            for(int k=0;k<leng;k++ ){
                int pos = arr[k]-'0';
                temp+=relation[i][pos];
            }
            if(map.getOrDefault(temp,0)==0){
                map.put(temp,1);
            }else{
                flag =true;
                break;
            }
        }
        
        if(!flag){
            for(int k=0;k<leng;k++ ){
                int pos = arr[k]-'0';
                check[pos] =true;
            }
            count++;
        }
        
            
    }
    
}
