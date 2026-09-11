package week03_01;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1974_스도쿠검증2 {
	
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
				for(int j=0; j<9 ; j++) {
					
					
					// 각 9칸 검증
					if(i%3==0 && j%3==0) {
						
						//숫자가 나왔다면 해당 숫자 인덱스는 1로 바꾸기
						int[] check = new int[10];
						
						for(int n=i ; n<i+3 ; n++) {
							for(int m=j ; m<j+3 ; m++) {
								check[sudoku[n][m]] = 1;
							}
						}
						
						// check 배열 순회해서 0이 존재하거나 2이상이 존재하면
						// return 0;
						for(int k=1 ; k<10 ; k++) {
							if(check[k] != 1) {
								result = 0;
								break;
							}
						}						
					}
					
					//숫자가 나왔다면 해당 숫자 인덱스는 1로 바꾸기
					int[] check = new int[10];
					
					// 가로 줄 검증
					for(int n=0 ; n<9 ; n++) {
						check[sudoku[i][n]] = 1;
					}
					
					// check 배열 순회해서 0이 존재하거나 2이상이 존재하면
					// return 0;
					for(int k=1 ; k<10 ; k++) {
						if(check[k] != 0) {
							result = 0;
							break;
						}
					}	
					
					check = new int[10];
					
					// 세로 줄 검증
					for(int n=0 ; n<9 ; n++) {
						check[sudoku[n][j]] = 1;
					}
					
					// check 배열 순회해서 0이 존재하거나 2이상이 존재하면
					// return 0;
					for(int k=1 ; k<10 ; k++) {
						if(check[k] != 1) {
							result = 0;
							break;
						}
					}	
					
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		
		}
	}
}

