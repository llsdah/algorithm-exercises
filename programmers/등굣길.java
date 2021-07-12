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
