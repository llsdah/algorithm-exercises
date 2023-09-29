
    public static int[] solution(String s) {
        s = s.substring(1,s.length()-2);
        s = s.replace(",{","").replace("{","");
        String[] temp = s.split("}");
        
        for(int i =0; i<temp.length;i++){
            for(int k = i; k<temp.length;k++){
                if(temp[i].length() > temp[k].length()){
                    String str = temp[i];
                    temp[i] =temp[k];
                    temp[k] =str;
                }
            }    
        }
        
        //System.out.println(temp[0]);
        
        ArrayList<ArrayList<Integer>> ar =new ArrayList<ArrayList<Integer>>();
        int maxLe =0;
        for(int i =0; i<temp.length;i++){
            ar.add(new ArrayList<Integer>());
            String[] arr = temp[i].split(",");
            maxLe =arr.length;
            for(int k=0; k< arr.length;k++){
                int num = Integer.valueOf(arr[k]);
                ar.get(i).add(num);
            }
        }
        
        int[] answer = new int[maxLe];
        
        int pos =0;
        for(int i =0; i<maxLe;i++){

            for(int k=0; k<ar.get(i).size();k++) {
        		// k 번쨰를 가지로
            	int cnt =-1;
        		for(int h =0; h<ar.get(i).size() ;h++) {
        			if(answer[h] ==ar.get(i).get(k)) {
        				cnt++;
        				break;
        			}
        		}
        		if( cnt==-1) {
        			answer[pos] = ar.get(i).get(k);
        			pos++;
        			break;
        		}

            }
        	
        	
        	
        	
        }
        
        
        return answer;
    }
