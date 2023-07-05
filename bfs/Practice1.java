package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {

    private int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

public class Practice1 {

    private static int n, m;

    private static int[][] graph = new int[201][201];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        // queue
        Queue<Node> queue = new LinkedList<>();

        // queue에 bfs를 시작할 노드 삽입
        queue.offer(new Node(x, y));

        // queue가 빌 때까지
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeX = node.getX();
            int nodeY = node.getY();

            // 현재 위치에서 4가지 방향으로의 위치 확인
            for(int i = 0; i < 4; i++) {
                int nx = nodeX + dx[i];
                int ny = nodeY + dy[i];

                // 미로찾기 공간을 벗어날 경우 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if(graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if(graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[nodeX][nodeY] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        // 가장 오른쪽 아래까지의 최단거리 반환
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m을 공백을 기준으로 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        // 버퍼 지우기
        sc.nextLine();

        // 2차원 리스트의 맵 정보 입력받기
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // bfs 수행 결과 출력
        System.out.println(bfs(0, 0));
    }

}
