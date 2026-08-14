package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_LV3_1216_회문2 {
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int tc = Integer.parseInt(br.readLine());
            
            char[][] arr = new char[100][100];
            
            // 글자판 생성
            for(int i=0 ; i<100 ; i++) {
                String str = br.readLine();
            	int idx = 0;
                for(int j=0 ; j<100 ; j++) {
                    arr[i][j] = str.charAt(idx++);
                }
            }
            
            int max = 0;
            
            for(int i=0 ; i<100 ; i++) {
                for(int j=0 ; j<100 ; j++) {
                
                    // 가로로 확인 
                    for(int k=j ; k<100 ; k++) {
                        
                        int len = k-j+1; // 검사할 회문 길이
                        
                       boolean isPalindrome = true;
                        
                        // 시작 글자와 같다면?
                        if(arr[i][j] == arr[i][k]) {
                         // 회문 검사 로직
                          for(int m=0 ; m<len/2; m++) {
                              if(arr[i][j+m] != arr[i][k-m]) {
                                  isPalindrome = false;
                                  break;
                              }
                          }
                            if(isPalindrome) {
                       		// 최댓값 업데이트 로직
							max = Math.max(max, k-j+1);
                            }
                        }
                    }
                        
                    // 세로로 확인
                    for(int k=i ; k<100 ; k++) {
                        
                    int len = k-i+1; // 검사할 회문 길이
                        
                       boolean isPalindrome = true;
                        
                         // 시작 글자와 같다면?
                        if(arr[i][j] == arr[k][j]) {
                         // 회문 검사 로직
                          for(int m=0 ; m<len/2; m++) {
                              if(arr[i+m][j] != arr[k-m][j]) {
                                  isPalindrome = false;
                                  break;
                              }
                          }
                            if(isPalindrome) {
                       		// 최댓값 업데이트 로직
							max = Math.max(max, k-i+1);
                            }
                        }
                    }
     
                }
            }
        System.out.println("#" + tc + " " + max);
        }
	}

}