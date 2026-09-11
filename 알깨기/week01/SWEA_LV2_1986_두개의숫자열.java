package week01;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1986_두개의숫자열 {


	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{

            int n = sc.nextInt(); // 첫 번째 배열 갯수
            int m = sc.nextInt(); // 두 번째 배열 갯수

            int[] arrA = new int[n]; // 첫번째 배열 
            int[] arrB = new int[m]; // 두번째 배열

            for(int i=0 ; i<n ; i++) {
            arrA[i] = sc.nextInt();
            }
            for(int i=0 ; i<m ; i++) {
            arrB[i] = sc.nextInt();
            }

            int max = 0;

            if(n<m) { // m이 더 클 때

                for(int i=0 ; i<m-n+1; i++) {
                    int sum = 0;
                    for(int j=0 ; j<n ; j++) {
                        sum += arrA[j] * arrB[i+j];
                    }
                    max = Math.max(sum, max);
                }

            } else { // n이 더 클 때

                 for(int i=0 ; i<n-m+1 ; i++) {
                    int sum = 0;
                    for(int j=0 ; j<m ; j++) {
                         sum += arrB[j] * arrA[j+i];
                    }
                    max = Math.max(sum, max);
                }
            }

            
            System.out.println("#" + test_case + " " + max);
			
		}
	}
}
