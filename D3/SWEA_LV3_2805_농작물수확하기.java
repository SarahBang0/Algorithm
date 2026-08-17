package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_LV3_2805_농작물수확하기 {

	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int size = Integer.parseInt(br.readLine());
			
			//  농작물 배열 만들기
			int[][] arr = new int[size][size];
			
			for(int i=0 ; i<size; i++) {
				String nums = br.readLine();
				for(int j=0 ; j<size; j++) {
					arr[i][j] = nums.charAt(j)-'0';
				}
			}
			
			int center = size / 2;
			int sum = 0;
			
			// 0행부터 size-1 행까지 아래로 탐색
			for(int i=0 ; i<size ; i++) {
				
				// 현재 행이 중심으로부터 얼마나 떨어져 있는지 확인
				int dist = Math.abs(center-i);
				int startCol = dist;
				int endCol = size-1-dist;
				
				for(int j=startCol ; j<=endCol ; j++) {
					sum += arr[i][j];
				}
				
			}
			
			System.out.println("#" + test_case + " " + sum);
			
		}
	}
}

// 중심점 (size/2) 기준으로 가로 + 세로는 size 만큼
// 중간 지점