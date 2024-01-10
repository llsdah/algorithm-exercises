package zerobase.linear;

/**
 * 중복값 제거한 새 배열을 만드세요
 */
public class Practice6 {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,2,3,1,4,1,2,3,5};
        int[] arrResult = new int[arr.length];
        int cnt = 0;

        for(int i=0;i<arr.length;i++){
            boolean dupFlag = false;
            for(int k=0;k<cnt;k++){
                if(arr[i]== arrResult[k]){
                    dupFlag=true;
                }
            }

            if(dupFlag==false){
                arrResult[cnt++] = arr[i];
            }

        }
        for(int i=0;i<cnt;i++){
            System.out.print(arrResult[i]+" ");
        }
        System.out.println(" ");

    }
}
