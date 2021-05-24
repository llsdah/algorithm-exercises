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
