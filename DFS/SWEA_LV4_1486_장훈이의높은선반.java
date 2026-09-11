package 알깨기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의높은선반 {
	
	static int N; // 점원의 수
	static int[] heights; // 점원들의 키
	static int B; // 선반의 높이
	static int min = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case);
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			B = Integer.parseInt(token.nextToken());
			
			token = new StringTokenizer(br.readLine());
			heights = new int[N];
			for(int i=0 ; i<N ; i++) {
				heights[i] = Integer.parseInt(token.nextToken());
			}
			
			dfs(0, 0); // 첫번째 사람부터, 키의 합 
			sb.append(" ").append(min).append("\n");
			min = Integer.MAX_VALUE;
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int sum) {
		if(idx == N) {
			min = Math.min(min, sum);
			return;
		}
		if(sum >= B) { // 선반 높이보다 높아지면 계산 
			int diff = sum - B;
			min = Math.min(min, diff);
		}
		
		// 해당 사람을 포함했을 때
		dfs(idx+1, sum + heights[idx]);
		// 포함 안했을 때
		dfs(idx+1, sum);
	}
}

//탑의 높이 : 점원이 한명이면 그 점원의 키
// 점원이 2명 이상이면 탑을 만든 모든 점원의 키의 합
// 