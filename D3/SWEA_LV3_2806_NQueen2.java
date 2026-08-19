package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_LV3_2806_NQueen2 {
	
	static int N;
	static int[] board;
	static int count;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			count = 0;
			N = Integer.parseInt(br.readLine());
			board = new int[N]; // 인덱스=열, 값=행
			
			nQueen(0); // 0열부터 검사 시작

			System.out.println("#" + test_case + " " + count);

		}
	}
	
	static void nQueen(int col) {
		if(col==N) {
			count++;
			return;
		}
		
		// 해당 열 칸에 행 번호를 하나씩 넣어 본다
		for(int row=0 ; row<N ; row++) {
			board[col] = row;
			
			// 해당 열에 행 번호를 넣고, 0열부터 해당 열-1까지 순회하면서 들어갈 수 있는 자리인지 확인
			if(isPromising(col)) {
				// 그 다음 열로 이동해서 계속 진행
				nQueen(col+1); 
			}
		}
	}
	
	static boolean isPromising(int col) {
		for(int i=0 ; i<col ; i++) {
			// 같은 행 번호인지 확인
			if(board[i]==board[col]) return false;
			// 대각선 상에 있는지 확인
			if(Math.abs(i-col)==Math.abs(board[i]-board[col])) return false;
		}
		return true;
	}
}
// NxN 체스판에 N개의 퀸을 서로 공격하지 못하도록 놓는 경우의 수 구하기
