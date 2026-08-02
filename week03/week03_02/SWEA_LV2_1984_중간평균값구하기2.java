package week03_02;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1984_중간평균값구하기2 {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int sum = 0;
			int max = Integer.MIN_VALUE;
			int min= Integer.MAX_VALUE;
			
			for(int i=0 ; i<10 ; i++) {
				int num = sc.nextInt();
				sum += num;
				if(num > max) max = num;
				if(num < min) min = num;
			}
			
			long result = Math.round((sum - max- min)/8.0);
			
			
			System.out.println("#" + test_case + " " + result);
		}
	}

}
