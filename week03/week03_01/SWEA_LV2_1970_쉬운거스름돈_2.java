package week03_01;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1970_쉬운거스름돈_2 {


	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 거스름돈 50,000 10,000 5,000 1,000 500 100 50 10
			int[] arr = new int[8];
		
			// 거슬러 주어야 할 금액
			int money = sc.nextInt(); 
			
			while(money >= 10) {
				
				if(money / 50000 > 0) {
					arr[0]++;
					money-=50000;
				} else if(money / 10000 > 0) {
					arr[1]++;
					money-=10000;
				} else if(money / 5000 > 0) {
					arr[2]++;
					money-=5000;
				} else if(money / 1000 > 0) {
					arr[3]++;
					money-=1000;
				} else if(money / 500 > 0) {
					arr[4]++;
					money-=500;
				} else if(money / 100 > 0) {
					arr[5]++;
					money-=100;
				} else if(money / 50 > 0) {
					arr[6]++;
					money-=50;
				} else if(money / 10 > 0) {
					arr[7]++;
					money-=10;
				}
			}
			
			System.out.println("#" + test_case);
			for(int i=0 ; i<8 ; i++) {
				System.out.print(arr[i] + " ");
			}
            System.out.println();
	}
}

}
