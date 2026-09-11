package week04;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV3_1210_Ladder1 {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			int currRow = 0;
			int currCol = 0;
			
			for(int i=0; i<100 ; i++) {
				for(int j=0 ; j<100 ; j++) {
					arr[i][j] = sc.nextInt();
					
					// 도착 지점 찾기 (도착 시점에서 반대로 출발할거니까 좌표 저장)
					if(arr[i][j] == 2) {
						currRow = i;
						currCol = j;
					}
				}
			}
			
			// 도착 지점 X에서 출발
			// currRow가 0이 될때까지
			while(currRow > 0) { 
								
				// 왼쪽에 1이 있다면 -> 0에 닿거나 배열 끝에 닿을 때까지
				if(currCol > 0 && arr[currRow][currCol-1] == 1) {
					
					// 인덱스 범위를 먼저 확인하고, 그 다음 배열 값 확인!!!!!
					while(currCol > 0 && arr[currRow][currCol-1] != 0) {
						currCol--; // currCol 감소
					}
					
				// 오른쪽에 1이 있다면 -> 0에 닿거나 배열 끝에 닿을 때까지
				} else if(currCol < 99 && arr[currRow][currCol+1] == 1) {
					
					while(currCol < 99 && arr[currRow][currCol+1] != 0) {
						currCol++; // currCol 증가
					}
				}
				
				currRow--;
				
				// 벽까지 움직이고 한 칸 위로 올라가기 
				// 올라가지 않으면 다음 확인 시에 다시 왔던 길로 갈 수도 있음
				
				
			}
			
			System.out.println("#" + tc + " " + currCol);	
			
		}
		sc.close();
	}
}

// 100x100 크기의 2차원 배열 사다리
// 지정된 도착점 (2)에 대응되는 출발점 X 반환
// 사다리는 1로 표현