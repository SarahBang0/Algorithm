package week03_02;

import java.util.Scanner;

public class SWEA_LV2_1204_최빈수구하기 {

	
	public static void main(String args[]) throws Exception
	{		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int tc = sc.nextInt();
			
			// 점수대 배열 
			int[] scores = new int[1001];
			for(int i=1 ; i<1001 ; i++) {
				scores[sc.nextInt()]++;
			}
			
			int max = 0;
			int result = 0;
			
			for(int i=1 ; i<1001 ; i++) {
				if(scores[i] >= max) {
					max = scores[i];
					result = i;
				}
			}
			
		System.out.println("#"+ tc + " " + result);
		}
	}
}

