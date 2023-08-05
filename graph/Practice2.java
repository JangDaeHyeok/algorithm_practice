package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice2 {

    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화
    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    public static ArrayList<KruskalEdge> edges = new ArrayList<>();
    public static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            // 비용순으로 정렬하기 위해서 튜플의 첫 번째 원소를 비용으로 설정
            edges.add(new KruskalEdge(cost, a, b));
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges);
        int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선

        for(KruskalEdge edge : edges) {
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if(findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                last = cost; // 오름차순으로 정리되어있기 때문에 집합에 포함하는것들 중 가장 큰 간선 정보 저장
            }
        }

        // 결과 출력
        // 결과에서 가장 큰 간선을 제거하여 2개의 최소 신장 트리로 분할된 값 출력
        System.out.println(result - last);
    }

    // 특정 원소가 속한 집합 찾기
    public static int findParent(int x) {
        if(parent[x] == x)
            return x;

        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

}
