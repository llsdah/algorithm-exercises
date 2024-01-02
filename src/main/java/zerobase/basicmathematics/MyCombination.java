package zerobase.basicmathematics;

public class MyCombination {
    public static void main(String[] args) {
        // 조합
        int[] numArr = {1,2,3,4};
        int n = numArr.length;
        int range = 3;
        int depth = 0; //체크용
        boolean[] visited = new boolean[n];
        System.out.println("방문용");
        visit_combination(numArr,visited,depth,n,range);
        System.out.println("방문용");

    }

    private static void visit_combination(int[] numArr, boolean[] visited, int depth, int n, int range) {
        if(range==0){
            for(int i=0;i<n;i++){
                if(visited[i]){
                    System.out.print(numArr[i]);
                }
            }
            System.out.println();
            return;
        }

        if(depth==n){
            return;
        }

        visited[depth] = true;
        visit_combination(numArr,visited,depth+1,n,range-1);

        visited[depth] = false;
        visit_combination(numArr,visited,depth+1,n,range);

    }
}
