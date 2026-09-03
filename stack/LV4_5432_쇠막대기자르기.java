package Stack;
import java.io.*;
import java.util.*;

public class LV4_5432_쇠막대기자르기 {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= t; test_case++)
		{
			Stack<Character> stack = new Stack<>();
			
			int ans = 0;
			String str = br.readLine();
			
			for(int i=0 ; i<str.length() ; i++) {
				char c = str.charAt(i);
			
				if(c=='(') {
					stack.push(c);
				} else if(c==')') {
					stack.pop();
					
					// 레이저인지 확인
					if(str.charAt(i-1)=='(') {
						ans += stack.size();
					} else { // 막대의 끝
						ans++;
					}
				}
				
			}
			
			System.out.println("#" + test_case + " " + ans);
				
		}
	}
}