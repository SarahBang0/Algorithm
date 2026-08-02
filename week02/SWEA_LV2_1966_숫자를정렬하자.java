package week02;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1966_숫자를정렬하자 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt(); // 숫자가 몇개인지?
			
			int[] nums = new int[num];
			
			for(int i=0 ; i<num ; i++) {
				nums[i] = sc.nextInt();
			}
			
			Arrays.sort(nums);
			
			System.out.print("#"+test_case+" ");
			for(int i=0 ; i<num ; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
		
		}
	}
}
