import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	// 리스트의 indexOf(값) 어느 위치 반환
	// 리스트 remove(index)  해당 위치 값 삭제 
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int max = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<max;i++) {
			list.add(sc.nextInt());
		}
		
		int cnt =0;
		int low = max ; // 최대 값이 낮은 등수 입니다. 
		while(list.size()>1) {
			int pos = list.indexOf(low);// 꼴등 위치 반환
			
			if(pos==0) {
				cnt+= list.get(pos) - list.get(pos+1); 
			}else if( pos == list.size()-1) { // 맨끝에 있으면 ?
				cnt += list.get(pos) - list.get(pos-1); // 큰수 - 작은수!!
			}else {
				cnt+= Math.min( list.get(pos) - list.get(pos-1),
						list.get(pos) - list.get(pos+1));
			}
			list.remove(pos); //삭제만 하면됨하하하 왜냐하면. 이긴사람은 계속 남아있으니까
			low--;// 
		}
		System.out.println();
		System.out.println(cnt);
		
		System.out.println();
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=0; i<10;i++) {
			temp.add(i);
		}
		System.out.println("5번위 의치"+ temp.indexOf(5));
		temp.remove(3);
		System.out.println("3번쨰 삭제 후 5번위 의치"+ temp.indexOf(5));
		
		
	}

}


//
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(arr[0]);
		
		int cnt = 0; // 갯수 생각
		int pos =1;
		while(!q.isEmpty()) {
			int pre = Math.abs(arr[pos]-q.peek());
			int next = Math.abs(arr[pos+1]-arr[pos]);
			
			if(pre > next) { // 차이 나서 작은거  기준 넣고 뺴기 
				q.offer(Math.min(arr[pos+1], arr[pos]) );
				pos++;
			}else {
				int temp = q.poll();
				q.offer(  Math.min(temp,arr[pos]));
			}
			pos+=2;
			
			
		}
		
	
	}

}
