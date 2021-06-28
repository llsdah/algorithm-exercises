
// 정답 2.  나풀이
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt();

		// 글래스 생성해서 날짜 순으로 정렬 
//		ArrayList<Test> list = new ArrayList<>();
		int[][] arr =new int[n][2];
		for(int i=0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
		}
		Arrays.sort(arr, (o1,o2)-> Integer.compare(o1[0], o2[0]) );
		
		
		PriorityQueue<Integer> q = new PriorityQueue<>();//라면 값 넣기 (오름차순됨)
		
		//Collections.sort(list);
		long sum =0;
		for(int i=0; i<n;i++) {
			int dead = arr[i][0];
			int prize = arr[i][1];
			q.offer(prize);
			while(!q.isEmpty()&& q.size()>dead) {
				q.poll(); // 사이즈가 크면 작은거 없에면된다. 
			}
		}
		while(!q.isEmpty()) {
			sum+=q.poll();
		}
		System.out.println(sum);
		
	}
}

// 정답 1. 
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt();
        ArrayList<Test> list = new ArrayList<>();
        for(int i=0; i<n;i++) {
			int day = sc.nextInt();
            int prize = sc.nextInt();
            list.add(new Test(day,prize));
		}
		
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        Collections.sort(list);
        long sum =0;
        for(int i=0; i<n;i++){
            int dead =list.get(i).day;
            int prize = list.get(i).prize;
            q.offer(prize);
            while(!q.isEmpty()&&q.size()>dead ){
                q.poll();
            }
        }
        while(!q.isEmpty()){
            sum+=q.poll();
        }
		System.out.println(sum);
		
	}

}
class Test implements Comparable<Test>{
    int day;
    int prize;
    Test(int day,int prize){
        this.day =day;
        this.prize =prize;
    }
    public int compareTo(Test o){
        return this.day -o.day;
    }
}


/* 시간 초과 판정 

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt();

		int[][] arr =new int[n][3];
		for(int i=0; i<n;i++) {
			arr[i][0] =i;
			arr[i][1] =sc.nextInt();
			arr[i][2] =sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o2[1]==o1[1]) {
					return o2[2]-o1[2];
				}
				return o2[1]-o1[1];
			}
			
		});
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		int num =n-1;
		int sum =0;
		while(num>0) {
			int temp =0;
			int pos =-1;
			for(int i=0; i<n ; i++) {
				if(arr[i][1]>=num) {
					if(temp<arr[i][2]) {
						temp= Math.max(arr[i][2],temp);
						pos =i;
						
					}
				}else	break;
				
			}
			sum+=temp;
			if(pos!=-1) arr[pos][2]=0;
			num--;
		}
		System.out.println(sum);
		for(int i=0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
*/
