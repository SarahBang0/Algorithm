package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_LV3_1289_원재의메모리복구하기 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=tc; test_case++) {
			
			String str = br.readLine();
			int count = 0 ; // 변경한 횟수
			char current = '0';
			
			for(int i=0 ; i<str.length() ; i++) {
				if(current != str.charAt(i)) {
					count++;
					current = str.charAt(i);
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
