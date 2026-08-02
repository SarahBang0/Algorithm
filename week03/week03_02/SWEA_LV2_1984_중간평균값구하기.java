package week03_02;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1984_중간평균값구하기 {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int[] arr = new int[10];
			for(int i=0 ; i<10 ; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			double sum = 0;
			for(int i=1 ; i<=8 ; i++) {
				sum += arr[i];
			}
         	int result = (int) Math.round(sum / 8.0);
			
			System.out.println("#" + test_case + " " + result);
		}
	}

}
