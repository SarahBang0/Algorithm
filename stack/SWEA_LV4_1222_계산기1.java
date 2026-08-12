package Stack;

import java.util.Scanner;

public class SWEA_LV4_1222_계산기1 {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int nums = sc.nextInt();
			String str = sc.next();
            int result = 0;
			
			for(int i=0 ; i<nums ; i++) {
				if(i%2==0) { 
                    result += str.charAt(i) - '0';
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}