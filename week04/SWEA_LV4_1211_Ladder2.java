package week04;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV4_1211_Ladder2 {

	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = sc.nextInt(); // 테스트 케이스 번호
			
			int[][] arr = new int[100][100];
			
			// 사다리 배열 생성
			for(int i=0 ; i<100 ; i++) {
				for(int j=0 ; j<100 ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int min = Integer.MAX_VALUE;
			int result = 0; // 출발점 x 좌표
			
			// 0행 순회
			for(int i=0 ; i<100 ; i++) {
				
				if(arr[0][i] == 1) {
					
					// 현재 위치 좌표
					int currRow = 0;
					int currCol = i;
					
					// 이동 횟수 저장
					int count = 0;
				
					// 바닥에 닿을때까지 반복
					while(currRow != 99) {
						
						// 왼쪽이 1이라면 
						if(currCol > 0 && arr[currRow][currCol-1]==1) {
							// 벽에 닿거나, 0에 닿을때까지 왼쪽으로 이동
							while(currCol > 0 && arr[currRow][currCol-1]==1) {
								currCol--;
								count++;
							}
						}
						// 오른쪽이 1이라면
						else if (currCol < 99 && arr[currRow][currCol+1]==1) {
							while(currCol < 99 && arr[currRow][currCol+1]==1) {
								currCol++;
								count++;
							}
						}
						
						// 아래로 이동
						currRow++;
						count++;
					}
					

					if(count < min) {
						min = count;
						result = i;
					}
					
				}
			}
			
			System.out.println("#" + tc + " " + result);
			
		
		}
	}
}