package week01;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1288_새로운불면증치료법 {

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt(); // 테스트 케이스 갯수

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int originalN = sc.nextInt();
			int multipleN = originalN;
			
			// 몇 번 셋는지?
			int count = 0;
			
			// while 제어용 
			boolean result = true;
			
			boolean[] nums = new boolean[10];
			
			while(result) {
				
				originalN = multipleN * count++;
				
				int tempN = originalN;
				
				// 각 자리의 숫자 위치를 true로 바꿈
				while(tempN>0) {
					nums[tempN%10] = true;
					tempN /= 10;
				}
				
				int countTrue = 0;
				//배열 순회하면서 true가 몇개인지? 10개라면 result를 false로 바꿔서 while문 탈출;
				for(int i=0 ; i<nums.length ; i++) {
					if(nums[i]) {
						countTrue++;
					}
					if(countTrue == 10) result = false;
				}
				
			}
			
			System.out.println("#" + test_case+ " " + originalN);
			
		}
	}
	
	
}
