package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_LV4_중위순회 {
	
	static StringBuilder sb = new StringBuilder();
	static char[] tree;
	static int N;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1 ; t<=10 ; t++) {
			
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			tree = new char[N+1];
			
			// 트리 만들기
			for(int i=1 ; i<=N ; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				token.nextToken(); // 인덱스 번호인데 없어도 됨
				tree[i] = token.nextToken().charAt(0);
			}
			
			inOrder(1);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void inOrder(int current) {
//		sb.append(" ");
		if(current > N) {
			return;
		}
		inOrder(current*2);
		sb.append(tree[current]);
		inOrder(current*2+1);
	}
}