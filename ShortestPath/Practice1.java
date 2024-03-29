package ShortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class Practice1 {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정

    // 노드의 개수(n), 간선의 개수 (m), 거쳐 갈 노드(k), 최종 목적지 노드(x)
    public static int n, m, k, x;

    // 2차원 배열(그래프 표현)을 만들기
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            graph[a][a] = 0;
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A와 B가 서로에게 가는 비용은 1이라고 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for(int k = 0; k <= n; k++) {
            for(int a = 0; a <= n; a++) {
                for(int b = 0; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과 출력 (1부터 k까지, k부터 x까지의 거리)
        int distance = graph[1][k] + graph[k][x];

        // 도달할 수 없는 경우, -1을 출력
        if (distance >= INF) {
            System.out.println(-1);
        }
        // 도달할 수 있다면, 최단 거리를 출력
        else {
            System.out.println(distance);
        }
    }

}
