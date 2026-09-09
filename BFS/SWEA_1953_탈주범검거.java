package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {

    static int[][] tunnel;
    static boolean[][] visited;
    static int N, M, R, C, L;
    static boolean[][] type = {
            {}, // 상 하 좌 우
            {true, true, true, true}, // + 모양
            {true, true, false, false}, // 상하
            {false, false, true, true}, // 좌우
            {true, false, false, true}, // 상우
            {false, true, false, true}, // 하우
            {false, true, true, false}, // 하좌
            {true, false, true, false} // 상좌
    };
    static int[] opp = {1,0,3,2}; // 반대 방향 매핑
    // 상 하 좌 우
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++) {
            sb.append("#").append(tc);
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken()); // 터널 세로 크기
            M = Integer.parseInt(token.nextToken()); // 터널 가로 크기
            R = Integer.parseInt(token.nextToken()); // 맨홀 뚜껑의 세로 위치
            C = Integer.parseInt(token.nextToken()); // 맨홀 뚜껑의 가로 위치
            L = Integer.parseInt(token.nextToken()); // 탈출 후 소요된 시간

            tunnel = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0 ; i<N ; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j=0 ; j<M ; j++) {
                    tunnel[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int result = bfs();
            sb.append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] {R, C, 1}); // 맨홀 뚜껑 위치
        visited[R][C] = true;
        int count = 1;

        while(!dq.isEmpty()) {

            int[] current = dq.pollFirst();
            int r = current[0];
            int c = current[1];
            int currentTime = current[2];

            if(currentTime == L) continue;

            // 해당 위치의 터널 종류 확인
            int pipe = tunnel[r][c];

            // 4방향 탐색
            for(int i=0 ; i<4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 배열 범위 확인
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                // 방문한 곳인지 확인
                if(visited[nr][nc]) continue;
                // 터널 존재 여부 확인
                if(tunnel[nr][nc]==0) continue;

                int nextPipe = tunnel[nr][nc]; // 이동하려는 터널 종류

                // 터널이 연결되어 있는지 확인
                // 현재 터널에서 해당 방향으로 열려 있고, 다음 터널에서 반대 방향으로 열려 있을 경우
                if(type[pipe][i] && type[nextPipe][opp[i]]) {
                    visited[nr][nc] = true;
                    dq.offerLast(new int[] {nr,nc, currentTime+1});
                    count++;
                }
            }
        }
        return count;
    }
}
