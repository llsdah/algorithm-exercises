package zerobase.linear.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 14 -1
 * Dummy 도스 게임 뱀이 나와서 기어다니며 사과먹으면 길어짐
 * NxN 보드 뱀길이 1 처음엔 오른쪽방향이동, 맨좌측 위치
 * 벽을 만나도 끝나고 자기의 몸과 부딪혀도 끝난다.
 *
 * 매초 이동
 * 1. 몸길이 늘여 머리를 다음칸 위치
 * 2. 이동한 칸에 과자 있다면 그찬 사과 없어지고 꼬리 그대로
 * 3. 사과 없다면 몸길이 출여ㅓ 꼬리가 위치한 칸 비워줌
 * 4. 사과 위치와 이동결로 주어짐 몇초에 게임이 끝나냐
 * 맨위 맨좌측 == 1,1
 * N K L apples moves
 * 보드크기 사과갯수 뱀이동변환수 사과위치 뱀방향변환정보
 *
 * 사과 위치 : 행, 열
 * 뱀방향변환 : (X,C) 게임시작 시간으로 부터 X초 끈난 뒤 왼쪽"L", 오른쪽"D"으로  90도 이동
 *
 * 예
 * 6 3 3 [(3,4),(2,4),(5,3)] [(3,"D"),(15,"L"),(17,"D")]
 *
 * 출력 9
 * 10 4 4 [(1,2),(1,3),(1,4),(1,5)] [(8,"D"),(10,"D"),(11,"D"),(13,"L")]
 *
 * 출력 9
 *
 *
 */
public class Practice5_star {
    public static void main(String[] args) {

        int N = 6;
        int K = 6;
        int L = 6;
        int[][] apples =
                {
                        {3,4},
                        {2,4},
                        {5,3}
                };
        Queue<ArrayList> move = new LinkedList<>();
        move.add(new ArrayList(Arrays.asList(3,'D')));
        move.add(new ArrayList(Arrays.asList(15,'L')));
        move.add(new ArrayList(Arrays.asList(17,'D')));

        int sol1 =sol(N,K,L,apples,move);

        System.out.println(sol1);

//* 10 4 4 [(1,2),(1,3),(1,4),(1,5)] [(8,"D"),(10,"D"),(11,"D"),(13,"L")]

        int N2 = 10;
        int K2 = 4;
        int L2 = 4;
        int[][] apples2 =
                {
                        {1,2},
                        {1,3},
                        {1,4},
                        {1,5}
                };
        Queue<ArrayList> move2 = new LinkedList<>();
        move2.add(new ArrayList(Arrays.asList(8,'D')));
        move2.add(new ArrayList(Arrays.asList(10,'D')));
        move2.add(new ArrayList(Arrays.asList(11,'D')));
        move2.add(new ArrayList(Arrays.asList(13,'L')));

        int sol2 =sol(N2,K2,L2,apples2,move2);

        System.out.println(sol2);

    }

    public static int sol(int N, int K, int L, int[][] apples, Queue<ArrayList> move){
        int[][] board = new int[N+1][N+1];
        for(int[] row : apples){
            board[row[0]][row[1]] = 1;
        }
        // 선입선출 꼬리가 빠진다
        Queue<ArrayList> snake = new LinkedList<>();
        snake.add(new ArrayList(Arrays.asList(1,1)));

        // 방향 잡는 용도
        ArrayList<ArrayList> direction = new ArrayList<>();
        // 90도 이동 방향대로 작성하는 것이 편하다
        direction.add(new ArrayList(Arrays.asList(0,1))); // 오른
        direction.add(new ArrayList(Arrays.asList(1,0))); // 아래
        direction.add(new ArrayList(Arrays.asList(0,-1))); // 왼
        direction.add(new ArrayList(Arrays.asList(-1,0))); // 위

        int dIdx = 0; //우선 오른쪽
        int score = 0;
        int x = 1;
        int y = 1;

        while(true) {
            score++;

            // 위치 정보 업데이트
            x += (int) direction.get(dIdx).get(0);
            y += (int) direction.get(dIdx).get(1);

            // 이동 범위
            if (1 <= x && x <= N && 1 <= y && y <= N) {
                // 현재위치
                ArrayList cur = new ArrayList(Arrays.asList(x, y));

                // 몸과 부딪힙니다.
                if (snake.contains(cur)) {
                    return score;
                }

                snake.add(cur);
                // 사과 유무
                if (board[x][y] == 0) {
                    snake.poll();
                } else if (board[x][y] == 1) {
                    board[x][y] = 0;
                }
            } else {
                return score;
            }

            // 방향이동 부분 있는 경우만
            if (move.size() > 0 && score == (int) move.peek().get(0)) {
                if ((char) move.peek().get(1) == 'D') {// 우측 90도 이동
                    dIdx = (dIdx + 1) % 4;
                    move.poll();
                } else { // 좌측 이동방향
                    dIdx = (dIdx - 1) % 4;
                    move.poll();
                }
            }
        }

    }
}

















