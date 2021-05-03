
import java.util.Arrays;

public class 금광 {

	static int[] dp = new int[100];

	public static void main(String[] args) {

		int[][] arr = { 
				{ 1, 3, 3, 2 },
				{ 2, 1, 4, 1 },
				{ 0, 6, 4, 7 } };
		
		/// 하핫
		for (int k = 1; k < arr[0].length; k++) {
			for (int i = 0; i < arr.length; i++) {

				if( i==0) {
					arr[i][k] =
							Math.max(arr[i][k-1],arr[i+1][k-1] )+arr[i][k];
					
				}else if( i==arr.length-1) {
					arr[i][k] =
							Math.max(arr[i-1][k-1],arr[i][k-1] )+arr[i][k];
				} else {
					arr[i][k] =
							Math.max(arr[i-1][k-1],
									Math.max(arr[i][k-1],arr[i+1][k-1])	)
							+arr[i][k];
				}
			}

		}

		
		// 무시...


		int ans = Arrays.stream(arr[arr.length - 1]).max().getAsInt();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i][3]);
		}
		System.out.println(Arrays.deepToString(arr));
		System.out.println(max);
		System.out.println(ans);
	}
}
