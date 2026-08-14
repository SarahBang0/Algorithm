package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_LV3_1225_암호생성기 {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int tc = sc.nextInt();
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0 ; i<8 ; i++) {
				int num = sc.nextInt();
				queue.add(num);
			}
			
			int count = 1;
			
			// 0 이하가 되는 순간 탈출 시키기
			while(true) {
				
				// 맨 앞 숫자 제거해서 가져오기
				int first = queue.poll();
				
				// 맨 앞 숫자에서 count를 뺀 값 
				int next = first-count;
				
				// 그 다음 숫자가 0보다 크다면 -> 뒤에 추가 
				if(next > 0) {
					queue.offer(next);
				} else { // 0 이하라면? 0 넣어주고 while 문 탈출
					queue.offer(0);
					break;
				}

				// count가 5이상이면 count 초기화
				if(count++ == 5) count = 1;
			}
		
			System.out.print("#" + tc + " ");
			for(int i=0 ; i<8 ; i++) {
				System.out.print(queue.remove() + " ");
			}
			System.out.println();
		}
	}
}