package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_LV3_1219_길찾기1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case=1 ; test_case<=10 ; test_case++) {
			
			String size = br.readLine();
			StringTokenizer token = new StringTokenizer(size);
			
			int tc = Integer.parseInt(token.nextToken());
			int len = Integer.parseInt(token.nextToken()); // 길의 총 개수
			
			String nums = br.readLine();
			token = new StringTokenizer(nums);
			
			int[] arr1 = new int[100];
			int[] arr2 = new int[100];
			boolean[] visited = new boolean[100];
			
			Arrays.fill(arr1, -1);
			Arrays.fill(arr2, -1);
			
			// 배열 세팅
			for(int i=0 ; i<len ; i++) {
				int from = Integer.parseInt(token.nextToken());
				int to = Integer.parseInt(token.nextToken());
				
				// 저장이 안된 상태라면
				if(arr1[from] == -1) {
					arr1[from] = to;
				} else if(arr2[from] ==-1) {
					arr2[from] = to;
				}
			}
			
			Stack<Integer> stack = new Stack<>();
			stack.push(0); // 시작 지점 
			
			int result = 0;
			
			while(!stack.isEmpty()) {
				
				int current = stack.pop();
				
				// 맨 마지막 노드에 도착했다면?
				if(current==99) {
					result = 1;
					break;
				}
				
				// 이미 방문 한 노드라면?
				if(visited[current]) continue;
				
				// 해당 노드 방문 처리
				visited[current] = true;
				
				// 첫번째 길이 있다면
				if(arr1[current]!=-1 && !visited[arr1[current]]) {
					stack.push(arr1[current]);
				} 
				
				// 두번째 길이 있다면 
				if(arr2[current]!= -1 && !visited[arr2[current]]) {
					stack.push(arr2[current]);
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
		

}
