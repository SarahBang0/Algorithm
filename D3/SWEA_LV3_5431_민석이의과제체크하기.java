package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class SWEA_LV3_5431_민석이의과제체크하기 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer token;
		
		for(int tc=1 ; tc<=t ; tc++) {
			
			token = new StringTokenizer(br.readLine());
			
			int student = Integer.parseInt(token.nextToken()); // 수강생의 수
			int submit = Integer.parseInt(token.nextToken()); // 과제를 제출한 사람의 수
			
//			// [1,2,3, ... ]
//			int[] nums = IntStream.rangeClosed(1, student).toArray();
			
			boolean[] nums = new boolean[student];
			
			token = new StringTokenizer(br.readLine());
			
			for(int m=0 ; m<submit ; m++) {
				int studentNum = Integer.parseInt(token.nextToken());
				nums[studentNum-1] = true;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int m=0 ; m<nums.length ; m++) {
				if(!nums[m]) sb.append(m+1).append(" ");
				// 체이닝 방식이 더 깔끔
			}
			
			System.out.println("#" + tc + " " + sb.toString().trim());
		}
	}

}

// 첫번째 TC : 수강생의 수를 나타내는 정수 & 과제를 제출한 사람의 수 
// 두번째 TC : 과제를 제출한 사람의 번호가 나열