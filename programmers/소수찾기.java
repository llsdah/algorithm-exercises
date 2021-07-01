import java.util.*;
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int solution(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();
        boolean[] visit = new boolean[arr.length];
        
        for(int i=1;i<=arr.length;i++){
            perm(arr,0,arr.length,i);
        }
        Iterator<Integer> it = map.keySet().iterator();
        int cnt =0;
        while(it.hasNext()){
            cnt+=bi(map.get(it.next()));
        }
        answer =cnt;
        return answer;
    }
    public int bi(int num){
        if(num<2) return 0;
        for(int i =2;i<=num/2;i++){
            if(num%i==0) return 0;
        }
        //System.out.println(num);
        return 1;
    }
    
    public void perm(char[] arr,int depth, int n,int r){
        if(r==depth){
            print(arr,r);
            return;
        }
        for(int i=depth;i<n;i++){
            swap(arr,depth,i);
            perm(arr,depth+1,n,r);
            swap(arr,depth,i);
        }
    }
    
    public void swap(char[] arr, int depth,int i){
        char temp = arr[depth];
        arr[depth] =arr[i];
        arr[i] = temp;
    }
    public void print(char[] arr,int r){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<r;i++){
            sb.append(arr[i]);
        }
        String str =sb.toString();
        int num = Integer.valueOf(str);
        //System.out.println(num);
        map.put(num,num);
    }
}
