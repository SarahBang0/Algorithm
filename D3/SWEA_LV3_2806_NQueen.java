package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_2806_NQueen {
	
	static int N;
	static int[] board;
	static int count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int test_case=1 ; test_case<=tc ; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			board = new int[N];
			count = 0; 
			
			nQueen(0);
			
			System.out.println("#" + test_case + " " + count);
		}
		
	}
	
	// 첫 번째 열부터 검사
	static void nQueen(int col) {
		if(col == N) {
			count++;
			return;
		}
		
		for(int row=0 ; row<N ; row++) {
			board[col] = row;
			if(isPromising(col)) {
				nQueen(col+1);
			}
		}
	}
	
	static boolean isPromising(int col) {
		// 0부터 현재 열-1까지 검사하면서 들어갈 수 있는지 확인
		for(int i=0 ; i<col ; i++) {
			
			// 같은 행에 있는지 확인
			if(board[i] == board[col]) return false;

			// 대각선 상에 있는지 확인
			if(Math.abs(i-col)==Math.abs(board[i]-board[col])) return false;				
		}
		return true;
	}

}
