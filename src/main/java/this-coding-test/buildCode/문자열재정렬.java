
public class 문자열재정렬 {

	public static void main(String[] args) {

		String pos = "K1KA5CB7";
		
		
		
		// 나의 풀이 
		char[] arr = pos.toCharArray();
		Arrays.sort(arr);
		String num = "";
		String word = "";
		for(int i =0;i<arr.length;i++) {
			
			if(arr[i]>='0'&&arr[i]<='9') {
				num+= arr[i];
			}else {
				word+=arr[i];
			}
			
		}
		int sum = 0;
		
		for(int i=0; i<num.length();i++) {	
			sum+=(num.charAt(i)-'0');
		}
		String answer = word+sum;
		System.out.println(answer);
	}
}
