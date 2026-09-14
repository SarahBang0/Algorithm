package DFS;

import java.util.*;
import java.io.*;

class Solution
{
    static boolean[] visited;
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case);
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N];

            for(int i=0 ; i<N ; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j=0 ; j<N ; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            dfs(0, 0);

            sb.append(" ").append(min).append("\n");
            min = Integer.MAX_VALUE;
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int count) { // 재료 인덱스, 뽑은 재료 갯수
        if(count == N/2) { // 재료가 N/2개 만큼 뽑혔다면 두 음식 맛의 차이 구하기
            calculate();
            return;
        }

        if(idx == N) return;

        // idx번째 재료를 음식에 넣는 경우
        visited[idx] = true;
        dfs(idx+1, count+1);

        // idx번째 재료를 음식에 안 넣는 경우
        visited[idx] = false;
        dfs(idx+1, count);
    }

    static void calculate() {
        int a = 0;
        int b = 0;

        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<N ; j++) {
                if(visited[i] && visited[j]) {
                    a += arr[i][j];
                } else if (!visited[i] && !visited[j]) {
                    b += arr[i][j];
                }
            }
        }

        int diff = Math.abs(a-b);
        min = Math.min(diff, min);
    }
}