import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		// PPAP 만들기 . 그래서 결론 적으로 P가 나오면 됩. 나머지 는 NP
		String str = sc.next();
		String stand = "PPAP";
		
		
		while(str.contains(stand)) {
			StringBuilder sb = new StringBuilder();
			int pos = str.indexOf("PPAP");
			sb.append(str.substring(0, pos));
			sb.append("P");
			sb.append(str.substring(pos+4));
			str = sb.toString();
			System.out.println(sb.toString());
		}
		if(str.equals("P")) System.out.println(stand);
		else System.out.println("NP");
		
		
	}
}
