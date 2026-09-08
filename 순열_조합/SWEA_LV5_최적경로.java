package 순열_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_LV5_최적경로 {
	static int N;
	static List<int[]> distance;
	static int endX, endY;
	static int distanceMin = Integer.MAX_VALUE;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			sb.append("#").append(tc);
			N = Integer.parseInt(br.readLine()); // 고객의 수
			
			distance = new ArrayList<>();
			visited = new boolean[N];
			token = new StringTokenizer(br.readLine());
			
			int startX = Integer.parseInt(token.nextToken()); // 회사 x좌표
			int startY = Integer.parseInt(token.nextToken()); // 회사 y좌표
			endX = Integer.parseInt(token.nextToken()); // 집 x좌표
			endY = Integer.parseInt(token.nextToken()); // 집 y좌표
			
			while(token.hasMoreTokens()) {
				int x = Integer.parseInt(token.nextToken());
				int y = Integer.parseInt(token.nextToken());
				distance.add(new int[] {x,y});
			}
			
			per(startX, startY, 0, 0);
			
			sb.append(" ").append(distanceMin).append("\n");
			distanceMin = Integer.MAX_VALUE;
		}
		System.out.println(sb);
		
		
	}
	static void per(int x, int y, int idx, int sum) {
		if(idx == N) { // N개 집 모두 방문 완료
			distanceMin = Math.min(distanceMin, sum);
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			if(visited[i]) continue; // 방문한 집이면 pass
			int[] current = distance.get(i);
			int currentX = current[0];
			int currentY = current[1];
			int tmp = Math.abs(x-currentX) + Math.abs(y-currentY); 
					
			visited[i] = true;
			per(currentX, currentY, idx+1, sum+tmp);
			visited[i] = false;
		}
	}

}
