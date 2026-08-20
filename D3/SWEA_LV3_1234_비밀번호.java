package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_LV3_1234_비밀번호 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1 ; tc<=10 ; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(token.nextToken());
			String nums = token.nextToken();
			
			Deque<Character> stack = new ArrayDeque<>();
			
			for(int i=0 ; i<nums.length() ; i++) {
				// peek 해서 같으면 pop, 다르면 push 
				char num = nums.charAt(i);
				
				if(!stack.isEmpty() && num == stack.peekFirst()) {
					stack.pollFirst();
				} else {
					stack.addFirst(num);
				}
			}
			
			String result = "";
			while(!stack.isEmpty()) {
				result += stack.pollLast();
			}
			
			
			System.out.println("#" + tc + " " +  result);
		}
	}

}
