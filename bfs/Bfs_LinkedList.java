package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java BRS LinkedList 연습
 */
public class Bfs_LinkedList {

    public static void main(String[] args) {
        Bfs.bfs(1);
    }

}

class Bfs {

    // queue
    private static Queue<Integer> queue = new LinkedList<>();

    // 노드 방문 처리용 배열
    private static boolean[] visited = new boolean[9];

    // 각 노드가 연결된 정보를 2차원 배열로 표현
    private static int[][] graph = {
            {}
            , {2, 3, 8}
            , {1, 7}
            , {1, 4, 5}
            , {3, 5}
            , {3, 4}
            , {7}
            , {2, 6, 8}
            , {1, 7}
    };

    public static void bfs(int start) {
        // queue 에 bfs를 시작할 노드 번호 삽입
        queue.offer(start);

        // 현재 노드를 방문 처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            // 큐에서 하나의 원소를 추출
            int nodeIndex = queue.poll();

            // 방문 노드 출력
            System.out.print(nodeIndex + " ");

            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int node : graph[nodeIndex]) {
                if(!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }
    }

}