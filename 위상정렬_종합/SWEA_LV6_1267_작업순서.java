package 위상정렬_종합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_LV6_1267_작업순서 {
	
	static int V, E;
	static int[][] adjArr;
	static int[] inDegree;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer token;
		
		for(int tc=1 ; tc<=10 ; tc++) {
			sb.append("#").append(tc);
			
			token = new StringTokenizer(br.readLine());
			V = Integer.parseInt(token.nextToken()); // 정점의 개수
			E = Integer.parseInt(token.nextToken()); // 간선의 개수
			
			adjArr = new int[V+1][V+1];
			inDegree = new int[V+1];
			
			token = new StringTokenizer(br.readLine()); // 간선 정보
			
			while(token.hasMoreTokens()) {
				int from = Integer.parseInt(token.nextToken());
				int to = Integer.parseInt(token.nextToken());
				
				adjArr[from][to] = 1;
				inDegree[to]++;
			}
			
			dfs();
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs() {
		Deque<Integer> dq = new ArrayDeque<>();
		
		// 진입차수가 0인 노드들 집어넣기
		for(int i=1 ; i<V+1 ; i++) {
			if(inDegree[i] == 0) {
				dq.offerLast(i);
			}
		}
		
		while(!dq.isEmpty()) {
			int current = dq.pollFirst();
			sb.append(" ").append(current);
			
			for(int i=1 ; i<V+1 ; i++) {
				if(adjArr[current][i]==1) { // 연결되어 있다면?
					adjArr[current][i] = 0;
					inDegree[i]--;
					if(inDegree[i] == 0) dq.offerLast(i);
				}
			}
		}
	}
}
