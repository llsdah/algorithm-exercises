
import java.util.Arrays;

public class 모험가길드 {

	public static void main(String[] args) {
		
		
		int n=5;
		int[] arr= {2,3,1,2,2,1,1,1,1};
		
		int count=0;
		Arrays.sort(arr);
		int group=0;
		for(int i=0;i<arr.length;i++) {
			count++;
			if( count==arr[i]) {
				group++;
				count=0;
			}
			
		}
		System.out.println(group);
	}
}
