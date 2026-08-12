package Stack;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_LV4_1223_계산기2 {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int nums = sc.nextInt();
			
			String str = sc.next();
			
			Stack<Integer> operands = new Stack<>(); // 피연산자를 담는 스택
			
			// 일단 stack에 숫자 다 넣기 -> 곱셈은 곱셈 처리 해서
			for(int i=0 ; i<nums ; i++) {
				
				if(i%2==0) { // 피연산자
				
					// 피연산자는 무조건 push
					operands.push(str.charAt(i)-'0');
					
				} else if(str.charAt(i)=='*') { // 곱하기 나오면??
					
					 // 그 전 숫자랑 다음 숫자 곱하기 -> 다시 스택에 push
					operands.push(operands.pop()*(str.charAt(i+1)-'0'));
					// 다음 숫자 곱하고 나면 하나 건너 뛰어야 됨
					i++;
				}
			}
			
			int result = 0;
			
			// 스택에 있는 숫자들 모두 더하기
			while(!operands.isEmpty()) {
				result += operands.pop();
			}
			 
			
			System.out.println("#" + test_case + " " + result);
			
			
		}
	}
}
// 후위 표현식의 2가지 규칙
// 1. 피연산자를 만나면 -> 무조건 스택에 푸시
// 2. 연산자를 만나면 -> 연산자 스택 peek해서 우선순위 비교 -> 스택에서 숫자 2개 팝해서 계산하고 다시 스택에 푸시