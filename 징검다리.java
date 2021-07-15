
/* 처음에 정렬을 통해 계속 접근하는 방식 ... 시간 초과 . 
 public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int[] arr = new int[rocks.length+2];
        for(int i =1;i<=rocks.length;i++){
            arr[i] = rocks[i-1];
        }
        arr[arr.length-1] = distance;
        System.out.println(Arrays.toString(arr));
        int[] cnt = new int[arr.length-1];
        for(int i=0; i<cnt.length;i++){
            cnt[i] = arr[i+1]-arr[i];
        }
        System.out.println(Arrays.toString(cnt));
        
        
        return answer;
    }
*/
