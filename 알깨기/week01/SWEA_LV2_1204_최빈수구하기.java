package week01;
import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1204_최빈수구하기 {

		public static void main(String args[]) throws Exception
		{
			System.setIn(new FileInputStream("input.txt"));
			Scanner sc = new Scanner(System.in);
			int T;
			T=sc.nextInt(); // 테스트 케이스 갯수

			for(int test_case = 1; test_case <= T; test_case++)
			{
				int num = sc.nextInt(); // 테스트 케이스 번호
	            
	            int[] scoreCount = new int[101]; // 점수 범위는 0~100점
	            
	            // 1000명 학생 순회하면서 해당 점수 칸의 count++
	            for(int i=1 ; i<=1000 ; i++)	 {
	                scoreCount[sc.nextInt()]++;
	            }
	            
	           
	            int maxScore = Integer.MIN_VALUE;
	            int maxScoreCount = 0;
	            
	            for(int i=0 ; i<101 ; i++) {
	                if(maxScoreCount <=  scoreCount[i]) {
	                	maxScoreCount = scoreCount[i];
	                    maxScore = i;
	            }
			}
	         System.out.println("#" + num + " " + maxScore);
		}
	}
}
