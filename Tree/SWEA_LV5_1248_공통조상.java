package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV5_1248_공통조상 {
	
	static class Node {
		int left;
		int right;
	}
	static Node[] tree;
	static int[] parent; // 부모 노드 번호를 넣는 배열
	static int V; // 정점 갯수

	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case);
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			V = Integer.parseInt(token.nextToken()); // 정점의 갯수
			int E = Integer.parseInt(token.nextToken()); // 간선의 갯수
			int targetA = Integer.parseInt(token.nextToken()); // 공통 조상을 찾는 정점 번호 a
			int targetB = Integer.parseInt(token.nextToken()); // 공통 조상을 찾는 정점 번호 b
			
			tree = new Node[V+1];
			parent = new int[V+1];
			
			// 트리에 노드를 모두 생성해두기
			for(int i=1 ; i<=V ; i++) {
				tree[i] = new Node();
			}
			
			// 트리 만들기
			token = new StringTokenizer(br.readLine()); // E개 만큼의 (부모, 노드) 쌍 -> 간선
			for(int i=0 ; i<E ; i++) {
				int p = Integer.parseInt(token.nextToken());
				int c = Integer.parseInt(token.nextToken());
				
				// 자식에 부모 정보 기록
				parent[c] = p;
				
				// 부모에 자식 정보 기록
				if(tree[p].left == 0) { // 왼쪽 자식이 비어있으면 왼쪽부터 저장
					tree[p].left = c;
				} else { // 왼쪽 자식이 있다면 오른쪽에 저장
					tree[p].right = c;
				}
			}
			
			boolean[] visitedA = new boolean[V+1];
			
			// targetA부터 부모노드를 타고 올라가면서 visitedA에 방문 표시
			int current = targetA;

			while(current != 0) { // 0이 나올때까지 올라간다
				visitedA[current] = true; // 해당 노드 방문 표시
				current = parent[current]; // 현재 위치를 부모 노드로 이동시키기
			}
			
			int tmp = targetB;
			
			// targetB에서부터 다시 올라가면서 visitedA에서 가장 먼저 true를 만나는 순간 -> 조상 노드
			while(!visitedA[tmp]) {
				tmp = parent[tmp]; // 부모 노드로 올라가기
			} // 끝났을 때는 조상 노드가 tmpB에 저장됨 
			
	
//			System.out.println(tmp); // 조상 노드 구함
			
			// 조상노드에서 밑에 딸린 노드들 갯수 구하기 -> DFS로 구현
			int result = dfs(tmp);
			
			sb.append(" ").append(tmp).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	// current 부터 쭉 타고 내려가서 하나씩 갯수를 샌다
	static int dfs(int current) {
		
		// 자식 노드로 들어왔을 때 자식이 없는 경우
		if(current > V || current == 0) return 0; // current == 0 만 검사해도 가능
		
		Node node = tree[current]; // 해당 위치의 노드를 꺼내고
		
		int left = dfs(node.left);
		int right = dfs(node.right);
		
		return 1+left+right;
	}
}