import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		int book = sc.nextInt(); // 책 몇군?
		int[] arr = new int[n];
		for(int i =0; i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr); // 기본 정렬 
		PriorityQueue<Integer> plus = new PriorityQueue<Integer>((x,y)-> y-x);// 양수는 역정렬 합니다. 
		PriorityQueue<Integer> mi = new PriorityQueue<Integer>();

		for(int i =0; i <arr.length;i++) {
			if(arr[i]>=0) plus.add(arr[i]);
			else mi.add(arr[i]);
		}
		
		int num =0; //기초값
		int max =0;// 최대값은 안 움직임 한번 뺴줌
		int sum =0; // 총합계 
		// 양 수 
		while(!plus.isEmpty()) {
			for(int i=0; i<book;i++) { // 해당 갯수 만큼만 뺴고 넣고 
				if(plus.isEmpty()) continue;
				num = plus.poll();// 뺴면됩
				// 역순으로 정렬해 놓은 상태 즉, 처음 방문이 제일 큰 숫자 
				if( i ==0) {
					sum+= num;// 어짜피 양수 
					max = Math.max(max, num);// 젤 큰수 저장용
				}
			}
		}// 양수 용
		
		// 음수 
		while(!mi.isEmpty()) {
			for(int i=0; i<book;i++) { // 해당 갯수 만큼만 뺴고 넣고 
				if(mi.isEmpty()) continue;
				num = mi.poll();// 뺴면됩
				// 역순으로 정렬해 놓은 상태 즉, 처음 방문이 제일 큰 숫자 
				if( i ==0) {
					num = Math.abs(num); //음수 변환
					sum+= num; 
					max = Math.max(max, num);// 젤 큰수 저장용
				}
			}
		}
		
		sum = sum *2 -max;
		System.out.println(sum);
		
	}

}
/* 틀립.. 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		int num = sc.nextInt(); // 책 몇군?
		int[] arr = new int[n];
		for(int i =0; i<n;i++) {
			arr[i]=sc.nextInt();
		}

		int max =0; // 가장 최대가 될떄 마지막으로 해야됩니다. 
		Arrays.sort(arr);
		int cnt =0;
		int temp = 0;
		
		
		// 0 을 기준으로 부호가 바뀔때는 그냥 다녀와도 똑 같다. 
		for(int i=0; i<n;i++) {
			if(arr[i]>0) { // 양수로 변경 된다면 끝내야댐.
				cnt+= (2*temp);// 왐복값이니까 2배 !
				temp =0; //변경
				break;
			}
			temp = Math.max(Math.abs(arr[i]), temp); // 해당 항의 최대 값
			max = Math.max(temp, max);
			if( (i+1)%num==0) { // 해당 나누어지는 값까지 왔다면.
				cnt+= (2*temp);// 왐복값이니까 2배 !
				temp =0; //변경
			}
		}

		int pos =0;
		for(int i=arr.length-1; i>=0;i--) {
			if(arr[i]<0) { // 양수로 변경 된다면 끝내야댐. 
				cnt+= (2*temp);// 왐복값이니까 2배 !
				temp =0; //변경
				break;
			}
			
			temp = Math.max(Math.abs(arr[i]), temp); // 해당 항의 최대 값
			max = Math.max(temp, max);
			pos++;
			if( pos%num==0) { // 해당 나누어지는 값까지 왔다면.
				cnt+= (2*temp);// 왐복값이니까 2배 !
				temp =0; //변경
				pos=0;
			}
		
		}
		
		
		System.out.println(cnt-max);
		
	}

}


*/
