package dfs;

/**
 * Java DFS 재귀 구현 연습
 */
public class Dfs_Recursion {

    public static void main(String[] args) {
        Dfs.dfs(1);
    }

}

class Dfs {

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

    public static void dfs(int nodeIndex) {
        // 현재 노드를 방문처리
        visited[nodeIndex] = true;

        // 방문 노드 출력
        System.out.print(nodeIndex + " ");

        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for(int node : graph[nodeIndex]) {
            if(!visited[node])
                dfs(node);
        }
    }

}
