import java.util.*;
class Solution {
    static int[][] arr;
    static int col;
    static int row;
    public static int solution(int m, int n, int[][] puddles) {
        // m 열, n이 행 반대가되어야함
        col = m;
        row = n;
        int answer = 0;
        arr = new int[n+1][m+1];// 한개씩 증가 1,1 이라고 생각 
        arr[1][1]=1;
        for(int i=0; i<puddles.length;i++){
            arr[puddles[i][1]][puddles[i][0]]=-1;
        }
        
        answer = (bfs(1,1)-2)%1000000007;// 2칸뺴야댐 여기는 칸만 하니까 
        if(answer<=0) answer=0;
        return answer; // 오른쪽이랑 아래만 생각합니다.
       
    }
    // 상하 좌우 
    static int[] dc = {1,0};
    static int[] dr = {0,1};
    
    public static int bfs(int r, int c){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r,c));
        
        while(!q.isEmpty()){
            Node node = q.poll();
            r = node.getR();
            c = node.getC();
            for(int i =0; i<2;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr<=0||nc<=0||nc>col||nr>row){
                    continue;
                }
                
                if(arr[nr][nc]==-1){
                    continue;
                }else if(arr[nr][nc]==1){
                    arr[nr][nc] = arr[r][c]+1;
                    q.offer(new Node(nr,nc));
                    
                }
                
            }    
        }
        return arr[row][col];
    }
}


class Node{
    private int r;
    private int c;
    
    public Node(int r, int c){
        this.r =r;
        this.c =c;
    }
    
    public int getR(){
        return this.r;
    }
    public int getC(){
        return this.c;
    }
}



/* 어디가 이상할까 . 흠.흠. 

import java.util.*;
class Solution {
    int cnt =0;
    int[][] arr;
    int row;
    int col;
    int[] dr = {1,0};
    int[] dc ={0,1};
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        // m이 열, n 행 , 행열 반대 입니다. 
        col = m;
        row = n;
        for(int i=0; i<puddles.length;i++){
            int b = puddles[i][0]-1;// 열 한개씩 뺴야되느데 까먹었담. 
            int a = puddles[i][1]-1;// 행
            visit[a][b] =true;
            arr[a][b]=1;
        }
        
        bfs(0,0);
        answer = cnt;
        return answer;
    }
    public void bfs(int r,int c){
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r,c));
        while(!q.isEmpty()){
            Node node = q.poll();
            int nr = node.r;
            int nc = node.c;
            if(nr==row-1&&nc==col-1) {
                cnt++;
                continue;
            }
            if(nr>=row||nc>=col||nr<0||nc<0) continue;
            if(arr[nr][nc]==1) continue;
            for(int i =0; i<2;i++){
                int newr = dr[i]+nr;
                int newc = dc[i]+nc;
                q.offer(new Node(newr,newc));
            }
        }
        
    }
    
}

class Node{
    int r;
    int c;
    Node(int r, int c){
        this.r =r;
        this.c = c;
    }
}

*/
