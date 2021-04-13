    public static int[] solution(int n, String[] words) {

    	// 몇번쨰에서 틀린자 누구 차례인가.
    	//words.length/n 전체 횟수 ( 차례 )
    	int[] answer = new int[2];
        String[][] ending = new String[words.length/n][n];
    
        // 모든 것 넣기+ 직전 것 넣기 
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("last", words[0]);
        map.put(words[0],"1");
        
        int i =0;
        
        for(int y =0; y<ending.length;y++ ) {
        	
        	for(int x=0;x<ending[y].length;x++) {
        		ending[y][x] = words[i];
        		//넣기
        		System.out.println(words[i]+" 	어디서 끝맣 : "+x+":"+y );
	        	if(i==0) {
        				i++;
	        			continue;
	        	};
        		
        		if(!map.containsKey(words[i])) {
        			map.put(words[i], "1");
        		}else {	
        			System.out.println("어디서 contrain : "+x+":"+y );
        			answer[0] = x+1;
        			answer[1] =y+1;
        			return answer;
        			
        		}
        		
        		if( i!=0 && (map.get("last").charAt(map.get("last").length()-1) != words[i].charAt(0))   ) {
        			System.out.println("어디서 일치 : "+x+":"+y );
        			answer[0] = x+1;
        			answer[1] =y+1;
        			return answer;
        			
        		}else {
        			map.put("last", words[i]);
        		}
        		i++;
        	}
        	
        }
        
        
    	System.out.println(words.length/n); 
        return answer;
    }
