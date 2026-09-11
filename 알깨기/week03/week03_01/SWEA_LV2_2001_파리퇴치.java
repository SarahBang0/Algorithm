package week03_01;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_2001_파리퇴치 {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int arrSize = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] arr = new int[arrSize][arrSize];
			
			for(int i=0 ; i<arrSize ; i++) {
				for(int j=0 ; j<arrSize ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			// 시작 기준은 맨 위 (0,0)
			// 배열 순회 인덱스는 배열의 전체 사이즈 - 파리채 크기 +1
			for(int i=0 ; i<=arrSize-m ; i++) {
				
				for(int j=0 ; j<=arrSize-m ; j++) {
					
					int sum = 0;
					
					// 파리채 
					for(int n=i ; n<i+m ; n++) {
						for(int k=j ; k<j+m ; k++) {
							sum += arr[n][k];
						}
					}
					
					max = Math.max(max, sum);
				}
				
				
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}

