package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_LV5_1238_Contact {

    static class Node {
        List<Integer> next = new ArrayList<>(); // 연결된 노드들 인덱스 저장
    }
    static Node[] tree; // 연락 받을 수 있는 사람이 100명까지라서
    static int[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1 ; tc<=10 ; tc++) {

            sb.append("#").append(tc);

            StringTokenizer token = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(token.nextToken()); //입력 받는 데이터 길이
            int S = Integer.parseInt(token.nextToken()); // 시작점

            tree = new Node[101];
            visited = new int[101];

            token = new StringTokenizer(br.readLine());
            while(token.hasMoreTokens()) {
                int from = Integer.parseInt(token.nextToken()); // 시작 노드
                int to = Integer.parseInt(token.nextToken()); // 도착 노드

                if (tree[from] == null) {
                    tree[from] = new Node();
                    tree[from].next.add(to);
                } else {
                    tree[from].next.add(to);
                }

            }


            int result = bfs(S);
            sb.append(" ").append(result).append("\n");
        }
        System.out.println(sb);

    }

    static int bfs(int start) {
        int result = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(start);
        visited[start] = 1; // 첫번째 방문

        while(!dq.isEmpty()) {
            int nodeIdx = dq.pollFirst();
            Node node = tree[nodeIdx];
            int visitedCount = visited[nodeIdx];

            if(node == null)  { // 더 이상 갈 수 없음
                continue;
            }

            for(int n : node.next) {
                if(visited[n]==0) {
                    dq.offerLast(n);
                    visited[n] = visitedCount + 1;
                }
            }
        }

        int max = 0;

        for(int i=1 ; i<=100; i++) {
            if(max <= visited[i]) {
                max = visited[i];
                result = i;
            }
        }
        return result;
    }


    //    static void bfs(int start) {
//        int idx = 1;
//        Deque<int[]> dq = new ArrayDeque<>();
//        dq.offerLast(new int[]{start, idx}); // 시작 노드 인덱스와 순서 번호 쌍
//        visited[start] = true;
//
//        while(!dq.isEmpty()) {
//
//            int[] current = dq.pollFirst();
//            Node currentNode= tree[current[0]];
//            int currentIdx = current[1];
//
//            if(currentNode == null) return; // 존재하지 않으면 끝
//
//            idx++;
//
//            for (int n : currentNode.next) {
//                dq.offerLast(new int[]{n, idx}); // 같은 차례에 들어가는 노드는 같은 순서
//                visited[n] = true;
//            }
//
//            while(dq.peekFirst()[1]==currentIdx) { // 순서가 같은 노드들까지 진행
//
//            }
//        }
//
//        // 현재 idx와 같은 노드들을 찾아서 max 찾기
//
//    }

}


//빨간 원은 연락을 시작하는 당번
// 비상연락망 가동 -> 시작 당번이 동시에 연락 가동

// visited 로 연락을 받았는지 체크
// 연결된 사람들로 쭉쭉 타고 내려가다 더이상 못가면 끝
// 마지막에 동시에 연락 받은 사람 중 숫자가 가장 큰 사람