package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV4_1232_사칙연산 {
	
	static int N; // 트리 사이즈
	static Node[] nodes;
	
	static class Node {
		String val; 
		int left;
		int right;
		
		Node(String val, int left, int right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int tc=1 ; tc<=10 ; tc++) {
			
			N = Integer.parseInt(br.readLine());
			nodes = new Node[N+1];
			
			for(int i=0 ; i<N ; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(token.nextToken()); // 노드 인덱스 
				String value = token.nextToken();
				
				int leftChild = 0;
				int rightChild = 0;
				
				// 뒤에 입력 받을 것이 더 있으면 자식 노드 파싱
				if(token.hasMoreElements()) {
					leftChild = Integer.parseInt(token.nextToken());
					rightChild = Integer.parseInt(token.nextToken());
				}
				
				nodes[idx] = new Node(value, leftChild, rightChild);
			}
			
			
		}
	}
	

	
}



// 노드 연산은 postOrder (L -> R -> 중간)