package week02;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1979_어디에단어가들어갈수있을까 {

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// 퍼즐 크기
			int size = sc.nextInt();
			int[][] puzzle = new int[size][size];
			
			// 글자 길이
			int numSize = sc.nextInt(); 
			
			// 퍼즐 만들기
			for(int i=0 ; i<size ; i++) {
				for(int j=0 ; j<size ; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			int result = 0;
			

			
			// 퍼즐을 순회하면서 1이라면, 글자가 들어가는지 확인
			for(int i=0 ; i<size ; i++) {
				for(int j=0 ; j<size ; j++) {
					
					int count = 0;
					
					// 그 자리가 1이라면? (흰색) 카운트 시작
					if(puzzle[i][j]==1) {
						
						// 가로 방향 시작점
						if(j==0 || puzzle[i][j-1]==0) {
							for(int n=j ; n<j+numSize ; n++) {
								if(n<size && puzzle[i][n] == 1) {
									count++;
									
									if(count == numSize) {
										if(n==size-1 || (n+1 < size && puzzle[i][n+1]==0)) {
											result++;
										}
									}
									
								}
							}
						}
						
						count = 0; // 초기화
						
						// 세로 방향
						if(i==0 || puzzle[i-1][j]==0) {
							for(int n=i ; n<i+numSize ; n++) {
								if(n<size && puzzle[n][j] == 1) {
									count++;
									
									if(count == numSize) {
										if(n==size-1 || (n+1 < size && puzzle[n+1][j]==0)) {
											result++;
										}
									}
									
								}
							}
						}
						
					} else {
						continue;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + result);
			
		
		}
	}
}
