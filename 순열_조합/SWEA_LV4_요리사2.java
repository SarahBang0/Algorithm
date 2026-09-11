package 순열_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV4_요리사2 {
	
	static int N;
	static int[][] arr;
	static boolean[] visited;
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
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N];
			
			for(int i=0 ; i<N ; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0 ; j<N ; j++) {
					arr[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			
			dfs(0, 0);
			sb.append(" ").append(min).append("\n");
			min = Integer.MAX_VALUE;
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int count) {
		if(count == N/2) {
			calculate();
			return;
		}
		
		if(idx == N) return;
		
		visited[idx] = true;
		dfs(idx+1, count+1);
		
		visited[idx] = false;
		dfs(idx+1, count);
	}
	
	static void calculate() {
		int a = 0;
		int b = 0;
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(visited[i] && visited[j]) {
					a += arr[i][j];
				} else if(!visited[i] && !visited[j]) {
					b += arr[i][j];
				}
			}
		}
		int diff = Math.abs(a-b);
		min = Math.min(min, diff);
	}
}