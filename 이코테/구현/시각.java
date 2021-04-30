
public class 시각 {

	public static void main(String[] args) {
		
		int n=5;
		
		StringBuilder sb = new StringBuilder();
		int count =0;
		for(int i =0;i<=n;i++) {
			for(int m =0; m<60;m++) {
				for(int s=0; s<60;s++) {
					sb.append(i);
					sb.append(m);
					sb.append(s);
					if(sb.toString().contains("3")) {
						count++;
					}
					sb.delete(0, sb.toString().length());
					
				}
				
			}
			
		}
		
		System.out.println(count);
	}
}
