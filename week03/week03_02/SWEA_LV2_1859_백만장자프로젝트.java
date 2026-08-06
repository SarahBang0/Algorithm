package week03_02;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1859_백만장자프로젝트 {

	 public static void main(String args[]) throws Exception
	    {
	         
	        Scanner sc = new Scanner(System.in);
	        int T;
	        T=sc.nextInt();
	         
	        for(int test_case = 1; test_case <= T; test_case++)
	        {
	            int days = sc.nextInt();
	            int[] prices = new int[days];
	            for(int i=0 ; i<days ; i++) {
	                prices[i] = sc.nextInt();
	            }
	             
	            long margin = 0;
	            int maxPrice = 0;
	             
	            // 뒤에서부터 순회
	            for(int i=days-1 ; i>=0 ; i--) {
	                if(prices[i]>maxPrice) {
	                    maxPrice = prices[i];
	                } else {
	                    margin += maxPrice - prices[i];
	                }
	            }
	 
	            System.out.println("#" + test_case + " "+margin);
	        }
	    }
}
