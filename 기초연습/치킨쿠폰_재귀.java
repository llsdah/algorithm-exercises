package AlgorismStudyUtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 치킨쿠폰_재귀 {
	public static void main(String[] args) {

// 치킨 구폰 4 , 치킨 도장 3개당 1개		
		
		
		int coupon = 10;
		int change =3;
		
		
		doFunc(coupon , 0, change,0);
		
	}

	private static void doFunc(int coupon, int stemp, int i, int ans) {
		
		if( coupon>0) {
			coupon--;
			stemp++;
			ans++;
			doFunc(coupon,stemp,i,ans);
			return;
		}else if( stemp>0) {
			if(stemp/i>0) {
				stemp-=i;
				coupon++;
				doFunc(coupon,stemp,i,ans);
			}
			
		}
		
		if(coupon==0&&stemp/i==0) {
			System.out.println("총 갯수 "+ans);
		}
		
	}
}
