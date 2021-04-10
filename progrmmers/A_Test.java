package studyProgrammers;

import java.util.HashMap;
import java.util.Map;

public class A_Test {

	public static void main(String[] args) {

		
//		String s = "ULURRDLLU";
//		String s = "LULLLLLLU";
//		String s = "LRLRL";
		
		
		int result = solution(s);
		System.out.println("result : " + result);

	}

	public static int solution(String dirs) {
		int answer = 0;
		
		// 54321012345
		
		int x= 5;
		int y= 5;
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		
		
		// U D R L 
		// y-1 y+1 x+1 x-1 
		for(int i = 0; i < dirs.length();i++) {
			
			
			if( dirs.charAt(i)=='U') {
				
				if(check(x,y-1)) {
					continue;
				}
			
				if(map.get(x+""+y+x+(y-1)) == null){
					map.put(x+""+y+x+(y-1),1);
					map.put(x+""+(y-1)+x+""+y,1);
		
					answer++;
				}
				y= y-1;
				
			}
			
			if( dirs.charAt(i)=='D') {
				if(check(x,y+1)) {
					continue;
				}
			
				if(map.get(x+""+y+x+(y+1)) == null){
					map.put(x+""+y+x+(y+1),1);
					map.put(x+""+(y+1)+x+""+y,1);
			
					answer++;
				}
				y= y+1;
				
			}
			if( dirs.charAt(i)=='R') {
				if(check(x+1,y)) {
					continue;
				}
			
				if(map.get(x+""+y+(x+1)+y) == null){
					map.put(x+""+y+(x+1)+y,1);
					map.put((x+1)+""+y+x+""+y,1);
				
					answer++;
				}
				x= x+1;
				
				
			}
			if( dirs.charAt(i)=='L') {
				if(check(x-1,y)) {
					continue;
				}
			
				if(map.get(x+""+y+(x-1)+y) == null){
					map.put(x+""+y+(x-1)+y,1);
					map.put((x-1)+""+y+x+""+y,1);
					answer++;
				}
				x= x-1;
				
				
			}
			
			
		}
		
		
		
		return answer;
	}

	private static boolean check(int x, int y) {
		boolean ck = false;
		if(x>=11||y>=11||x<0||y<0) {
			ck =true;
		}
		
		
		return ck;
	}

}