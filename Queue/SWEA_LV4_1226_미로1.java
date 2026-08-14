package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_LV4_1226_미로1 {
	
	static int[][] maze = new int[16][16];
	static boolean[][] visited;
	
	// 상, 하, 좌, 우 이동 배열
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			// 테스트 케이스 번호
			int tc = Integer.parseInt(br.readLine().trim());
			
			// 출발점 위치 선언 
			int startR = -1, startC = -1;
			
			visited = new boolean[16][16]; // 매 테스트 케이스마다 초기화
			
			
			// 미로 데이터 입력받기
			for(int i=0 ; i<16 ; i++) {
				// 한 줄 받아오기
				String line = br.readLine().trim();
				
				for(int j=0 ; j<16 ; j++) {
					maze[i][j] = line.charAt(j)-'0';
					
					// 출발점 위치 저장	
					if(maze[i][j]==2) {
						startR = i;
						startC = j;
					}
				}
			}
			
			// BFS 수행 
			int result = bfs(startR, startC);
		
			System.out.println("#" + tc + " " + result);
		}
	}
	
	public static int bfs(int startR, int startC) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		// 시작점 큐 투입 및 방문 처리 
		queue.offer(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		
		
		// 큐가 빌 때까지 탐색
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];
			
			// 도착점 (3)을 만나면 성공(1) 반환
			if(maze[r][c]==3) {
				return 1;
			}
			
			// 사방 탐색
			for(int i=0 ; i<4 ; i++) {
				int nextR = r + dr[i];
				int nextC = c + dc[i];
				
				// 상, 하, 좌, 우가 길이라면 queue에 offer
				if(nextR>=0 && nextR<16 && nextC>=0 && nextR<16) {
					if(maze[nextR][nextC]!=1 && !visited[nextR][nextC]) {
						visited[nextR][nextC] = true; // 방문 처리
						queue.offer(new int[] {nextR, nextC});
					}
				}
			}
			
		}
		
		return 0;
	}
}