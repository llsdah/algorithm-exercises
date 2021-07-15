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
