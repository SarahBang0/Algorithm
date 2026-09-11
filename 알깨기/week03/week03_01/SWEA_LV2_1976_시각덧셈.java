package week03_01;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1976_시각덧셈 {

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int firstH = sc.nextInt();
			int firstM = sc.nextInt();
			int secH = sc.nextInt();
			int secM = sc.nextInt();
			
			int hour = (firstH + secH)%12;
			int minute = firstM + secM;
			
			if(firstM + secM >= 60) {
				hour++;
				minute -= 60;
			}
			
					
			System.out.println("#" + test_case + " " + hour + " " + minute);
		}
	}
}