package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_LV3_1213_String {
	
	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = Integer.parseInt(br.readLine());
			
			String target = br.readLine(); // 찾아야하는 문자열
			String str = br.readLine();
			
			int count = 0;
			int startIdx = 0;
			
			// startIdx 위치부터 target 문자열을 str에서 찾아서 startIdx에 저장
			// 찾지 못한다면 -1을 반환 
			while((startIdx = str.indexOf(target, startIdx))!=-1) {
				count++;
				
				// 그다음은 target 글자의 다음부터 찾아야 하니까 target 글자수 더해주기
				startIdx += target.length();
			}
			
			
			System.out.println("#" + tc + " " + count);
		
		
		}
	}
}