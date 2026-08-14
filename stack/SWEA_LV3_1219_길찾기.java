package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_LV3_1219_길찾기 {
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = sc.nextInt(); // 테스트 케이스 번호
			int nums = sc.nextInt(); // 길의 갯수
			
			int[] arr1 = new int[100];
			int[] arr2 = new int[100];
			boolean[] visited = new boolean[100]; // 방문했는지 확인 용도
			
			Arrays.fill(arr1, -1);
			Arrays.fill(arr2, -1);
			
			for(int i=0 ; i<nums ; i++) {
				int from = sc.nextInt(); // 출발
				int to = sc.nextInt(); // 도착
				
				if(arr1[from] == -1) { // 첫번째 길이 비어있다면
					arr1[from] = to;
				} else {
					arr2[from] = to; 
				}
			}
			
			Stack<Integer> stack = new Stack<>();
			stack.push(0); // 시작 지점
			
			int ans = 0; // 도착 여부 저장
			
			while(!stack.isEmpty()) {
				int current = stack.pop(); 
				
				// 만약 current가 99라면 break
				if(current == 99) {
					ans = 1;
					break;
				}
				
				// 이미 방문했다면 continue
				if(visited[current]) {
					continue;
				}
				visited[current] = true;
				
				// 첫번재 경로가 -1이 아니고, 아직 방문하지 않았다면
				if(arr1[current]!=-1 && !visited[arr1[current]]) {
					stack.push(arr1[current]);
				}
				// 두번째 경로가 -1이 아니고, 아직 방문하지 않았다면
				if(arr2[current]!=-1 && !visited[arr2[current]]) {
					stack.push(arr2[current]);
				}
			}
			
			System.out.println("#" + tc + " " + ans);
			
		
		}
	}
}

// 0번(A) 도시에서 출발하여 도착점 99번(B) 도시까지 이동할 수 있는 경로가 단 하나라도 존재하는지 확인
// 모든 길은 한쪽 방향으로 이동 가능한 일방통행
