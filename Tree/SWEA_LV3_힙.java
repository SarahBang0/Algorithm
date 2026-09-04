package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_LV3_힙 {

	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int n = Integer.parseInt(br.readLine()); // 쿼리 갯수
			
			sb.append("#").append(test_case);
			
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			for(int i=0 ; i<n ; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(token.nextToken());
				
				if(m==1) {
					maxHeap.offer(Integer.parseInt(token.nextToken()));
				} else if(m==2) {
					if(!maxHeap.isEmpty()) {
						sb.append(" ").append(maxHeap.poll());
					} else {
						sb.append(" ").append(-1);
					}
				}
			}
			
			sb.append("\n");
		
		}
		
		System.out.println(sb);
	}
}