package week03_02;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1946_간단한압축풀기 {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case);
			
			int N = sc.nextInt(); // 알파벳 개수
			
			StringBuffer sb = new StringBuffer();
			
			 // 주어진 숫자만큼 반복
			for(int i=0 ; i<N ; i++) {
				
				String alpabet = sc.next(); // 알파벳 문자
				int num = sc.nextInt(); 
				
				// 알파벳 숫자만큼 반복
				for(int j=0 ; j<num ; j++) {
					sb.append(alpabet);					
				}	
			}
			
			// sb에 전부 넣고 10개씩 끊어서 출력
			for(int n=0 ; n<sb.length() ; n+=10) {
				int endIdx = Math.min(n+10, sb.length());
				System.out.println(sb.substring(n, endIdx));
			}
			
	}
}

}
