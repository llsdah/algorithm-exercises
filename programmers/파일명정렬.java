package studyProgrammers;

import java.util.Arrays;
import java.util.Comparator;

public class A_Test {

	public static void main(String[] args) {

		// int m = 4;
		// int n = 5;
		// String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		int m = 2;

//		String[] s = { "img12.png", "img10.png", "img2.png", "img1.png" };
//		String[] s = { "img202.png123", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
//		String[] s = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] s = { "img000012345", "img1.png", "img2", "IMG02" };
		String[] result = solution(s);

		// long[] result = solution4(n,z,roads,queries);

		System.out.println("result : " + result);
		System.out.println("result : " + Arrays.toString(result));
		// System.out.println("result : "+ Arrays.deepToString(result));

	}

	public static String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] file1 = detach(o1);
				String[] file2 = detach(o2);

				int headValue = file1[0].compareTo(file2[0]);

				if (headValue == 0) {
					int num1 = Integer.parseInt(file1[1]);
					int num2 = Integer.parseInt(file2[1]);
					return num1 - num2;
				} else {
					return headValue;
				}
			}

			private String[] detach(String str) {
				String head = "";
				String number = "";
				String tail = "";

				int index = 0;

				for (; index < str.length();index++) {
					char ch = str.charAt(index);
					if (ch >= '0' && ch <= '9')
						break;
					head += ch;
				}
				for (; index < str.length();index++) {
					char ch = str.charAt(index);
					if (!(ch >= '0' && ch <= '9'))
						break;
					number += ch;
				}
				for (; index < str.length();index++) {
					char ch = str.charAt(index);
					tail += ch;
				}

				String[] file = { head.toLowerCase(), number, tail };

				return file;
			}

		});

		return files;
	}

}
