package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_수영장2 {
	
	static int d, m1, m3, y;
	static int[] months = new int[13];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			sb.append("#").append(tc);
			
			token = new StringTokenizer(br.readLine());
			d = Integer.parseInt(token.nextToken());
			m1 = Integer.parseInt(token.nextToken());
			m3 = Integer.parseInt(token.nextToken());
			y = Integer.parseInt(token.nextToken());
			
			token = new StringTokenizer(br.readLine());
			for(int i=1 ; i<13 ; i++) {
				months[i] = Integer.parseInt(token.nextToken());
			}
			
			dfs(1, 0); // 1월부터 시작, 총 가격
			sb.append(" ").append(min).append("\n");
			min = Integer.MAX_VALUE;
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int sum) {
		if(sum > min) return;
		
		if(idx>12) { // 종료조건
			min = Math.min(min, sum);
			return;
		}
		
		dfs(idx+1, sum + d*months[idx]); // 1일권
		dfs(idx+1, sum + m1); // 1달권
		dfs(idx+3, sum + m3); // 3달권
	}
}