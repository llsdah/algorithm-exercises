package AlgorismStudyUtube;

import java.util.Arrays;

// 피보나치 수열
public class 만들기1 {

	
	public static void main(String[] args) {

		int n =10;
		
		for(int i =1; i<=3;i++) {
			foFunc(n,i,0);
		}
	
	}

	public static int min =999999;
	// 숫자 방법 
	private static void foFunc(int num, int way, int cnt) {
		
		if( way==3 && num%3==0) {
			cnt++;
			num /=way;
			for(int i =1; i<=3;i++) {
				foFunc(num,way,cnt);
			}
			
		}else if(way==2&&num%2==0) {
			cnt++;
			num/=way;
			for(int i =1; i<=3;i++) {
				foFunc(num,way,cnt);
			}
			
		}else if(num>=2){
			cnt++;
			num +=-1;
			for(int i =1; i<=3;i++) {
				foFunc(num,way,cnt);
			}
		}
		
		if(num ==1&& cnt<min) {
			min =cnt;
			return;
		}
		
	}	
	
}
