
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class 후보키_실패 {

	public static void main(String[] args) {

		// int m = 4;
		// int n = 5;
		// String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		int m = 2;

		String[][] relation = { 
				{ "100", "ryan", "music", "2" },
				{ "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" },
				{ "400", "con", "computer", "4" },
				{ "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		long result = solution(relation);
		// long[] result = solution4(n,z,roads,queries);

		System.out.println("result : " + result);
		// System.out.println("result : " + Arrays.toString(result));
		// System.out.println("result : "+ Arrays.deepToString(result));

	}

	// 모든조합으로 구하고 , 그 안에서 하면 안도나 일치성 여부 체크 하면 안될까용?
	static int[] count;
	
	static int[][] sel;
	static boolean[] check;
	static int selidx=1;
	
	public static int solution(String[][] relation) {
		int answer = 0;

		// 우선 어느것을 선택할지.. 조합으로 선정하자 
		count = new int[relation[0].length];
		
		for(int i =0; i<count.length;i++) {
			count[i]=i;
		}
		System.out.println(Arrays.toString(count));
		boolean[] visit = new boolean[count.length];
		//count 조합부터 
		
		int combination =0;
		for(int r =0; r<=count.length;r++) {
			
			combination+= comb(count.length,r);
		}
		
		
		sel = new int[combination][relation[0].length];
		check = new boolean[combination];
		
		for(int r =1; r<=count.length;r++) {
			
			comb( count, visit, 0 , count.length , r );
		}
		System.out.println(Arrays.deepToString(sel));
		
		for(int i =0; i< relation.length;i++) {
			System.out.println(Arrays.toString(relation[i]));
			
		}
	
		boolean[] idxck =new boolean[relation[0].length];
		
		
		for(int i =1; i<sel.length;i++) {
			
			if(sel[i][0]==1&&idxck[0]) {
				continue;
			}
			if(sel[i][1]==1&&idxck[1]) {
				continue;
			}
			if(sel[i][2]==1&&idxck[2]) {
				continue;
			}
			if(sel[i][3]==1&&idxck[3]) {
				continue;
			}
			
			
			String str = "";
			loof : for(int y= 0; y< relation.length;y++) {
				
				str = selckeck(i,y,relation);			
				
				for(int a =0; a<relation.length;a++) {
					if( y==a) {
						continue;
					}
					String str2 = selckeck(i,a,relation); //체크용
					
					
					if(str.equals(str2)) {
						check[i] =false;
						break loof;
					}
					
				}
				
				check[i] =true;
			}
			
			
			
			if( check[i]) {
				if(sel[i][0]==1) {
					idxck[0] =true;
				}
				if(sel[i][1]==1) {
					idxck[1] =true;
				}
				if(sel[i][2]==1) {
					idxck[2] =true;
				}
				if(sel[i][3]==1) {
					idxck[3] =true;
				}
				answer++;
			}
			

		}
		
		System.out.println(Arrays.toString(check));
		System.out.println(Arrays.toString(idxck));
		return answer;
	}
	
	private static String selckeck(int i, int y, String[][] relation) {
		String str = "";
//		System.out.println(" I : "+ i+" y : "+ y);
		if(sel[i][0]==1) {
			str+=relation[y][0];
		}
		if(sel[i][1]==1) {
			str+=relation[y][1];
		}
		if(sel[i][2]==1) {
			str+=relation[y][2];
		}
		if(sel[i][3]==1) {
			str+=relation[y][3];
		}
		
		return str;
	}

	private static int comb(int n, int r) {

		if( n==r||r==0) {
			return 1;
			
		}
		
		return comb(n-1,r-1)+ comb(n-1,r);
	}

	//count
	private static void comb(int[] arr, boolean[] visit, int start, int n, int r) {

		if( r==0) {
			print(arr,visit,n);
			return;
		}
		
		for(int i =start; i< n;i++) {
			visit[i]=true;
			comb(arr,visit, i+1,n,r-1);
			visit[i]=false;
			
		}
		
	}//count comb

	private static void print(int[] arr, boolean[] visit, int n) {
		
		for(int i =0; i<n;i++) {
			if(visit[i]) {
				sel[selidx][arr[i]]++;
			}
		}
		selidx++;
	}

}
