
    public static int[] solution(String[] genres, int[] plays) {
        String[][] arr = new String[plays.length][2];
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i =0; i<arr.length;i++){
            arr[i][0]= genres[i];
            arr[i][1]=plays[i]+"";
            if(map.getOrDefault(genres[i],-1)==-1){
                map.put(genres[i],plays[i]);
            }else{
                map.put(genres[i],map.get(genres[i])+plays[i]);
            }
        }
        // 맴으로는 최대값이 무엇이지알아 냈다.
        // 글자 정렬
        Arrays.sort(arr, (o1,o2)-> Integer.valueOf(o1[1]).compareTo(Integer.valueOf(o2[1])) );
        String[][] map_arr = new String[map.size()][2];
        Iterator<String> it = map.keySet().iterator();
        int pos =0;
        while(it.hasNext()){
            String temp = it.next();
            map_arr[pos][0] = temp;
            map_arr[pos][1] = map.get(temp)+"";
            pos++;
        }
        Arrays.sort(map_arr, (o1,o2)-> Integer.valueOf(o1[1]).compareTo(Integer.valueOf(o2[1])) );
        String ans ="";
        for(int i =map_arr.length-1;i>=0;i--){
            String temp = map_arr[i][0];
            System.out.println(temp);
            int cnt =0;
            for(int k=arr.length-1; k>=0;k--){
                if(arr[k][0].equals(temp)){
                    cnt++;
                    ans = ans+check(temp,Integer.valueOf(arr[k][1]),genres,plays)+",";
                }
                if(cnt>=2){
                    break;
                }
            }
            
        }
        
        System.out.println();
        System.out.println(Arrays.deepToString(map_arr));
        System.out.println(Arrays.deepToString(arr));
        System.out.println(ans);
        
        
        String[] str_arr = ans.split(",");
        System.out.println(str_arr.length);
        int[] answer =new int[str_arr.length];
        for(int i=0; i<answer.length;i++) {
        	answer[i]=Integer.valueOf(str_arr[i]);
        }
        return answer;
    }
    public static int check(String str, int num, String[] genre,int[] play){
        int pos=-1;
        for(int i=play.length-1; i>=0;i--){
            if( genre[i].equals(str)&&play[i]==num){
                pos=i;
                break;
            }
        }
        return pos;
    }
