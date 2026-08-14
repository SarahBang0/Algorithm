package week05;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_LV3_1215_회문1 {
	
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int len = sc.nextInt(); // 회문 글자 길이
            
			char[][] arr = new char[8][8];
            
            // 글자판 만들기
            for(int i=0 ; i<8 ; i++) {
                String str = sc.next();
                int idx = 0;
                for(int j=0 ; j<8 ; j++) {
                    arr[i][j] = str.charAt(idx++);
                }
            }
            
            int count = 0; // 회문 글자 갯수
            
            // 가로 검사
            for(int i=0 ; i<8 ; i++) {
            	for(int j=0 ; j<8-len+1 ; j++) {
            		
            		boolean isPanlidrome = true;
            		
            		// 회문 체크 로직
            		for(int k=0 ; k<len/2 ; k++) {
            			if(arr[i][k+j] != arr[i][j+len-k-1]) {
            				isPanlidrome = false;
            				break;
            			}
            		}
            		
            		if(isPanlidrome) count++;
            	}
            }
            
            // 세로 검사
            for(int i=0 ; i<8-len+1 ; i++) {
            	for(int j=0 ; j<8 ; j++) {
            		
            		boolean isPanlidrome = true;
            		
            		// 회문 체크 로직
            		for(int k=0 ; k<len/2; k++) {
            			if(arr[k+i][j] != arr[i+len-1-k][j]) {
            				isPanlidrome = false;
            				break;
            			}
            		}
            		
            		if(isPanlidrome) count++;
            	}
            }
            
            System.out.println("#" + test_case + " "+ count);
		
		}
	}
}