package zerobase.test.seven;

public class Sol {

    public int solution3(int N, int M, int[][] board) {
        int answer = 0;
        System.out.println(board[0][2]); // 맨위가 0
        System.out.println(board[N-1][2]); // 맨 아래가
        int[] main = {0,0};
        // 주인공 위치 찾기
        for(int row=0;row<M;row++){
            if(board[N-1][row]==2){
                main[0] = N-1;
                main[1] = row;
                break;
            }
        }

        int[] stay = {main[0]-1,main[1]};
        int[] left = {main[0]-1,main[1]-1};
        int[] right = {main[0]-1,main[1]+1};

        int numS = 0;
        int numL = 0;
        int numR = 0;

        if(stay[1]>=0 && stay[1]<M && board[main[0]][stay[1]]!=1){
            numS = move3(N,M,board,stay,0);
        }

        if(left[1]>=0 && left[1]<M && board[main[0]][left[1]]!=1){
            numL = move3(N,M,board,left,0);
        }

        if(right[1]>=0 && right[1]<M && board[main[0]][right[1]]!=1){
            numR = move3(N,M,board,right,0);
        }


        answer = Math.max( numS
                ,Math.max(numL,numR)
        );

        return answer;
    }

    // 수정 후 입력.
    public int move3(int N, int M, int[][] board,int[] main, int value){
        System.out.println(main[0]+" : "+main[1]+" : "+value);
        if(main[0]<0||main[0]>=N||main[1]<0||main[1]>=M){
            System.out.println("범위 초과 ");
            return value;
        }
        if(board[main[0]][main[1]]==1){
            System.out.println("충돌");
            return value;
        }

        int[] stay = {main[0]-1,main[1]};
        int[] left = {main[0]-1,main[1]-1};
        int[] right = {main[0]-1,main[1]+1};

        int numS = value;
        int numL = value;
        int numR = value;

        if(stay[1]>=0 && stay[1]<M && board[main[0]][stay[1]]!=1){
            numS = move3(N,M,board,stay,value+1);
        }

        if(left[1]>=0 && left[1]<M && board[main[0]][left[1]]!=1){
            numL = move3(N,M,board,left,value+1);
        }

        if(right[1]>=0 && right[1]<M && board[main[0]][right[1]]!=1){
            numR = move3(N,M,board,right,value+1);
        }

        return Math.max( numS
                ,Math.max(numL,numR)
        );
    }

/**


 9, 10,
 [
 [0, 0, 1, 1, 1, 1, 1, 1, 1, 1],
 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1],
 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1],
 [1, 1, 1, 1, 0, 0, 1, 1, 1, 1],
 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
 [1, 0, 0, 1, 0, 0, 0, 0, 1, 1],
 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1],
 [0, 0, 0, 2, 0, 0, 0, 0, 0, 0]
 ]
답6
 */

}
