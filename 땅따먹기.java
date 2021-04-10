package studyProgrammers;

import java.util.Arrays;



/*
 * d
 * 엄청 간단 배워야대...
 * 	private static int solution(int[][] land) {

		
		for( int i =1;i < land.length;i++) {
			
			land[i][0] = Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]))+ land[i][0];
			land[i][1] = Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]))+ land[i][1];
			land[i][2] = Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]))+ land[i][2];
			land[i][3] = Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]))+ land[i][3];
			
			
		};
		
		int n = land.length-1;
		
		
		
		return Math.max(Math.max(land[n][0], land[n][1]), Math.max(land[n][2], land[n][3]));
	}
 * 
 * 
 */
public class 땅따먹기 {


	public static void main(String[] args) {

		String s = "()()";
//		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		String s = "{{20,111},{111}}";

		int n = 78;
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
/*		int[][] land = { 
				{4, 3, 2, 1},
				{2, 2, 2, 1},
				{6, 6, 6, 4},
				{8, 7, 6, 5 } 
				};*/
		int result = solution(land);
		System.out.println("result : " + result);
//		System.out.println("result : " + Arrays.toString(result));

	}

	static int idx;
	static boolean count = false; //중복된것이 없다.
	public static int solution(int[][] land) {
		int answer = 0;
		idx=0;
		// 한행씩 내려올떄 같은 열은 역속해서 밟을 수 없는 특수규칙 가로 , x축안됨
		// 4열만 있음.
		// 행 열
		int sum = 0;
		
		// 중복된것이 있으면
		
		
		System.out.println(Arrays.toString(land[0]));
		for (int y = 0; y < land[0].length; y++) {
			idx=y;
			sum = land[0][y];
			for (int x = 1; x < land.length; x++) {
				System.out.println(Arrays.toString(land[x]));
				sum+=sum(idx,land[x]);
				
			}
			System.out.println("num : "+ sum);
			System.out.println();
			answer = Math.max(sum, answer);
		}
		

		return answer;
	}
	
	
	
	
	private static int sum(int y, int[] pos) {

		int num =0;
		
		for(int i =0; i< pos.length;i++) {
			
			if(i==y&&!count) {
				continue;
			}else if( num < pos[i]){
				System.out.println("pos : "+pos[i]);
				num = pos[i];
				idx = i;
			}
			
		}
		
		for(int i =0; i<pos.length;i++) {
			if( num == pos[i]&&!(i==idx)) {
				count=true;
				break;
			}
			
		}
		System.out.println("count : "+ count);
		
		
		return num;
	}




	private static int sum2(int y, int[] pos) {
		int num  =0;
		
		Integer[] temp = Arrays.stream(pos).boxed().toArray(Integer[]::new);		
		num = Arrays.stream(pos).max().getAsInt();
		idx = Arrays.asList(temp).indexOf(num);
		
		System.out.println("idx : "+ idx + " num : "+num+" y : "+y);

		
		
		
		if( idx==y ) {
			num=0;
			for( int i =0; i<pos.length;i++) {
				
				if( y!=i) {
					num = Math.max(pos[i], num);
				}
				
			}
			idx = Arrays.asList(temp).indexOf(num);
			return num;
			
		}
		
		
		return num;
	}


}
