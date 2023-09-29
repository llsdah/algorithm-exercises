	public static int solution(String str1, String str2) {

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();
		HashMap<String,Integer> map2 = new HashMap<String,Integer>();
		
		HashMap<String,Integer> all = new HashMap<String,Integer>();
	
		for( int i =0; i+2<=str1.length();i++) {
			
			String st = str1.substring(i,i+2);
			char[] temp = st.toCharArray();
			if( temp[0]>'z'||temp[0]<'a' ||temp[1]>'z'||temp[1]<'a') {
				continue;
			}
			
			map1.put(st,map1.getOrDefault(st, 0)+1);
			all.put(st,1);
			
		}
		for( int i =0; i+2<=str2.length();i++) {
			
			String st = str2.substring(i,i+2);
			char[] temp = st.toCharArray();
			if( temp[0]>'z'||temp[0]<'a' ||temp[1]>'z'||temp[1]<'a') {
				continue;
			}
			
			map2.put(st,map2.getOrDefault(st, 0)+1);
			all.put(st,1);
			
		}
		
		int min =0;
		int max =0;
		
		for( Map.Entry<String, Integer> entry : all.entrySet()) {
			String key = entry.getKey();
			
			int m1 = map1.getOrDefault(key, 0);
			int m2 = map2.getOrDefault(key, 0);
			
			min += Math.min(m1, m2);
			max += Math.max(m1, m2);
			
		}
		
		double answer = (min==0&&max==0) ?1 :(double)min/max;
		
		return (int)(answer*65536);
	}
