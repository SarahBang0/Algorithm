package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV4_1231_중위순회 {
	
	static int N; // 노드 갯수
	static char[] tree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1 ; tc<=10 ; tc++) {
			
			N = Integer.parseInt(br.readLine()); // 노드 갯수 입력 받기
			tree = new char[N+1];
			
			// 트리 만들기
			for(int i=0 ; i<N ; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				
				tree[Integer.parseInt(token.nextToken())] = token.nextToken().charAt(0);
			}
			
			inOrder(1);
			
			System.out.println("#" + tc + " " + sb.toString());
			sb.delete(0, sb.length()-1);
		}
		
	}
	
	public static void inOrder(int current) {
		if(current > N) return;
		
		inOrder(current*2);
		sb.append(tree[current]);
		inOrder(current*2+1);
	}

}

// 왼쪽 자식 노드 : N*2
// 오른쪽 자식 노드 : N*2+1
