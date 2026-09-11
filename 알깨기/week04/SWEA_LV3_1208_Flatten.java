package week04;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV3_1208_Flatten {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);

	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = sc.nextInt();
			
			int[] boxes = new int[100];
			for(int i=0 ; i<100 ; i++) {
				boxes[i] = sc.nextInt();
			}
			
			int count = 0;
			
			while(count++ < dump) {
				
				// 매 덤프마다 최소/최대 초기화
				int max = Integer.MIN_VALUE;
				int maxIdx = 0;
				int min = Integer.MAX_VALUE;
				int minIdx = 0;
							
				// 최대 최소 상자 구하기
				for(int i=0 ; i<100 ; i++) {
					if(boxes[i] >= max) {
						max = boxes[i];
						maxIdx = i;
					}
					if(boxes[i] <= min) {
						min = boxes[i];
						minIdx = i;
					}
				}
				
				// 최고와 최고 차이가 없는 경우는 끝. 
				if(max - min <= 1) {
					break;
				}
				
				// 덤프 수행
				// 가장 많은 부분은 하나 줄이고 
				boxes[maxIdx]--;
				
				// 가장 적은 부분은 하나 늘리고
				boxes[minIdx]++;				
			}
			
			int finalMax = Integer.MIN_VALUE;
			int finalMin = Integer.MAX_VALUE;
			for(int i=0 ; i<100 ; i++) {
				if(finalMax < boxes[i]) finalMax = boxes[i];
				if(finalMin > boxes[i]) finalMin = boxes[i];
			}
			
			int result = finalMax - finalMin;
			
			System.out.println("#" + test_case + " " + result);
			
		}
	}
	

}