import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>(){
            
            public int compare(int[] o1,int[] o2){
                if(o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        //for(int i=0;i<routes.length;i++)System.out.println(Arrays.toString(routes[i]));
        
        
        for(int i=0;i<routes.length;i++){
            int last = routes[i][1];
            for(int k=i+1;k<routes.length;k++){
                int st = routes[k][0];
                if(last<st) {
                    answer++;
                    i=k-1;
                    break;
                }
            }
        }
        return answer;
    }
}
