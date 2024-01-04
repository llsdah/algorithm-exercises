package zerobase.basicmathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 문저열이 순열로 통해 다건을 출력하고 체크하는 로직
 */
public class Practice3 {
    public static void main(String[] args) {
        String main ="ab";
        String check="abbbbba";
        boolean flag = solusion(main,check);
        solution2(main,check);
        main="";
        flag = solusion(main,check);
        solution2(main,check);
    }

    private static void solution2(String main, String check) {
        final int ALPHABET=24;
        if(main.length()>check.length())return;

        int[] cnt = new int[ALPHABET];
        for(int i=0;i<main.length();i++){
            cnt[main.charAt(i)-'a']++;

        }
        for(int i=0;i<check.length();i++){
            cnt[check.charAt(i)-'a']--;
            if(1-main.length()>=0){
                cnt[check.charAt(i-main.length())-'a']++;
            }
            boolean isZero =true;
            for(int k=0;k<cnt.length;k++){
                if(cnt[k]!=0){
                    isZero=false;
                    break;
                }
            }
            if(isZero){
                System.out.println(isZero);
                return;
            }
        }
        System.out.println(false);
    }

    private static boolean solusion(String main, String check) {
        boolean result = false;
        char[] arr = main.toCharArray();
        boolean[] visit = new boolean[main.length()];
        char[] out = new char[main.length()];
        ArrayList<String> str = new ArrayList<>();
        visit_permutation(arr, 0,arr.length, arr.length, visit,out,str);

        for(String s :str){
            if(check.contains(s)){
                result=true;
                break;
            };
        }
        System.out.println(result);
        return result;
    }

    private static void visit_permutation(char[] arr, int depth, int n, int range, boolean[] visit, char[] out, ArrayList<String> list){
        if(depth==range){
            list.add(new String(out));
            System.out.println(new String(out));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i]=true;
                out[depth]=arr[i];
                visit_permutation(arr,depth+1,n,range,visit,out,list);
                visit[i]=false;
            }
        }
    }

}
