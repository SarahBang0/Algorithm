package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_LV4_사칙연산 {
	
	static Deque<Double> stack = new ArrayDeque<>();
	static int N;
	static String[] arr;
	static int[] left;
	static int[] right;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			sb.append("#").append(test_case);
			
			N = Integer.parseInt(br.readLine());
			arr = new String[N+1];
			left = new int[N+1];
			right = new int[N+1];
			
			// 트리 만들기 
			for(int i=1 ; i<=N ; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				
				int idx = Integer.parseInt(token.nextToken());
				arr[idx] = token.nextToken();
				
				if(token.hasMoreTokens()) { // 자식 노드가 있다면
					left[idx] = Integer.parseInt(token.nextToken());
					right[idx] = Integer.parseInt(token.nextToken());
				}
			}
			
			 checkTree(1);
			 
			 sb.append(" ").append(Math.round(stack.poll())).append("\n");
		}
		System.out.println(sb);
	}
	
	static void checkTree(int current) {
		if(current > N) {
			return;
		}
		
		// 자식 노드가 있는지 확인
		if(left[current] != 0 || right[current] != 0) { // 자식 존재 
			int leftNode = left[current];
			int rightNode = right[current];
			
			checkTree(leftNode);
			checkTree(rightNode);
			
			// 스택에서 2개 꺼내서 계산 후 offer
			char k = arr[current].charAt(0);
			
			double a = stack.pollLast();
			double b = stack.pollLast();
			
			switch (k) {
			case '+':
				stack.offerLast(b+a);
				break;
			case '-':
				stack.offerLast(b-a);
				break;
			case '*':
				stack.offerLast(b*a);
				break;
			case '/':
				stack.offerLast(b/a);
				break;
			}
		} else {
			// 자식 노드가 없다면  -> 숫자
			stack.offerLast(Double.parseDouble(arr[current]));
		}
		
		
	}
}

// char 배열로 만드려고 햇는데, 그러면 두자리 숫자를 넣을 방법을 못찾음 
