package 부분집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV3_10726_이진수표현 {

	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			
			String binary = Integer.toBinaryString(M);
			
			String result = "ON";
			
			if(binary.length() < N) {
				result = "OFF";
			} else {
				for (int i=binary.length()-1 ; i>=binary.length()-N ; i--) {
					if(binary.charAt(i)=='0') {
						result  = "OFF";
						break;
					}
				}
			}
			
			
			System.out.println("#" + test_case + " " + result);
					
		}
	}
}