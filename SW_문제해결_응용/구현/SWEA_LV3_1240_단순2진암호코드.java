package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_LV3_1240_단순2진암호코드 {
	
	// Java 9 이상
//	static List<String> bit = List.of("0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011");
	static List<String> bit = Arrays.asList("0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011");
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String size = br.readLine();
			StringTokenizer token = new StringTokenizer(size);
			int N = Integer.parseInt(token.nextToken()); // 배열의 세로 크기
			int M = Integer.parseInt(token.nextToken()); // 배열의 가로 크기
			
			int[][] codes = new int[N][M];
			
			// 비트 배열 만들기
			for(int i=0 ; i<N ; i++) {
				String str = br.readLine();
				for(int j=0 ; j<M ; j++) {
					codes[i][j] = str.charAt(j)-'0';
				}
			}
			
			// 비트 시작점
			int startR = 0;
			int startC = 0;
			boolean findStart = false;
			
			// end 찾기 (거꾸로 스캔)
			for(int i=N-1 ; i>=0 ; i--) {
				for(int j=M-1 ; j>=0 ; j--) {
					if(codes[i][j] == 1) {
						startR = i;
						startC = j-55;
						findStart = true;
						break;
					}
				}
				// 시작 지점을 찾았다면 탈출
				if(findStart) break;
			}
			
			int[] num = new int[8];
			int idx = 0;
			
			// 7비트씩 잘라서 -> bit랑 매핑해서 num에 인덱스 번호 넣기
			for(int i=startC ; i<=startC+54 ; i+=7) {
				String s = "";
				for(int m=0 ; m<7 ; m++) {
					s += String.valueOf(codes[startR][i+m]);
				}
				num[idx++] = bit.indexOf(s);
			}
			
			int sumOdd = 0;
			int sumEven = 0;
			
			for(int i=0 ; i<8 ; i++) {
				if(i%2==0) {
					sumOdd += num[i];
				} else {
					sumEven += num[i];
				}
			}
			
			int result = ((sumOdd *3) + sumEven)%10==0 ? sumOdd + sumEven : 0;
			
			System.out.println("#" + test_case + " " + result);
			
			

		}
	}
}

// 올바른 암호코드 = (홀수 자리의 합 *3) + (짝수 자리의 합) -> 10의 배수 
// 잘못된 암호코드라면 0 출력

// 뒤에서부터 거꾸로 스캔하면서 end 찾고, 시작 범위는 end-55 (모든 숫자의 마지막 비트는 1)
