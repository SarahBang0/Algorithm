package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.border.SoftBevelBorder;

public class SWEA_LV4_1224_계산기3 {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int nums = sc.nextInt();
			String str = sc.next();
			
			StringBuilder sb = new StringBuilder(); // 후위 표현식 저장
			
			Stack<Character> stack = new Stack<>(); // 연산자 및 괄호 스택
			
			// 1. 후위 표기식 변환
			for(int i=0 ; i<nums ; i++) {
				
				if(Character.isDigit(str.charAt(i))) { // 숫자 만났을 때
					sb.append(str.charAt(i));
					
					
					
				} else if (str.charAt(i) =='(') { // 여는 괄호
					stack.push(str.charAt(i));
					
					
					
				} else if (str.charAt(i) ==')') { // 닫는 괄호
					
					while(stack.peek()!='(' && stack.peek()!='(') { // stack에서 ( 가 나올때까지 pop
						sb.append(stack.pop());
					}
					stack.pop();
					
					
				} else { // 피연산자 나왔을 때
					// 스택 맨 위에 있는 연산자의 우선순위
					
					// tmp가 현재 연산자 우선순위보다 크거나 같으면 pop, 작아지면 stop
					while(!stack.isEmpty() && getPriority(stack.peek())>=getPriority(str.charAt(i))) {
						sb.append(stack.pop());
					}
					
					// 현재 연산자를 스택에 push
					stack.push(str.charAt(i));
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			
			// 2. 후위표기식 계산
			Stack<Integer> operands = new Stack<>(); // 피연산자
			
			int len = sb.length();
			
			for(int i=0 ; i<len ; i++) {
				
				if(Character.isDigit(sb.charAt(i))) {
					operands.push(sb.charAt(i)-'0');
				} else {
					int a = operands.pop();
					int b = operands.pop();
					
					if(sb.charAt(i)=='*') {
						operands.push(b*a);
					} else if(sb.charAt(i)=='+') {
						operands.push(b+a);
					}
				}
			}
			
			
			System.out.println("#" + test_case + " " + operands.pop());
			
			
		}
	}
	
	// 연산자 우선순위 
	public static int getPriority(char op) {
		if(op == '*') return 2;
		if(op == '+') return 1;
		if(op == '(') return 0;
		return -1;
	}
}
// 후위 표현식의 2가지 규칙
// 결과 문자열 & 연산자 스택 
// 1. 여는 괄호 -> 무조건 push
// 2. 피연산자 -> push
// 3. 연산자 (+, *) -> 연산자 스택 peek이 나보다 우선순위가 같거나 높다면 -> 피연산자 2개 팝해서 계산 -> 다시 push -> 낮은 연산자 나올때까지
// 4. 닫는 괄호 -> 여는 괄호가 나올때까지 연산자 꺼내면서 계산