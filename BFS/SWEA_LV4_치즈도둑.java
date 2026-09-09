package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_LV4_치즈도둑 {
	
	static int N;
	static int[][] cheese;
	static boolean[][] eaten;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case);
			
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			eaten = new boolean[N][N]; // 요정이 먹었는지 안먹었는지 체크
			int max = Integer.MIN_VALUE;
			
			for(int i=0 ; i<N ; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0 ; j<N ; j++) {
					cheese[i][j] = Integer.parseInt(token.nextToken());
					max = Math.max(max, cheese[i][j]);
				}
			}
			int result = Integer.MIN_VALUE;
			
			for(int i=0 ; i<=max ; i++) {
				
				int count = bfs(i); 				
				if(count==0) break;
				eaten = new boolean[N][N];
				result = Math.max(max, count);
			}
			
			sb.append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int day) {
		
		Deque<int[]> q = new ArrayDeque<>();
		int count = 0;
		
		// 시작지점 찾기
		for(int n=0 ; n<N ; n++) {
			for(int m=0 ; m<N ; m++) {
				
				if(cheese[n][m]>day && !eaten[n][m]) {
					q.offer(new int[] {n, m});
					eaten[n][m] = true;
					
					while(!q.isEmpty()) {
						int[] current = q.poll();
						int currentR = current[0];
						int currentC = current[1];
						
						for(int k=0 ; k<4; k++) {
							int nr = currentR + dr[k];
							int nc = currentC + dc[k];
							
							if(nr<0 || nr >= N || nc<0 || nc>=N) continue;
							if(cheese[nr][nc]<=day) continue;
							if(eaten[nr][nc]) continue;
							
							q.offer(new int[] {nr,nc});
							eaten[nr][nc] = true;
						}
					}
					count++;
				}
			}
			
		}
		return count;
					
	}
}
