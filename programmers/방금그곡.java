import java.util.*;

class Solution {

    static String arrM;
    static boolean[] arrCk;
    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        m = change(m);
        arrM =m;
        for(int i =0; i<musicinfos.length;i++) {
            musicinfos[i] =change(musicinfos[i]);
        }

        // [0][0]  = 시작 시 : [1][1] 끝 분
        String[][] sp = new String[musicinfos.length][4];
        HashMap<String,String[][]> map = new HashMap<String, String[][]>();
        HashMap<Integer,String> ans = new HashMap<Integer,String>();


        for(int i =0; i<sp.length;i++) {

            String[][] time =new String[2][2];
            sp[i] =musicinfos[i].split(",");
            time[0] = sp[i][0].split(":");
            time[1] = sp[i][1].split(":");
            map.put(sp[i][2],time);
            ans.put(i, sp[i][2]);
        }

        // 시간이 얼마 인지 부터 찾기 
        int[] takeTime = new int[musicinfos.length];
        arrCk = new boolean[musicinfos.length];

        for(int i=0; i<sp.length;i++) {

            String[][] time =map.get(sp[i][2]);
            if((Integer.parseInt(time[1][0])-Integer.parseInt(time[0][0]))==0) {

                takeTime[i] = Integer.parseInt(time[1][1])-Integer.parseInt(time[0][1]);

                    }else if((Integer.parseInt(time[1][0])-Integer.parseInt(time[0][0])) ==1) {
                takeTime[i] +=Integer.parseInt(time[1][1]);
                takeTime[i] += (60- Integer.parseInt(time[0][1]));
            }else if((Integer.parseInt(time[1][0])-Integer.parseInt(time[0][0])) >1) {

                takeTime[i] +=(((Integer.parseInt(time[1][0])-Integer.parseInt(time[0][0])-1))*60);
                takeTime[i] +=Integer.parseInt(time[1][1]);
                takeTime[i] += (60- Integer.parseInt(time[0][1]));
            }

            char[] pitch = sp[i][3].toCharArray();
            check(i, takeTime[i],pitch);

        }

        int cnt =-1;
        int max =0;
        for(int i =0; i<arrCk.length;i++) {

            if(arrCk[i]) {

                cnt = takeTime[i] > max ? i : cnt;
                max = Math.max(takeTime[i], max);

            }
        }

        if(cnt ==-1) {
            answer = "(None)";
        } else {
            answer = ans.get(cnt);
        }



        return answer;
    }
    // #변환 
    private static String change(String m) {

        StringBuilder sb = new StringBuilder();
        char[] arr = m.toCharArray();
        for(int i =0; i<arr.length-1;i++) {

            if(arr[i+1]!='#') {
                sb.append(arr[i]);
            }else {
                sb.append((char)(arr[i]+32));
                i++;
            }

        }
        if(arr[arr.length-1]!='#') {
            sb.append(arr[arr.length-1]);
        }
        m=sb.toString();
        return m;
    }

    //c# d#, f# g# a#

    private static void check(int idx, int time, char[] pitch) {


        String[] rep = new String[time];
        String strR = "";

        for(int i =0; i<rep.length;i++) {

            rep[i] = pitch[i%pitch.length]+"";
            strR+=rep[i];

        }

         if( rep.length < arrM.length()) { arrCk[idx]=false; return; }


        if( strR.contains(arrM) ) {         
            arrCk[idx]=true;
        }
        return;
    }


}
