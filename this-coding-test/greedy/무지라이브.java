
	public static int solution1(int[] food_times, long k) {
        int answer = -1;
        // 각음식 = index , 시간이 times.
        int le = food_times.length;
        int pos = -1;
        for(int i =0; i<k;i++){
            
            if(food_times[i%le]!=0){
                food_times[i%le]--;
                pos = i%le;
            }else{
                k++;
            }
            
        }
        
        if( pos == food_times.length-1){
            for(int i =0; i< pos;i++ ){
                if(food_times[i] != 0 ){
                  return i+1;
                }
            }  
        }
        
        for(int i =pos+1; i<food_times.length;i++ ){
            if(food_times[i]!=0 ){
                return i+1;
            }
        }
        
        for(int i =0; i<pos;i++ ){
            if(food_times[i]!=0 ){
                return i+1;
            }
        }
        
        return answer;
    }
