package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class LV3_8931_제로 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Deque<Integer> stack;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int k =Integer.parseInt(br.readLine()); // 테스트케이스 갯수
			
			stack = new ArrayDeque<>();
			
			for(int i=0 ; i<k ; i++) {
				int n = Integer.parseInt(br.readLine());
				if(n==0) {
					stack.pollLast();
				} else {
					stack.offerLast(n);
				}
			}
			
			int sum = 0;
			while(!stack.isEmpty()) {
				sum += stack.pollFirst();
			}
			
			System.out.println("#" + test_case+ " " + sum);

		}
	}
}