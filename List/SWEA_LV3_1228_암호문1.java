package List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_LV3_1228_암호문1 {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
		{
		
        	List<Integer> arr1 = new ArrayList<>(); // 원본 암호문 담을 리스트
        	
        	int len = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
        	String str1 = br.readLine(); // 원본 암호문
        	
        	StringTokenizer token = new StringTokenizer(str1);
        	
        	// 원본 암호문 채우기
        	for(int i=0 ; i<len ; i++) {
        		arr1.add(Integer.parseInt(token.nextToken()));
        	}
      
        	int count = Integer.parseInt(br.readLine()); // 명령어의 개수
        	String str2 = br.readLine(); // 명령어
        	
        	token = new StringTokenizer(str2);
        	
        	// 명령어 처리
        	for(int i=0 ; i<count ; i++) {
        		
        		token.nextToken(); // 구분자 (I)
        		int idx = Integer.parseInt(token.nextToken()); // 새로운 숫자 추가할 위치
        		int nums = Integer.parseInt(token.nextToken()); // 덧붙일 숫자들 갯수
        		
        		// 그다음 명령문을 삽입
        		for(int j=0 ; j<nums ; j++) {
        			arr1.add(idx++, Integer.parseInt(token.nextToken()));
        		}
        	}
        	
        	StringBuilder sb = new StringBuilder();
        	for(int i=0 ; i<10 ; i++) {
        		sb.append(arr1.get(i));
        		sb.append(" ");
        	}
        	
        	System.out.println("#" + test_case + " "+ sb.toString());
		
		}
	}
}
	


