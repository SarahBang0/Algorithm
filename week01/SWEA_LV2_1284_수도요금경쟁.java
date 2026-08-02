package week01;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1284_수도요금경쟁 {

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt(); //테스트 케이스 갯수
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = sc.nextInt(); //A사 - 1리터당 가격
			int defaultB = sc.nextInt(); //B사 - 기본요금
			int limitB = sc.nextInt(); //B사 - 월간 사용량 R리터 이하면 기본 요금
			int extraB = sc.nextInt(); //B사 - 초과량에 대해 1리터당 요금
			int usage = sc.nextInt(); // 사용량
			
			int priceA = usage * a;
			int priceB = (usage > limitB ? defaultB + (usage-limitB)*extraB : defaultB);
			
			int min = Math.min(priceA, priceB);
			System.out.println(min);
			
		}
	}
}

// A사 : 1리터당 P원 
// B사 : 기본 요금 Q원, 월간 사용량이 R리터 이하라면 기본 요금만, 초과하면 초과량에 대해 1리터랑 S원
// 한달 간 사용하는 수도의 양 W
// P, Q, R, S, W