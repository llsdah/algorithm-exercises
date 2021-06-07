import java.util.*;

class Solution {
    String[] pic;
    int[] check;
    int pos=0;
    public int solution(int n, String[] data) {
        int answer = 0;
        char[] member = {'A','C','F','J','M','N','R','T'};
        int total =1; // 종 갯수 
        for(int i =8;i>=1;i--){ total*=i;}
        pic = new String[total];
        check =new int[total];
        perm(member,0,8,8);
        
        for(int i=0; i <n;i++){
            char[] st =data[i].toCharArray();// 1,3이 단어, 4조건, 5 거리 
            for(int k=0; k<total;k++){
                if(check[k]>=1)continue;
                int a = restrict(pic[k],st);
                check[k]+=a;
            }    
        }
        answer = (int)Arrays.stream(check).filter( i -> i==0).count();
        return answer;
    }
    public int restrict(String str,char[] st){
        char[] arr = str.toCharArray();
        int fir =0;
        int sec =0;
        for(int i=0;i<arr.length;i++){
          if(st[0]==arr[i]){
              fir = i;
          }else if(st[2]==arr[i]){
              sec =i;
          }
        }
        int dis = Math.abs(fir-sec);
        if(st[3]=='='){
            if(!(dis==1)){
                return 1;
            }
        }else if(st[3]=='>'){
            if(!(dis>(st[4]-'0')+1)){
                return 1;
            }
        }else if(st[3]=='<'){
            if(!(dis<(st[4]-'0')+1)){
                return 1;
            }
        }
        return 0;
    }
    
    public void perm(char[] arr,int depth,int n,int r){
        if(r==depth){
            print(arr,r);
            return;
        }
        for(int i=depth; i<n;i++){
            swap(arr,depth,i);
            perm(arr,depth+1,n,r);
            swap(arr,depth,i);
        }
    }
    public void swap(char[] arr, int depth,int num){
        char temp  = arr[depth];
        arr[depth] =arr[num];
        arr[num]=temp;
    }
    public void print (char[] arr,int num){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num;i++){
            sb.append(arr[i]);
        }
        pic[pos] = sb.toString();
        pos++;
    }
}

/* 내꺼 수정 ... 이건 안된다 왜지??.. 아랫 꺼라 비슷한데 아랫꺼는 되고,.
import java.util.*;
class Solution {
    static String[] d;
    static HashMap<Character,Integer> map =new HashMap<>();;
    static boolean[] visit =new boolean[8];
    static int[] num = new int[8];
    static int ans =0;
    public int solution(int n, String[] data) {
        int answer = 0;
        d =data;
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        dfs(0);
        
        answer = ans;
        return answer;
    }
    public static void dfs(int index){
        if( index==8){
            if(check()) ans++;
        } else {
            for (int i =0; i<8;i++){
                if(!visit[i]){
                    visit[i]= true;
                    num[index] =i;
                    dfs(index+1);
                    visit[i]= false;
                }
            }
        }
    }// dfs
    
    public static boolean check(){
        int a=0;
        int b=0;
        int re=0;
        char oper =' ';
        for( String s : d){
            a =num[map.get(s.charAt(0))];
            b = num[map.get(s.charAt(2))];
            oper =s.charAt(3);
            re = s.charAt(4)-'0'+1;
            
            int temp = Math.abs(a-b);
            if(oper =='='){
                if(temp!=re){
                    return false;
                }
            }else if(oper=='>'){
                if(temp<=re){
                    return false;
                }
            }else {
                if(temp>=re){
                    return false;
                }
            }
        }
        return true;
        
    }
    
}



*/

/*
import java.util.*;

class Solution {
    static String[] d;
    static HashMap<Character,Integer> map ;
    static boolean[] visited;
    static int[] ch;
    static int answer;
    
    public int solution(int n, String[] data) {
        d = data;
        map = new HashMap<>();
        visited = new boolean[8];
        ch = new int[8];
        answer = 0;
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        dfs(0);
        return answer;
    }
    
    public static void dfs(int idx){
        if(idx == 8){
            if(check()) answer++;
        }
        else{
            for(int i=0;i<8;i++){
                if(!visited[i]){
                    visited[i] = true;
                    ch[idx] = i;
                    dfs(idx + 1);
                    visited[i] = false;
                }
            }
        }
    }
    
    
    

    
    public static boolean check(){
        int a,b,res;
        char op;
        for(String s : d){
            a = ch[map.get(s.charAt(0))];
            b = ch[map.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4)-'0' + 1;
            
            if(op == '='){ if(Math.abs(a-b)!=res) return false;}
            else if(op == '>'){ if(Math.abs(a-b) <= res) return false;}
            else {if(Math.abs(a-b) >= res) return false;}
        }
        return true;
    }
}

*/
