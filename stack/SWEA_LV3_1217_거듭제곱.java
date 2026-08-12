package Stack;

import java.util.Scanner;

public class SWEA_LV3_1217_거듭제곱 {

	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = sc.nextInt();
			
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			int result = 1;
			for(int i=0 ; i<num2 ; i++) {
				result *= num1;
			}
			
			System.out.println("#" + tc + " " + result);
		
	
		}
	}
	
	public class ArrayStack {
		int top; // 인덱스
		int size; // 스택 배열의 크기
		int[] stack;
		
		public ArrayStack(int size) {
			this.size = size;
			stack = new int[size];
			top = -1;
		}
		
		public void push(int item) {
			stack[++top] = item;
		}
		
		public int pop() {
			int pop = stack[top];
			stack[top--] = 0;
			return pop;
		}
		
		public int peek() {
			return stack[top];
		}
		
	}
}


