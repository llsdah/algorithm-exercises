package studyProgrammers;

import java.util.Arrays;

public class 순위검색 {

	
	public static void main(String[] args) {
		
		
	}
	static String[][] exp;
	public static int[] solution(String[] info, String[] query) {
		// 언어 직군 경력 소울푸드 점수
		int[] answer = new int[query.length];

		exp = new String[info.length][5];
		String[][] data = new String[query.length][5];
		
		for (int y = 0; y < exp.length; y++) {
			exp[y] = info[y].split(" ");

		}

		// and까지 구별해서 출력해보자

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replace("and ", "");
			query[i] = query[i].replace("  ", " ");

		}

		for (int y = 0; y < data.length; y++) {
			data[y] = query[y].split(" ");
		}


		int count = 0;
		for (int k = 0; k < data.length; k++) {

			count = check(data[k]);
			answer[k] = count;
		}

		System.out.println(Arrays.deepToString(exp));
		System.out.println(Arrays.deepToString(data));

		return answer;
	}

	private static int check(String[] str) {
		boolean ck = true;
		int count =0;
		for (int x = 0; x < exp.length; x++) {
			 ck = true;
			for (int y = 0; y < 4; y++) {
				if (str[y].equals("-")) {
					continue;
				} else if (!str[y].equals(exp[x][y])) {
					

					ck = false;
					break;
				}

			}

			if (ck && str[4].equals("-")) {
				ck = true;
			} else if ( ck&&Integer.valueOf(exp[x][4])<Integer.valueOf(str[4])) {
				ck =false;
			}
			
			if( ck ) {
				count++;
			}

		}

		return count;
	}

	
}
