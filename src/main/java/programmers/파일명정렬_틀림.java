import java.util.*;

class Solution {
	static String[][] file;
	static String[] arrFile;
	public static String[] solution(String[] files) {
		String[] answer = {};
		file = new String[files.length][3];
		arrFile = files;
		// 파일 명은 영문자 시작, 숫자 하나 이상을 포함하고 있다. // 012 = 12 // 0으로 구별둘수도 있다.
		// head numser = tail 숫자를 만나면, 시작, 숫자를 안만날때까지,

		change(arrFile);
				
		arrSort();
		answer = arrFile;
		return answer;
	}

	private static void change(String[] files) {
		for (int i = 0; i < files.length; i++) {

			char[] arr = files[i].toCharArray();
			boolean numCk = false;
			int start = 0;
			int end = 0;
			for (int k = 0; k < arr.length; k++) {

				if (arr[k] >= '0' && arr[k] <= '9' && !numCk) {
					start = k;

					numCk = true;
				} else if (!(arr[k] >= '0' && arr[k] <= '9') && numCk) {
					end = k;
					break;
				}
			} // 최초 숫자의 시작과 끝을 답아 내는 곳.
			
			file[i][0] = files[i].substring(0, start).toLowerCase();
			file[i][1] = files[i].substring(start, end);
			file[i][2] = files[i].substring(end);

		}
		
	}

	// temp 배열의 정렬
	private static void arrSort() {
		String temp ="";
		
		for (int y = 0; y < file.length; y++) {
			//String st = file[y][0];
			//String num = file[y][1];
			for (int x = 0; x < file.length; x++) {
				if( y>=x) {
					continue;
				}
				String[] ck = new String[2];
				ck[0] = file[y][0];
				ck[1] = file[x][0];
				Arrays.sort(ck);
				if( ck[0].equals(ck[1])) {
					// 2번 비교하는거 해야댑니다...  단 시작이 0인 경우 조심.
					int[] nums =new int[2];
					nums[0] = Integer.parseInt(file[y][1]);
					nums[1] = Integer.parseInt(file[x][1]);
					
					Arrays.sort(nums);//왱?
				
					if(nums[0] == nums[1]) {
						// 그냥 넘어 갑니다.
					}else if ( Integer.parseInt(file[y][1]) == nums[1] ) {
						
						temp = arrFile[y];
						arrFile[y] = arrFile[x];
						arrFile[x] =temp;
				
					}
					
					
				}else if (file[y][0].equals(ck[1])) {
					
					temp = arrFile[y];
					arrFile[y] = arrFile[x];
					arrFile[x] =temp;
					
				}
				
				change(arrFile);
				
			}// 

		}// 큰 파일의 순서 전환용 

	}// 비교 메소드 

}
