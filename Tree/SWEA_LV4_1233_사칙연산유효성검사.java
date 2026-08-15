package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV4_1233_사칙연산유효성검사 {
	
	static int N;
	static char[] tree;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1 ; tc<=10 ; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			tree = new char[N+1];
			
			// 트리 만들기
			for(int i=0 ; i<N ; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				
				tree[Integer.parseInt(token.nextToken())] = token.nextToken().charAt(0);
			}
			
			int result = checkTree(1);
			
			System.out.println("#" + tc + " " + result);
			
		}		
	}
	
	public static int checkTree(int current) {
		// 현재 노드가 트리 노드보다 크다면 return 1
		if(current > N) return 1;
		
		// 왼쪽, 오른쪽 자식 노드 있는지 확인
		int left = checkTree(current*2);
		int right = checkTree(current*2+1);
		
		// 자식 중 하나라도 유효하지 않다면 바로 return 0
		if(left==0 || right==0) return 0;
		
		
		// 자식 노드 존재 여부 확인
		boolean hasChild = (current*2 <=N);
		
		// 왼쪽, 오른쪽 다시 노드 둘다 있다면
		if(hasChild) {
			// 해당 연산자인지 확인 
			return (!Character.isDigit(tree[current])) ? 1 : 0;
		} else { // 리프 노드라면 숫자인지 확인
			return (Character.isDigit(tree[current])) ? 1 : 0;
		}
		
	}

}
// 자식 노드가 있는 경우에는 연산자.
// 리프 노드는 숫자


