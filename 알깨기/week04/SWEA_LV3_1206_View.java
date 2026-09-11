package week04;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_LV3_1206_View {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
//		T=sc.nextInt(); // 테스트 케이스 갯수


		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt(); // 건물의 갯수
			
			int[] buildings = new int[N];
			
			// 배열에 빌딩 높이 넣기
			for(int i=0;  i<N ; i++) {
				buildings[i] = sc.nextInt();
			}
			
//			System.out.println(Arrays.toString(buildings));
			
			// 조망권이 확보된 세대의 수
			int count = 0;
			
			// 해당 빌딩의 위치-2 & +2까지 본인 보다 같거나 높은 빌딩이 있다면 pass
			// 
			// 양쪽 다 해당 빌딩보다 낮다면 -> 해당 빌딩 - (양쪽 둘 중에 더 높은 빌딩 높이)
			for(int i=2 ; i<N-2 ; i++) {
				
				if(buildings[i] > buildings[i-2] && buildings[i] > buildings[i+2]
						&& buildings[i] > buildings[i-1] && buildings[i] > buildings[i+1]) {
					
					int maxLeft = Math.max(buildings[i-1], buildings[i-2]);
					int maxRight = Math.max(buildings[i+1], buildings[i+2]);
					count += buildings[i] - Math.max(maxRight, maxLeft);
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		
		
		}
	}
}