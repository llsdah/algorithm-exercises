package programmers;

public class 공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] point = new int[2];
        char[][] charTwoArray = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            char[] charArray = park[i].toCharArray();
            for (int k = 0; k < charArray.length; k++) {
                charTwoArray[i][k] = charArray[k];
                if (charArray[k] == 'S') {
                    point[0] = i;
                    point[1] = k;
                }
            }
        }

        // 포인트 저장 완료 -48
        for (int i = 0; i < routes.length; i++) {
            char[] route = routes[i].toCharArray();
            int[] move = new int[2];
            boolean[] check = new boolean[2];
            if (route[0] == 'E') {

                move[1] = point[1] + (route[2] - 48);
                if (move[1] < charTwoArray[0].length) {
                    check[1] = check(charTwoArray, point[0], point[1], point[0], move[1]);
                }

            } else if (route[0] == 'W') {
                move[1] = point[1] - (route[2] - 48);
                System.out.println(point[0] + ":" + point[1] + ":" + move[1]);
                if (move[1] >= 0) {
                    check[1] = check(charTwoArray, point[0], point[1], point[0], move[1]);
                }
            } else if (route[0] == 'S') {

                move[0] = point[0] + (route[2] - 48);
                if (move[0] < charTwoArray.length) {
                    check[0] = check(charTwoArray, point[0], point[1], move[0], point[1]);
                }
            } else {
                move[0] = point[0] - (route[2] - 48);
                if (move[0] >= 0) {
                    check[0] = check(charTwoArray, point[0], point[1], move[0], point[1]);
                }
            }
            if (check[0]) {
                point[0] = move[0];
            } else if (check[1]) {
                point[1] = move[1];
            }
            System.out.println(point[0] + ":" + point[1]);
        }

        return point;
    }

    public boolean check(char[][] charArray, int nowC, int nowR, int c, int r) {
        boolean check = true;
        int startC = Math.min(nowC, c);
        int endC = Math.max(nowC, c);

        int startR = Math.min(nowR, r);
        int endR = Math.max(nowR, r);

        for (int i = startC; i <= endC; i++) {

            for (int k = startR; k <= endR; k++) {
                if (charArray[i][k] == 'X') {
                    return false;
                }
            }
        }
        return check;
    }
}

