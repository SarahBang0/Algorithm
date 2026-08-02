package week03_01;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1970_쉬운거스름돈_1 {


	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 거스름돈 50,000 10,000 5,000 1,000 500 100 50 10
			int[] arr = new int[8];
			
			int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
			// 거슬러 주어야 할 금액
			int money = sc.nextInt(); 
			
			for(int i=0 ; i<8 ; i++) {
				arr[i] = money/units[i];
				money%=units[i];
			}
			
			System.out.println("#" + test_case);
			for(int i=0 ; i<8 ; i++) {
				System.out.print(arr[i] + " ");
			}
			
            System.out.println();

	}
}

}
