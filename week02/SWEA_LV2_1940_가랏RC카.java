package week02;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV2_1940_가랏RC카 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt(); // 테스트 케이스 갯수
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int command = sc.nextInt(); // command의 수
			
			int speed = 0;
			int distance = 0;
			
			for(int i=1 ; i<=command ; i++) {
				
				int first = sc.nextInt();
				if(first == 0) { // 현재 속도 유지
					distance += speed;
							
				} else if(first == 1) { // 가속
					int newSpeed = sc.nextInt();
					speed += newSpeed;
					distance += speed;
					
				} else if(first == 2) { // 감속
					int newSpeed = sc.nextInt();
					if(speed < newSpeed) {
						speed = 0;
					} else {
						speed -= newSpeed;
						distance += speed;
					}
				}
					
			}
			System.out.println("#" + test_case + " " + distance);
		}
	}
	
}
