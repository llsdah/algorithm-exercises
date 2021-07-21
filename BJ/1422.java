
		// 너무 단순하게 생각 길이가 긴 부분 생각 못함. 가장 큰수 만들기 생각하면됩니다. 
		// 77 과 9 의 경우 977이 더 큰수
public class Main {
	// 자연수신
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// k 개의 자연수 가지가 n개의 수를 뽑아서 그 수를 붙여서 만들수 있는 가자 ㅇ큰수 
		// 수를 여러변 사용도 가능하지만 뽑은 수는 한번이상 사용
		// k<n
		int k =sc.nextInt();
		int[] nums = new int[k];
		int n =sc.nextInt();
		for(int i=0; i<k;i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);// 숫자대로 정렬 
		StringBuilder sb = new StringBuilder();
		// 작으면 사용 못해 무조건 사용해야댐
		while(n>k) {
			sb.append(nums[k-1]);
			n--;
		}
		
		for(int i=k-1;i>=0;i--) {
			sb.append(nums[i]);
		}
		System.out.println(sb.toString());
	}
}
