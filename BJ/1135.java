import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N=0;
    static ArrayList<Node>[] list;
    public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
        N = sc.nextInt();
        list = new ArrayList[N];
        int temp = sc.nextInt();// 자시 자신은 필요없어서 그냥 
        for(int i=0; i<N;i++){
            list[i] = new ArrayList<>();// 초기화 배열 생성합니다. 
        }
        for(int i =1; i<N;i++){
            int sup = sc.nextInt();
            list[sup].add(new Node(0,i));// 직속 상사와 부하 연결
        }
        
        int ans = solve(0);// 시작 점
        System.out.println(ans);
    }    
    public static int solve(int pos){
        int max =0;// 답 구할꺼 거리가 가장 최대인거 반환하면됩니다.
        for(int i=0; i<N;i++){
            int next = list[pos].get(i).sub;// 다음 부하에 연결합니다.
            list[pos].get(i).dis = 1 + solve(pos+1);// 다음 상사 연결
        }
        Collections.sort(list[pos]);// 해당 리브스 배열을 정렬합니다. 
        for(int i =0; i <list[pos].size();i++){
            list[pos].get(i).dis += i;// 스스로에서 그 다음 사람까지 걸리는 시간
            // 즉, 0번상사가 2번부하에게 전화 걸려먼 2분 걸림
            max = Math.max(max, list[pos].get(i).dis);// 큰거
        }
        
        return max;
    }
}

class Node implements Comparable<Node>{
    int dis;// 거리
    int sub;// 부하
    Node(int dis, int sub){
        this.dis = dis;
        this.sub =sub;
    }
    public int compareTo(Node o){
        if(o.dis ==this.dis ) return this.dis-o.dis;//오름차순
        return o.dis - this.dis; // 내림차순
    }
}
