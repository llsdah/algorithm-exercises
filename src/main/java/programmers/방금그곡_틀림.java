package studyProgrammers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A_Test {

	public static void main(String[] args) {

		// int m = 4;
		// int n = 5;
		// String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		int m = 2;

		String s = "ABCDEFG";
		String[] music = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//		String s = "CC#BCC#BCC#BCC#B";
//		String[] music = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
//		String s = "ABC";
//		String[] music = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String result = solution(s, music);
		
		// long[] result = solution4(n,z,roads,queries);

		System.out.println("result : " + result);
		// System.out.println("result : " + Arrays.toString(result));
		// System.out.println("result : "+ Arrays.deepToString(result));

	}

	static char[] arrM;
	static boolean[] arrCk;
	public static String solution(String m, String[] musicinfos) {
		String answer = "";
		arrM =m.toCharArray();
		
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
//int[][] nums =Arrays.stream(time).mapToInt(Integer::parseInt).toArray();

		System.out.println(Arrays.deepToString(sp) );
		// 시간이 얼마 인지 부터 찾기 
		int[] takeTime = new int[musicinfos.length];
		arrCk = new boolean[musicinfos.length];
		
		for(int i=0; i<sp.length;i++) {
			
			String[][] time =map.get(sp[i][2]);
			if((Integer.parseInt(time[1][0])-Integer.parseInt(time[0][0]))==0) {
				
				takeTime[i] = Integer.parseInt(time[1][1])-Integer.parseInt(time[0][1]);
				
			}else if((Integer.parseInt(time[1][0])-Integer.parseInt(time[0][0])) >=1) {
				
				takeTime[i] +=(((Integer.parseInt(time[1][0])-Integer.parseInt(time[0][0])-1))*60);
				takeTime[i] +=Integer.parseInt(time[1][1]);
				takeTime[i] += (60- Integer.parseInt(time[1][1]));
			}
			char[] pitch = sp[i][3].toCharArray();
			check(i, takeTime[i],pitch);
			System.out.println();
			
		}
		
		
		
		//System.out.println(Arrays.toString(takeTime));
		
		int cnt =0;
		for(int i =0; i<arrCk.length;i++) {
			
			if(arrCk[i]) {
				answer =ans.get(i);
			cnt ++;
			}
		}
		if(cnt ==0) {
			answer = "(None)";
		}
		
		return answer;
	}
	
	//c# d#, f# g# a#
	private static void check(int idx, int time, char[] pitch) {

		
		String[] rep = new String[time];
		String strR = "";

		int pos =0;
		for(int i =0; i<rep.length;i++) {
			
			rep[i] = pitch[pos%pitch.length]+"";
			if(pitch[(pos+1)%pitch.length]=='#') {
				rep[i]+='#';
				pos++;
			}
			pos++;
			strR+=rep[i];
			
		}
		
		 if( rep.length < arrM.length) { arrCk[idx]=false; return; }
		 		
		
		String strM = String.valueOf(arrM);
		
		//System.out.println("strR : "+strR);
		//System.out.println("strM : "+strM);
		
		
		if( strR.contains(strM) ) {
			int index = strR.indexOf(strM)+strM.length();
			char[] arrR = strR.toCharArray();
			
			if( arrR[index]=='#') {
				System.out.println("정답아닙..");
				arrCk[idx]=false;
				return;
			}
			
		}

		arrCk[idx]=true;
		
		System.out.println(Arrays.toString(arrM));
		System.out.println("반복된것 다 합친것 : "+Arrays.toString(rep));
		
		return;
	}
}






