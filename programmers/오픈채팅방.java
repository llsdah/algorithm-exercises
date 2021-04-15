import java.util.*;

class Solution {
	static HashMap<String, String> map = new HashMap<String, String>();

	public static String[] solution(String[] record) {
		String[] answer = new String[record.length];

		// 닉네임 변경법 나갔다 다시 들어오기, 자체 변경( 변경시 기존 채팅방 출력 메시지의 닉네임변경

		String[][] word = new String[record.length][3];

		for (int i = 0; i < word.length; i++) {
			word[i] = record[i].split(" ");
		}

		for (int i = 0; i < word.length; i++) {

			if (word[i][0].equals("Enter")) {
				answer[i] = word[i][2] + "님이 들어왔습니다.";
				answer = change(i,word[i][1], word[i][2], word, answer);
				map.put(word[i][1], word[i][2]);

			} else if (word[i][0].equals("Leave")) {
				answer[i] = map.get(word[i][1]) + "님이 나갔습니다.";

			} else if (word[i][0].equals("Change")) {
				answer = change(i, word[i][1], word[i][2], word, answer);
			}

		}
		String temp = "";

		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == null) {
				continue;
			}
			temp += answer[i] + ",";
		}
		temp = temp.substring(0, temp.length() - 1);
		answer = temp.split(",");

		return answer;
	}

	private static String[] change(int end,String id, String nick, String[][] word, String[] answer) {
		for (int i = 0; i <= end; i++) {

			if (word[i][1].equals(id) && !word[i][0].equals("Change") && map.containsKey(id)) {
				answer[i] = answer[i].replace(map.get(id), nick);
			}


		}
		map.put(id, nick);
	
		return answer;
	}
}
