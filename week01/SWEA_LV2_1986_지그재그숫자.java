package week01;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1986_지그재그숫자
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int sum = 0;
		 	int num = sc.nextInt(); // 숫자 받아오기
		 	
            for(int i=1 ; i<=num ; i++) {
                if(i%2!=0) {
                    sum += i;
                } else {
                    sum -= i;
                }
            }
            
            System.out.println("#" + test_case + " " + sum);
		}
	}
}