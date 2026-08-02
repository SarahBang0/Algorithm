package week03_01;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1974_스도쿠검증1 {
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// 스도쿠 배열 생성
			int[][] sudoku = new int[9][9];
			
			for(int i=0 ; i<9 ; i++) {
				for(int j=0 ; j<9 ; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			int result = 1; 
			
			for(int i=0 ; i<9 ; i++) {
				
				int[] rowCheck = new int[10];
				int[] colCheck = new int[10];
				
				// 가로 세로 배열 검증
				for(int j=0 ; j<9 ; j++) {
					
					rowCheck[sudoku[i][j]]++;
					colCheck[sudoku[j][i]]++;
				}
				
				// 체크 배열 검증
				for(int n=1 ; n<10 ; n++) {
					if(rowCheck[n] != 1 || colCheck[n] != 1) {
						result = 0;
						break;
					}
				}
				
				if(result == 0) break;
			}
			
			// 3x3 배열 검증
			if(result == 1) {
				
				for(int i=0 ; i<9 ; i+=3) {
					for(int j=0 ; j<9 ; j+=3) {
						
						int[] check = new int[10];
						
						for(int n=i; n<i+3 ; n++) {
							for(int m=j; m<j+3 ; m++) {
								check[sudoku[n][m]]++;
							}
						}
						
						for(int n=1 ; n<10 ; n++) {
							if(check[n] != 1) {
								result = 0;
								break;
							}
						}
						if(result == 0 ) break;
					}
					if(result == 0) break;
				}
				
			}
			
			System.out.println("#" + test_case + " " + result);
		
		}
	}
}

