package Stack;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_LV4_1218_괄호짝짓기 {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);


		for(int test_case = 1; test_case <= 10; test_case++)
		{
			Stack<Character> stack = new Stack<>();
			
			char[] left = {'{', '[', '(', '<'};
			char[] right = {'}', ']', ')', '>'};
			
			int nums = sc.nextInt();
			String str = sc.next();
			
			int result = 1;
			
			for(int i=0 ; i<nums ; i++) {
				
				char n = str.charAt(i);
				
				// 여는 괄호는 push
				if(n == '{' || n == '[' || n == '(' ||n == '<') {
					stack.push(n);
				}
				
				// 닫는 괄호라면?
				if(n == '}' || n == ']' || n == ')' ||n == '>') {
					
					// 스택이 비어있으면 X
					if(stack.isEmpty()) {
						result = 0;
						break;
					}
					
					// peek 했을 때 같으면 pop
					if((n=='}' && stack.peek()=='{') ||
							(n==']' && stack.peek()=='[') ||
							(n==')' && stack.peek()=='(') ||
							(n=='>' && stack.peek()=='<')) {
						stack.pop();
					} else {
						result = 0;
						break;
					}
				}
				
			}
			
			if(!stack.isEmpty()) result = 0;
			
			System.out.println("#" + test_case + " " + result);
		
		}
	}
}

// 여는 괄호 -> push 
// 닫는 괄호 -> 스택이 비어있으면 X / 스택 peek했을 때 짝 맞지 않으면 X / 짝 맞으면 pop 
// 마지막에 stack.empty 해서 비어있으면 O