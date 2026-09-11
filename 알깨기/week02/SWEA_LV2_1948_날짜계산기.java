package week02;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1948_날짜계산기 {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int monthA = sc.nextInt();
			int dayA = sc.nextInt();
			int monthB = sc.nextInt();
			int dayB = sc.nextInt();
			
			//A 날짜 총일 수
			int a = dayA;
			//B 날짜 총일 수
			int b = dayB;
			
			int[] months = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			
			for(int i=(monthA-2)%12 ; i>=0 ; i--) {
				a += months[i];
			}
			for(int i=(monthB-2)%12 ; i>=0 ; i--) {
				b += months[i];
			}
			
			int result = b-a+1;
			
			System.out.println("#"+test_case+" "+result);
					
			
		}
	}
}
