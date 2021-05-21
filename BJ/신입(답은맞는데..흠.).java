import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int n = scan.nextInt();
		int[] ans = new int[n];
		for(int i=0; i< n;i++) {
			int peo = scan.nextInt();
			int[][] rank = new int[peo][2];
			for(int k=0; k<peo;k++) {
				rank[k][0]= scan.nextInt();
				rank[k][1]= scan.nextInt();
			}    	
			ans[i]=count(rank);
		}
        for(int i =0; i< ans.length;i++){
            System.out.print(ans[i]+" ");
        }
	}

	private static int count(int[][] rank) {

		Arrays.sort(rank, (o1,o2)-> Integer.compare(o1[0], o2[0]));
		int max =0;
		int cnt1 =1;
		for(int i=1; i<rank.length;i++) {
			if(rank[i-1][1]<rank[i][1] ) {
				continue;
			}
			cnt1++;
		}
        
		max = cnt1;
		return max;
	}
	

}
