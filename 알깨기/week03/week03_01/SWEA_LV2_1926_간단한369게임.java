package week03_01;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1926_간단한369게임 {

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
				
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case);
			
			int num = sc.nextInt();
			
			for(int i=1 ; i<=num ; i++) {
				
				String strNum = String.valueOf(i);
				
				// 3,6,9가 몇 번 들어가는지 카운트
				int count = 0;
				
				for(int j=0 ; j<strNum.length() ; j++) {
					if(strNum.charAt(j) == '3' ||
						strNum.charAt(j) == '6' ||
						strNum.charAt(j) == '9') {
						count++;
					}
				}
				
				// 만약 3,6,9가 나왔다면
				if(count > 0) {
					for(int n=0 ; n<count ; n++) {
						System.out.print("-");
					}
				} else { // 3,6,9 가 안나왔다면 그냥 숫자 출력
					System.out.print(i);
				}
				System.out.print(" ");
			}
		
			
			
		}
	}
}
