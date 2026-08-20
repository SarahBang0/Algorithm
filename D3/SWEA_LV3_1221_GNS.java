package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_LV3_1221_GNS {
	
	static List<String> arr = new ArrayList<>(Arrays.asList("ZRO", "ONE", "TWO", "THR" , "FOR",
			"FIV", "SIX", "SVN", "EGT", "NIN"));
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		StringTokenizer token;
		
		for(int test_case=1 ; test_case<=tc ; test_case++) {
			
			StringBuilder sb = new StringBuilder();
			
			int[] counts = new int[10];
			
			token = new StringTokenizer(br.readLine());
			
			System.out.println(token.nextToken());
			
			int n = Integer.parseInt(token.nextToken());
			token = new StringTokenizer(br.readLine());
			
			for(int i=0 ; i<n ; i++) {
				counts[arr.indexOf(token.nextToken())]++;
			}
			
			for(int i=0 ; i<counts.length ; i++) {
				
				for(int j=0 ; j<counts[i] ; j++) {
					sb.append(arr.get(i));
				}
			}
			
			System.out.println(sb.toString());
		}
		
	}

}
