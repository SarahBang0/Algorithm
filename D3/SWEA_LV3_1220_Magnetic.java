package D3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_LV3_1220_Magnetic {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1 ; tc<=10 ; tc++) {			
			
			int size = Integer.parseInt(br.readLine());
			
			int[][] board = new int[100][100];
			
			StringTokenizer token;
			
			int deadLock = 0; // 남는 자석의 개수
			
			// 자석 세팅
			for(int i=0 ; i<100 ; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0 ; j<100 ; j++) {
					board[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			
			for(int i=0 ; i<100 ; i++) { // 열 
			
				boolean isNExist = false;
				
				for(int j=0 ; j<100 ; j++) { // 행
					
					// N자석을 만났다면 
					if(board[j][i]==1) {
						isNExist = true; // N이 존재함을 표시
					} else if (board[j][i]==2) { // S를 만났다면
						if(isNExist) { // S를 만났는데, 위에 N이 존재하는 상태라면 -> 교착상태
							deadLock++; // 교착상태 갯수+
							isNExist = false; // 다시 초기화
						}
					}					
				}
			}
			
			System.out.println("#" + tc + " " + deadLock);
		}
	}
}