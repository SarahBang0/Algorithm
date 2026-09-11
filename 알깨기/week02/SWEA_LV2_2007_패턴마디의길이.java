package week02;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

public class SWEA_LV2_2007_패턴마디의길이 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String text = sc.next();
			int count = 0; 

			for(int i=1 ; i<=10 ; i++) {
				String tmp = text.substring(0, i);
				String tmp2 = text.substring(i, i+i);
				if(tmp.equals(tmp2)) {
					count = i;
					break;
				}
			}
			System.out.println("#" + test_case + " " + count);
			// 문자열 길이 30, 마디의 최대 길이 10
			
		}
		
	}
}
