package 종합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어디에단어가들어갈수있을까 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			sb.append("#").append(test_case);
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(token.nextToken()); // 세로 길이
			int K = Integer.parseInt(token.nextToken()); // 단어의 길이
			
			int[][] arr = new int[N][N];
			
			// 배열 세팅
			for(int i=0 ; i<N ; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0 ; j<N ; j++) {
					arr[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			
			// 흰 부분은 1, 검정 부분은 0
			
			int count = 0;
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					
					// 흰색이라면 로직 수행
					if(arr[i][j] == 1) {
						// 1. 가로 검사
						// 이 전 블럭 -> j==0 이거나 j-1이 검정인지 && 단어길이를 더했을때 범위 내인지
						if((j==0 || arr[i][j-1]==0) && j+K <N) {
							
							boolean isPosible1 = true;
							// 글자 길이가 들어가는지 확인
							for(int n=j ; n<j+K ; n++) {
								if(arr[i][n]==0) { // 글자 길이 내에 검정 블럭이 있다면
									isPosible1 = false; // false로 바꾸고 break;
									break;
								}
							}
							
							if(isPosible1) { // 글자길이가 확인됐으면 그 다음자리가 벽인지, 검정인지 확인
								if(j+K >= N || arr[i][j+K]==0) {
									count++;
								}
							}
							
						}
						
						// 2. 세로 검사
						// 이 전 블럭 -> i==0 이거나 i-1이 검정이고 && 단어길이 더했을때 범위 내인지
						if((i==0 || arr[i-1][j]==0) && i+K <N) {
							
							boolean isPosible2 = true;
							//글자가 들어가는지 확인
							for(int n=i ; n<i+K ; n++) {
								if(arr[n][j]==0) { // 글자 길이 내에 검정이 있다면
									isPosible2 = false;
									break;	
								}
							}
							
							if(isPosible2) {
								if(i+K >= N || arr[i+K][j]==0) {
									count++;
								}
							}
						}
					}
					
					
					
				}
			}
			
			sb.append(" ").append(count).append("\n");
			
		}
		
		System.out.println(sb);
	}
}