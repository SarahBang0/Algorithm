package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_LV4_1227_미로2 {
	
	// 상, 하, 좌, 우 이동 배열
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] maze = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = Integer.parseInt(br.readLine());
			
			// 현재 위치
			int startR = -1;
			int startC = -1;
			
			visited = new boolean[16][16];
			
			// 미로 세팅
			for(int i=0 ; i<100 ; i++) {
				String nums = br.readLine().trim();
				for(int j=0 ; j<100 ; j++) {
					maze[i][j] = nums.charAt(j)-'0';
					
					// 출발 지점 세팅
					if(maze[i][j] == 2) {
						startR = i;
						startC = j;
					}
				}
			}
			
			int result = bfs(startR, startC);
			
			System.out.println("#" + tc + " "+ result);
		}
	}
	
	public static int bfs(int r, int c) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		
		
		// 큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			
			int[] current = queue.poll();
			int currentR = current[0];
			int currentC = current[1];
			
			// poll 했을 때 3이 나오면 도착
			if(maze[currentR][currentC]==3) {
				return 1;
			}
			
			// 사방 탐색해서 길이 있으면 queue.offer
			for(int i=0 ; i<4 ; i++) {
				int nextR = currentR +dr[i];
				int nextC = currentC +dc[i];
				
				if(nextR>=0 && nextR<100 && nextC>=0 && nextC<100) {
					// maze[nextR][nextC]==0 으로 하면 도착지점 만났을 때 넘어가버림.
					if(maze[nextR][nextC]!=1 && !visited[nextR][nextC]) {
						visited[nextR][nextC] = true;
						queue.offer(new int[] {nextR, nextC});
					}
				}
				
			}
		}
		
		
		return 0;
	}
}