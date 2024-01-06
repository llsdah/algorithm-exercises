package zerobase.basicmathematics;

/**
 * 지도가 주어졌을때, 둘레를 구하는 겅보 구하기
 * 포인트 : 물과 닿아 있으면 1, 아니면 0
 */
public class Practice5 {
    private static final int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        System.out.println();
        int[][] grid = {{1}};
        System.out.println(solution1(grid));
        System.out.println(solution2(grid));
        grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(solution1(grid));
        System.out.println(solution2(grid));


    }

    public static int solution1(int[][] grid){
        int cnt = 0;

        int row = grid.length;
        int col = grid[0].length;
        for (int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]==1){
                    for(int[] d : direction){
                        int x = d[0]+r;
                        int y = d[1]+c;
                        if( x<0||y<0||x>=row||y>=col||grid[x][y]==0){
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    // 재귀 구현을 통한 구현
    public static int solution2(int[][] grid){
        int result=0;
        int row = grid.length;
        int col = grid[0].length;

        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]==1){
                    return recursion(grid, r,c);
                }
            }
        }

        return result;
    }

    private static int recursion(int[][] grid, int r, int c) {
        int cnt = 0;
        int row = grid.length;
        int col = grid[0].length;
        grid[r][c] = -1; // 물이 아닌 것을 체크
        for(int[]d : direction){
            int x = r+d[0];
            int y = c+d[1];
            if(x<0||y<0||x>=row||y>=col||grid[x][y]==0){ // 사방이 물일때만 증가
                cnt++;
            }else{
                if(grid[x][y]==1){
                    cnt+=recursion(grid,x,y);
                }
            }
        }
        return cnt;
    }

}
