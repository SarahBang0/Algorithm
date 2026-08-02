package week03_02;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_21425 {

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int x = sc.nextInt();
			int y = sc.nextInt();
			int N = sc.nextInt();
			
			
			// 값 복사
			int a = x; 
			int b = y;
			
			int count = 0;
			
			while(a <= N && b <= N) {
				
				if(a <= b) {
					a += b;
				} else {
					b += a;
				}
				
				
				count++;
			}
			
			System.out.println(count);
			
		}
	}
}

// 값이 커지는 법 : 작은 값에 큰 값을 더하기 (그리디 Greedy)