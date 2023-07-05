package dfs;

import java.util.Scanner;

public class Pratice1 {

    private static int n, m;
    private static final int[][] graph = new int[1000][1000];

    public static void main(String[] args) {
        // scanner
        Scanner sc = new Scanner(System.in);

        // n, m을 공백을 기준으로 구분하여 입력 받기
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

        // 모든 노드에 대하여 음료수 채우기
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 현재 위치에서 dfs 수행
                if(dfs(i, j)) {
                    result++;
                }
            }
        }

        // 정답 출력
        System.out.println("result :: " + result);
    }

    private static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우 즉시 종료
        if(x < 0 || x >= n || y < 0 || y >= m) return false;

        // 현재 노드를 아직 방문하지 않았다면
        if(graph[x][y] == 0) {
            // 해당 노드 방문처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우 위치도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);

            return true;
        }

        return false;
    }

}
