	static int[] start;
	static int[] end;

	// 2016-09-15 hh:mm:ss.sss 셋째 짜리 까찌 ㅛㅣ
	public static int solution(String[] lines) {
		int answer = 0;

		start = new int[lines.length];
		end = new int[lines.length];
		changeTime(lines);

		for (int i = 0; i < lines.length; i++) {
			int ckStart = start[i];
			int ckEnd = start[i]+1000;
			int cnt = 0;

			for (int k = 0; k < lines.length; k++) {

				if (start[k] >= ckStart && start[k] < ckEnd) {
					cnt++;
				} else if (start[k] <= ckStart && end[k] >= ckEnd) {
					cnt++;
				} else if (end[k] >= ckStart && end[k] < ckEnd) {
					cnt++;
				} 

			}// 안의 for
			answer = answer <cnt ? cnt : answer;

		}

		for (int i = 0; i < lines.length; i++) {
			int ckStart = end[i];
			int ckEnd = end[i]+1000;
			int cnt = 0;

			for (int k = 0; k < lines.length; k++) {

				if (start[k] >= ckStart && start[k] < ckEnd) {
					cnt++;
				} else if (start[k] <= ckStart && end[k] >= ckEnd) {
					cnt++;
				} else if (end[k] >= ckStart && end[k] < ckEnd) {
					cnt++;
				} 

			}// 안의 for
			answer = answer <cnt ? cnt : answer;

		}
		
		
		return answer;
	}

	private static void changeTime(String[] lines) {

		for (int i = 0; i < lines.length; i++) {
			String[] day = lines[i].split(" ");
			String[] time = day[1].split(":");
			int ms = Integer.parseInt(time[0]) * 60 * 60 * 1000 + Integer.parseInt(time[1]) * 60 * 1000
					+ (int) (Double.parseDouble(time[2]) * 1000);
			end[i] = ms;
			int startMs = (int) (Double.parseDouble(day[2].substring(0, day[2].length() - 1)) * 1000);
			start[i] = ms - startMs + 1;

		}

	}
