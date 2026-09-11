package week03_01;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_2005_파스칼의삼각형 {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case);
			
			int N = sc.nextInt(); // 파스칼의 삼각형 크기 N
			
			// 배열로 만들기
			int[][] arr = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<=i ; j++) {
					
					// 마지막 열은 무조건 1
					if(j==i) {
						arr[i][j] = 1;
					}
					
					// 첫번째 열은 무조건 1
					if(j==0) {
						arr[i][j] = 1;
					}
					
					// i>=2 && j>=1 && j<=N-2는 arr[i-1][j-1]+arr[i-1][j]\
					if(j>=1 && j<=N-2) {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}
					
					
				}
			}
			
			// 출력
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					
					// 안채워진 부분(0)은 pass
					if(arr[i][j] == 0) {
						continue;
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
			
		
		}
	}
}

