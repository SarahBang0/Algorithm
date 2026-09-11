package week04;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV3_1209_Sum {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		


		for(int test_case=1 ; test_case<=10 ; test_case++) {
			
			int num = sc.nextInt();
			
			// 배열 생성
			int[][] arr = new int[100][100];
			for(int i=0 ; i<100 ; i++) {
				for(int j=0 ; j<100 ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			// 대각선 합
			int diagonalSum = 0;
			int diagonalSumRvs = 0;
			
			for(int i=0 ; i<100 ; i++) {
				
				int colSum = 0;
				int rowSum = 0;
				
				for(int j=0 ; j<100 ; j++) {
					colSum += arr[j][i];
					rowSum += arr[i][j];
				}
				
				// 해당 행과 열 중 최댓값 구하기
				int maxSum = Math.max(colSum, rowSum);
				
				// 최댓값 저장 (행과 열 중 최댓값 vs 기존 최댓값)
				max = Math.max(maxSum, max);
				
				// 대각선 구하기
				diagonalSum += arr[i][i];
				diagonalSumRvs += arr[i][99-i];
				
			}
			
			// 대각선 두개 중에서 최댓값 구하기
			int maxDiagonal = Math.max(diagonalSum, diagonalSumRvs);
			
			// 최댓값 저장 (대각선 최댓값 vs 기존 최댓값)
			max = Math.max(maxDiagonal, max);
			
			System.out.println("#" + num + " " + max);
		
			}
		
		}
}