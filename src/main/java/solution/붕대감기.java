package solution;

public class 붕대감기 {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int max = health;
        int cnt = 0; //

        while(true){
            cnt ++;

            boolean flag = false; // 공격 받는지 여부
            boolean maxCnt = false; // 최대 시간
            // 1초씩 줄이기
            for(int i=0;i<attacks.length;i++){
                attacks[i][0]--;
            }

            // 0초가 되면 healtch에서 뺴기, 뺼때 더하지 안함
            for(int i=0;i<attacks.length;i++){
                if(attacks[i][0]>=0) maxCnt = true;

                if(attacks[i][0]==0){
                    health-=attacks[i][1];
                    flag = true; // 공격받음
                    cnt = 0; //공격 받음 0시작
                    break; // 현재 반복문 그만
                }
            }

            if(!maxCnt) break;// 시간지남 좋료

            if(health <= 0 ) {
                health = -1;
                break; //공격받음 끝남
            }

            if(!flag){ //공격받았을때는 안함.
                health += bandage[1]; //초당 회복량
                if(cnt==bandage[0]){ // 해당 초동안 잘버티면
                    health+=bandage[2];
                    cnt = 0;
                }
            }

            if(health>= max){
                health = max;
            }

        }

        return health;
    }
}
