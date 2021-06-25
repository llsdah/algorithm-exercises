
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();
		String[] str_arr = new String[n];
		int[] int_arr = new int[n];

		for (int i = 0; i < n; i++) {
			str_arr[i] = sc.next();
		}

		for (int i = 0; i < n; i++) {
			int_arr[i] = check(str_arr[i]);
		}

		System.out.println(Arrays.toString(int_arr));
	}

	private static int check(String str) {

		if (palin(str))
			return 0;
		else if (mi_palin(str))
			return 1;
		return 2;
	}

	private static boolean mi_palin(String str) {
		
		if(palin(str.substring(1,str.length()))) return true;
		
		for(int i =0; i <str.length();i++) {
			if(i-1<=0) continue;
			String temp = str.substring(0,i-1)+str.substring(i);
			if(palin(temp)) return true;
		}
		if(palin(str.substring(0,str.length()-1))) return true;
		
		return false;
	}

	private static boolean palin(String str) {
		// 홀 수면 참
		boolean flag = str.length() % 2 == 1 ? true : false;
		int idx = str.length() % 2 == 1 ? str.length() - 1 : str.length() / 2 - 1;

		if (flag) {
			for (int i = 0; i < idx; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
			}
		} else {
			for (int i = 0; i <= idx; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
			}
		}

		return true;
	}
}

/*


*/
