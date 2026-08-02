package week02;

import java.util.Scanner;
import java.io.FileInputStream;


public class SWEA_LV2_1954_달팽이숫자 {
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt(); //테스트 케이스 갯수

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int size = sc.nextInt();
            int[][] arr = new int[size][size];
            
            // 우, 하, 좌, 상
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            
           // 현재 방향
            int dir = 0;
            
            // 현재 위치 
            int row = 0;
            int col = 0;
            
           	for(int i=1 ; i<=size*size ; i++) {
                arr[row][col] = i;
                // 다음 칸 계산
                int nr = row + dr[dir];
                int nc = col + dc[dir];
                
                // 값이 넘어가면 방향 전환 
                if(nr < 0 || nc < 0 || nr >= size || nc >= size || arr[nr][nc]!=0) {
                    dir = (dir+1) % 4;
                    nr = row + dr[dir];
                    nc = col + dc[dir];
                }
                // 현재 위치 변경
                row = nr;
                col = nc;
            }

            // 출력
            System.out.println("#" + test_case);
            for(int i=0 ; i<arr.length ; i++) {
                for(int j=0 ; j<arr[i].length ; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
		}
	}
}

